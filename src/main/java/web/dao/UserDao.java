package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    void add(User user);
    void delete(User user);
    void edit(User user);
}
