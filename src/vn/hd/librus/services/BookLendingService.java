package vn.hd.librus.services;

import vn.hd.librus.Constants;
import vn.hd.librus.model.*;
import vn.hd.librus.utils.CSVUtils;

import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BookLendingService implements IBookLendingService {
    public final static String PATH = "data/book-lending.csv";
    private IBookItemService bookItemService;

    private static BookLendingService instance;

    private BookLendingService() {
        bookItemService = BookItemService.getInstance();
    }

    public static BookLendingService getInstance() {
        if (instance == null)
            instance = new BookLendingService();
        return instance;
    }

    @Override
    public List<BookLending> findAll() {
        List<BookLending> bookLendingList = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            bookLendingList.add(BookLending.parse(record));
        }
        return bookLendingList;
    }


    @Override
    public BookLending findById(long id) {
        List<BookLending> bookLendingList = findAll();
        for (BookLending BookLending : bookLendingList) {
            if (BookLending.getId() == id)
                return BookLending;
        }
        return null;
    }

    public BookLending findByUserId (long userId){
        List <BookLending> bookLendingList = findAll();
        for (BookLending bookLending : bookLendingList){
            if(bookLending.getUserId() == userId)
                return bookLending;
        }
        return null;
    }

    @Override
    public boolean isBookIssuedQuotaExceeded(long userId) {
        return countBookItemLendingByUserIdAndStatus(userId) >= Constants.MAX_BOOKS_ISSUED_TO_A_USER;
    }

    @Override
    public int countBookItemLendingByUserIdAndStatus(long userId) {
        int count = 0;
        List<BookLending> bookLendingList = findAll();
        for (BookLending bookLending : bookLendingList)
            //tim lending co status != Return && userId ==userId tham so
            if (bookLending.getStatus() != LendingStatus.RETURN &&
                    bookLending.getUserId() == userId)
                count += 1;
        return count;
    }



    @Override
    public void lendBook(long userId, long bookItemId) {
        BookItem bookItem = bookItemService.findById(bookItemId);
        BookLending newBookLending = new BookLending();

        newBookLending.setBookItemId(bookItemId);
        newBookLending.setUserId(userId);
        newBookLending.setStatus(LendingStatus.DUE);
        Instant now = Instant.now();
        newBookLending.setCreatedAt(now);

//        Instant dueAt = Instant.ofEpochMilli(now.toEpochMilli());
        Instant dueAt = now.plus(Period.ofDays(Constants.MAX_LENDING_DAYS));
        newBookLending.setDueAt(dueAt);
        bookItem.setBorrowedAt(now);
        bookItem.setDueAt(dueAt);
        bookItem.setStatus(BookStatus.LOANED);
        bookItemService.update(bookItem);
        add(newBookLending);
    }

    public void returnBook (long bookItemId){
        List<BookLending> bookLendingList = findAll();
        BookItem bookItem = bookItemService.findById(bookItemId);
        BookLending newBookLending = new BookLending();
        newBookLending.setReturnAt(Instant.now());
        newBookLending.setCreatedAt(null);
        newBookLending.setDueAt(null);
        newBookLending.setStatus(LendingStatus.RETURN);
        CSVUtils.write(PATH,bookLendingList);
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }


    @Override
    public void add(BookLending newBookLending) {
        List<BookLending> bookLendingList = findAll();
        newBookLending.setId(System.currentTimeMillis() / 1000);
        bookLendingList.add(newBookLending);
        CSVUtils.write(PATH, bookLendingList);
    }

    @Override
    public void update(BookLending newBookLending) {
        List<BookLending> bookLendingList = findAll();
        for (BookLending bookLending : bookLendingList) {
            if (bookLending.getId() == newBookLending.getId()){
                LendingStatus status = newBookLending.getStatus();
                if (status != null)
                    bookLending.setStatus(newBookLending.getStatus());

                Instant createdAt = newBookLending.getCreatedAt();
                if (createdAt != null)
                    bookLending.setCreatedAt(newBookLending.getCreatedAt());

                Instant dueAt = newBookLending.getDueAt();
                if (dueAt != null)
                    bookLending.setDueAt(newBookLending.getDueAt());
                CSVUtils.write(PATH,bookLendingList);

            }
        }
    }

}
