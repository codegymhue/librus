package vn.hd.librus.services;

import vn.hd.librus.model.BookItem;
import vn.hd.librus.model.BookLending;
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
        List<BookItem> bookItems = findAll();
        for (BookItem bookItem : bookItems){
            if (bookItem.getBarcode()== barcode){
                return bookItem;
            }
        }
        return null;
    }

    @Override
    public boolean existByBarcode(long barcode) {
        return findByBarcode(barcode) !=null;
    }

    @Override
    public boolean reserveBookItem(BookItem bookItem) {
        return false;
    }

    @Override
    public void checkout(BookItem bookItem) {
//        if(findByBarcode(bookItem.getBarcode()) !=null){
//            returnBookItem(bookItem);
//        }
    }

    @Override
    public void checkForFine(String barcode) {
//        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
//        Date dueDate = bookLending.getDueDate();
//        Date today = new Date();
//        // check if the book has been returned within the due date
//        if (today.compareTo(dueDate) > 0) {
//            long diff = todayDate.getTime() - dueDate.getTime();
//            long diffDays = diff / (24 * 60 * 60 * 1000);
//            Fine.collectFine(memberId, diffDays);
//        }

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
