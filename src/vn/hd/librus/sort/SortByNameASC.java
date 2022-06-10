package vn.hd.librus.sort;

import vn.hd.librus.model.Book;

import java.util.Comparator;

public class SortByNameASC implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
