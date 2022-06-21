package vn.hd.librus.services;

import vn.hd.librus.model.BookItem;
import vn.hd.librus.model.Fine;
import vn.hd.librus.model.User;
import vn.hd.librus.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FineService implements IFineService {
    public final static String PATH = "data/books.csv";
    private static FineService instance;
    private UserService userService;
    private BookLendingService bookLendingService;
    private BookItemService bookItemService;

    private FineService() {
        userService = UserService.getInstance();
        bookLendingService = BookLendingService.getInstance();
        bookItemService = BookItemService.getInstance();
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
        //tim user , vuot qua ngay thi nop phat
        User user = userService.findById(userId);

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

        }
    }


}
