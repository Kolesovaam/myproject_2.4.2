package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUsers();
    void setUser(User user);
    Optional<User> getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);
    Optional<User> getUserByLogin(String login);
}
