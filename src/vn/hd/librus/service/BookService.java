package vn.hd.librus.service;


import vn.hd.librus.model.Book;
import vn.hd.librus.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookService implements IBookService {
    public final  static String PATH = "data/book.csv";
    private static BookService instance;
    private BookService(){}

    public static BookService getInstance() {
        if (instance == null)
            instance = new BookService();
        return instance;
    }

    @Override
    public List<Book> findAll() {
        List <Book> books = new ArrayList<>();
        List <String> records = CSVUtils.readData(PATH);
        for (String record : records){
            books.add(Book.parse(record));
        }
        return books;
    }

    @Override
    public void add(Book newBook) {
        List<Book> books = findAll();
        books.add(newBook);
        CSVUtils.writeData(PATH, books);
    }

    @Override
    public void update(Book newBook) {
        List <Book> books = findAll();
        for ( Book book : books){
            if (book.getISBN()== newBook.getISBN()){
                String title = newBook.getTitle();
                if (title != null && !title.isEmpty())
                    book.setTitle(newBook.getTitle());

                String author = newBook.getAuthor();
                if (author !=null)
                    book.setAuthor(newBook.getAuthor());

                String subject = newBook.getSubject();
                if (subject !=null)
                    book.setSubject(newBook.getSubject());

                String publisher = newBook.getPublisher();
                if (publisher !=null)
                    book.setPublisher(newBook.getPublisher());

                String language = newBook.getLanguage();
                if (language !=null)
                    book.setLanguage(newBook.getLanguage());

                Integer numberOfPage = newBook.getNumberOfPage();
                if (numberOfPage !=null)
                    book.setNumberOfPage(newBook.getNumberOfPage());
            }
        }

    }

    @Override
    public Book findByISBN(int ISBN) {
        List <Book> books = findAll();
        for (Book book : books ) {
            if (book.getISBN().equals(ISBN))
                return book;
        }
        return null ;
    }

    @Override
    public boolean exist(int ISBN) {
        return findByISBN(ISBN) !=null;
    }

    @Override
    public boolean existByTitle(String title) {
        List <Book> books = findAll();
        for (Book book : books){
            if (book.getTitle().equals(title))
                return true;
        }

        return false;
    }

    @Override
    public boolean existByISBN(int ISBN) {
        List <Book> books = findAll();
        for (Book book : books){
            if (book.getISBN().equals(ISBN))
                return true;
        }
        return false;
    }

    @Override
    public void removeByISBN(int ISBN) {
        List <Book> books = findAll();
        books.removeIf(new Predicate<Book>() {
            @Override
            public boolean test(Book book) {
                return book.getISBN().equals(ISBN) ;
            }
        });
    CSVUtils.writeData(PATH,books);
    }
}
