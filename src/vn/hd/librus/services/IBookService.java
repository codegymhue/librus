package vn.hd.librus.services;

import vn.hd.librus.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(long id);

    void add(Book newBook);

    void update(Book newBook);

    Book findByISBN(String isbn);

    boolean existByISBN(String isbn);

    void deleteById(long id);

    boolean existsById(long id);

    List<Book> findAllByTitle(String title);

    List<Book> findAllByAuthor(String author);
}
