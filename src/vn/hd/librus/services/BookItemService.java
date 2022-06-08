package vn.hd.librus.services;

import vn.hd.librus.model.BookItem;
import vn.hd.librus.utils.CSVUtils;

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
            if (bookItem.getId() == id)
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
        return null;
    }

    @Override
    public boolean existByBarcode(long barcode) {
        return false;
    }

    @Override
    public boolean reserveBookItem(BookItem bookItem) {
        return false;
    }

    @Override
    public void checkout(BookItem bookItem) {

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
        List<BookItem> books = findAll();
        newBook.setBookId(System.currentTimeMillis() / 1000);
        books.add(newBook);
        CSVUtils.write(PATH, books);
    }

    @Override
    public void update(BookItem newBook) {
        List<BookItem> books = findAll();
        for (BookItem book : books) {
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
