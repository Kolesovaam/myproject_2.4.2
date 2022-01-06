package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (login.equals("ADMIN")) {
            User user = new User("ADMIN", "ADMIN", "adm", "adm");
            user.addRole(new Role(2L, "ADMIN"));
            return user;
        }
        return userDao.getUserByLogin(login).orElse(null);
    }
}
