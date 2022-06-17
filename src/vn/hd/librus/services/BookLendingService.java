package vn.hd.librus.services;

import vn.hd.librus.Constants;
import vn.hd.librus.model.BookItem;
import vn.hd.librus.model.BookLending;
import vn.hd.librus.model.BookStatus;
import vn.hd.librus.model.LendingStatus;
import vn.hd.librus.utils.CSVUtils;

import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BookLendingService implements IBookLendingService {
    public final static String PATH = "data/books.csv";
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
        List<BookLending> books = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            books.add(BookLending.parse(record));
        }
        return books;
    }

    @Override
    public BookLending findById(long id) {
        List<BookLending> bookItems = findAll();
        for (BookLending BookLending : bookItems) {
            if (BookLending.getId() == id)
                return BookLending;
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

        // findAll()
        //tim lending co status != Return && userId ==userId tham so

        return 0;
    }

    @Override
    public void lendBook(long userId, long bookItemId) {
        BookItem bookItem = bookItemService.findById(bookItemId);
        BookLending bookLending = new BookLending();
        bookLending.setId(System.currentTimeMillis() / 1000);
        bookLending.setBookItemId(bookItemId);
        bookLending.setUserId(userId);
       // bookLending.setStatus(LendingStatus.parseRole("DUE"));
        bookLending.setStatus(LendingStatus.DUE);
        Instant now = Instant.now();
        bookLending.setCreatedAt(now);

        Instant dueAt = Instant.ofEpochMilli(now.toEpochMilli());
        now.plus(Period.ofDays(Constants.MAX_LENDING_DAYS));
        bookLending.setDueAt(dueAt);

        bookItem.setStatus(BookStatus.LOANED);
        bookItemService.update(bookItem);

    }


    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }


    @Override
    public void add(BookLending newBook) {
        List<BookLending> books = findAll();
        books.add(newBook);
        CSVUtils.write(PATH, books);
    }

    @Override
    public void update(BookLending newBook) {
        List<BookLending> books = findAll();
        for (BookLending book : books) {

//            if (book.getIsbn() == newBook.getIsbn()) {
//                String title = newBook.getTitle();
//                if (title != null && !title.isEmpty())
//                    book.setTitle(newBook.getTitle());
//
//                String author = newBook.getAuthor();
//                if (author != null)
//                    book.setAuthor(newBook.getAuthor());
//
//                String subject = newBook.getSubject();
//                if (subject != null)
//                    book.setSubject(newBook.getSubject());
//
//                String publisher = newBook.getPublisher();
//                if (publisher != null)
//                    book.setPublisher(newBook.getPublisher());
//
//                String language = newBook.getLanguage();
//                if (language != null)
//                    book.setLanguage(newBook.getLanguage());
//
//                Integer numberOfPage = newBook.getNumberOfPages();
//                if (numberOfPage != null)
//                    book.setNumberOfPages(newBook.getNumberOfPages());
//            }
        }

    }


}
