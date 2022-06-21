package vn.hd.librus.services;

import vn.hd.librus.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

//    public User getCurrentUser(long Id);

    public User login(String username,String password);

    void add(User newUser);

    void update(User newUser);

    boolean existById(long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);

    User findById(long id);

    void blockMember(long id);

    void unBlockMember(long id);


}
