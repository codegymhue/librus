package vn.hd.librus.sort;

import vn.hd.librus.model.Book;

import java.util.Comparator;

public class SortByIsbnDESC  implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o2.getIsbn().compareTo(o1.getIsbn());
    }
}

