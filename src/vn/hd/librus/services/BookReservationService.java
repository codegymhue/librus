//package vn.hd.librus.services;
//
//import vn.hd.librus.model.BookReservation;
//import vn.hd.librus.utils.CSVUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookReservationService  implements  IBookReservationService{
//    public final static String PATH = "data/books.csv";
//    private static BookReservationService instance;
//
//    private BookReservationService() {
//    }
//
//    public static BookReservationService getInstance() {
//        if (instance == null)
//            instance = new BookReservationService();
//        return instance;
//    }
//
//    @Override
//    public List<BookReservation> findAll() {
//        List<BookReservation> books = new ArrayList<>();
//        List<String> records = CSVUtils.read(PATH);
//        for (String record : records) {
//            books.add(BookReservation.parse(record));
//        }
//        return books;
//    }
//
//
//    @Override
//    public BookReservation findById(long id) {
//        List<BookReservation> bookItems = findAll();
//        for (BookReservation BookReservation : bookItems) {
//            if (BookReservation.getId() == id)
//                return BookReservation;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean existById(long id) {
//        return findById(id) != null;
//    }
//
//
//    @Override
//    public void add(BookReservation newBook) {
//        List<BookReservation> books = findAll();
//        books.add(newBook);
//        CSVUtils.write(PATH, books);
//    }
//
//    @Override
//    public void update(BookReservation newBook) {
//        List<BookReservation> books = findAll();
//        for (BookReservation book : books) {
////            if (book.getIsbn() == newBook.getIsbn()) {
////                String title = newBook.getTitle();
////                if (title != null && !title.isEmpty())
////                    book.setTitle(newBook.getTitle());
////
////                String author = newBook.getAuthor();
////                if (author != null)
////                    book.setAuthor(newBook.getAuthor());
////
////                String subject = newBook.getSubject();
////                if (subject != null)
////                    book.setSubject(newBook.getSubject());
////
////                String publisher = newBook.getPublisher();
////                if (publisher != null)
////                    book.setPublisher(newBook.getPublisher());
////
////                String language = newBook.getLanguage();
////                if (language != null)
////                    book.setLanguage(newBook.getLanguage());
////
////                Integer numberOfPage = newBook.getNumberOfPages();
////                if (numberOfPage != null)
////                    book.setNumberOfPages(newBook.getNumberOfPages());
////            }
//        }
//    }
//
//}
