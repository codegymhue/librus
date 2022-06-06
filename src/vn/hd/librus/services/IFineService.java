package vn.hd.librus.services;

import vn.hd.librus.model.Fine;

import java.util.List;

public interface IFineService {
    List<Fine> findAll();

    void add(Fine newUser);

    void update(Fine newUser);

    boolean existById(long id);

    Fine findById(long id);

    void collectFine(long userId, long days);
}
