package vn.hd.librus.services;

import vn.hd.librus.model.BookReservation;

import java.util.List;

public interface IFineService {
    List<BookReservation> findAll();

    void add(BookReservation newUser);

    void update(BookReservation newUser);

    boolean existById(int id);

    BookReservation findById(int id);

    void collectFine(long userId, long days);
}
