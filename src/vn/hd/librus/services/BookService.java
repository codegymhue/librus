package vn.hd.librus.services;


import vn.hd.librus.model.Book;
import vn.hd.librus.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookService implements IBookService {
    public final static String PATH = "data/books.csv";
    private static BookService instance;

    private BookService() {
    }

    public static BookService getInstance() {
        if (instance == null)
            instance = new BookService();
        return instance;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            books.add(Book.parse(record));
        }
        return books;
    }

    @Override
    public Book findById(long id) {
        List<Book> books = findAll();
        for (Book book : books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }

    @Override
    public void add(Book newBook) {
        List<Book> books = findAll();
        newBook.setId(System.currentTimeMillis() / 1000);
        books.add(newBook);
        CSVUtils.write(PATH, books);
    }

    @Override
    public void update(Book newBook) {
        List<Book> books = findAll();
        for (Book book : books) {
            if (book.getId() == newBook.getId()) {
                String title = newBook.getTitle();
                if (title != null && !title.isEmpty())
                    book.setTitle(newBook.getTitle());

                String author = newBook.getAuthor();
                if (author != null)
                    book.setAuthor(newBook.getAuthor());

                String subject = newBook.getSubject();
                if (subject != null)
                    book.setSubject(newBook.getSubject());

                String publisher = newBook.getPublisher();
                if (publisher != null)
                    book.setPublisher(newBook.getPublisher());

                String language = newBook.getLanguage();
                if (language != null)
                    book.setLanguage(newBook.getLanguage());

                int numberOfPage = newBook.getNumberOfPages();
                if (numberOfPage != 0)
                    book.setNumberOfPages(newBook.getNumberOfPages());

                book.setUpdatedAt(Instant.now());
                CSVUtils.write(PATH, books);
            }
        }

    }

    @Override
    public Book findByISBN(String isbn) {
        List<Book> books = findAll();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn))
                return book;
        }
        return null;
    }

    @Override
    public boolean existByISBN(String isbn) {
        List<Book> books = findAll();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn))
                return true;
        }
        return false;
    }

    @Override
    public void deleteById(long id) {
        List<Book> books = findAll();
        books.removeIf(new Predicate<Book>() {
            @Override
            public boolean test(Book book) {
                return book.getId()==id;
            }
        });
        CSVUtils.write(PATH,books);
        }



    @Override
    public boolean existsById(long id) {
        return findById(id) != null;
    }
}
