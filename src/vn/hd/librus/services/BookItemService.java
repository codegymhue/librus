package vn.hd.librus.services;

import vn.hd.librus.Constants;
import vn.hd.librus.model.BookItem;
import vn.hd.librus.utils.CSVUtils;

import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BookItemService implements IBookItemService {
    public final static String PATH = "data/book-items.csv";
    private static BookItemService instance;

    private BookItemService() {
    }

    public static BookItemService getInstance() {
        if (instance == null)
            instance = new BookItemService();
        return instance;
    }

    @Override
    public List<BookItem> findAll() {
        List<BookItem> books = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            books.add(BookItem.parse(record));
        }
        return books;
    }

    @Override
    public BookItem findById(long id) {
        List<BookItem> bookItems = findAll();
        for (BookItem bookItem : bookItems) {
            if (bookItem.getBookItemID() == id)
                return bookItem;
        }
        return null;
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }

    @Override
    public BookItem findByBarcode(long barcode) {
        List<BookItem> bookItems = findAll();
        for (BookItem bookItem : bookItems) {
            if (bookItem.getBarcode() == barcode) {
                return bookItem;
            }
        }
        return null;
    }

    @Override
    public boolean existByBarcode(long barcode) {
        return findByBarcode(barcode) != null;
    }



    @Override
    public void checkForFine(String barcode) {


    }

    @Override
    public boolean renewBookItem(BookItem bookItem) {
        return false;
    }

    @Override
    public void returnBookItem(BookItem bookItem) {

    }


    @Override
    public void add(BookItem newBook) {
        BookItem bookItem = new BookItem();
        List<BookItem> books = findAll();
        newBook.setBookId(System.currentTimeMillis() / 1000);
        Instant now = Instant.now();
        bookItem.setBorrowedAt(now);

        Instant dueAt =  Instant.now().plus(Period.ofDays(Constants.MAX_LENDING_DAYS));
        bookItem.setDueAt(dueAt);

        bookItem.setDateOfPurchase(now);
        bookItem.setPublicationAt(1);
        books.add(newBook);
        CSVUtils.write(PATH, books);
    }

    @Override
    public void update(BookItem newBook) {
        List<BookItem> books = findAll();
        for (BookItem book : books) {

        }
    }

}
