package vn.hd.librus.services;

import vn.hd.librus.model.Fine;
import vn.hd.librus.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class FineService implements IFineService {
    public final static String PATH = "data/books.csv";
    private static FineService instance;

    private FineService() {
    }

    public static FineService getInstance() {
        if (instance == null)
            instance = new FineService();
        return instance;
    }

    @Override
    public List<Fine> findAll() {
        List<Fine> books = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            books.add(Fine.parse(record));
        }
        return books;
    }

    @Override
    public Fine findById(long id) {
        List<Fine> bookItems = findAll();
        for (Fine Fine : bookItems) {
            if (Fine.getId() == id)
                return Fine;
        }
        return null;
    }

    @Override
    public void collectFine(long userId, long days) {

    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }


    @Override
    public void add(Fine newBook) {
        List<Fine> books = findAll();
        books.add(newBook);
        CSVUtils.write(PATH, books);
    }

    @Override
    public void update(Fine newBook) {
        List<Fine> books = findAll();
        for (Fine book : books) {
//            if (book.getIsbn() == newBook.getIsbn()) {
//                String title = newBook.getTitle();
//                if (title != null && !title.isEmpty())
//                    book.setTitle(newBook.getTitle());
//
//                String author = newBook.getAuthor();
//                if (author != null)
//                    book.setAuthor(newBook.getAuthor());
//
//                String subject = newBook.getSubject();
//                if (subject != null)
//                    book.setSubject(newBook.getSubject());
//
//                String publisher = newBook.getPublisher();
//                if (publisher != null)
//                    book.setPublisher(newBook.getPublisher());
//
//                String language = newBook.getLanguage();
//                if (language != null)
//                    book.setLanguage(newBook.getLanguage());
//
//                Integer numberOfPage = newBook.getNumberOfPages();
//                if (numberOfPage != null)
//                    book.setNumberOfPages(newBook.getNumberOfPages());
//            }
        }

    }


}
