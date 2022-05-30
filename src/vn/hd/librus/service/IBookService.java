package vn.hd.librus.service;

import vn.hd.librus.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void add (Book newBook);
    void update (Book newBook);
    Book findByISBN (int ISBN);
    boolean exist(int ISBN);
    boolean existByTitle (String title);
    boolean existByISBN (int ISBN);
    void removeByISBN (int ISBN);




}
