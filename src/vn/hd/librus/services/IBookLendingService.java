package vn.hd.librus.services;

import vn.hd.librus.model.BookLending;
import vn.hd.librus.model.LendingStatus;

import java.util.List;

public interface IBookLendingService {


    List<BookLending> findAll();

    void add(BookLending newUser);

    void update(BookLending newUser);

    boolean isBookIssuedQuotaExceeded(long userId);

    int countBookItemLendingByUserIdAndStatus(long userId);

    void lendBook(long userId, long bookItemId);

    void returnBook(long bookItemId, long userId);

    BookLending findByBookItemIdAndUserIdAndStatus(long bookItemId, long userId, LendingStatus status);

    boolean existById(long id);

    BookLending findById(long id);

    BookLending findByUserId (long userId);
}
