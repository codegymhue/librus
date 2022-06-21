package vn.hd.librus.services;

import vn.hd.librus.model.BookItem;

import java.util.List;

public interface IBookItemService {
    abstract List<BookItem> findAll();

    BookItem findById(long id);

    boolean existById(long id);

    void add(BookItem newBook);

    void update(BookItem newBook);

    boolean renewBookItem(BookItem bookItem);

    void returnBookItem(BookItem bookItem);


}
