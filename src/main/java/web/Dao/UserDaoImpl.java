package web.Dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void setUser(User user) {
        em.persist(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUser(long id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserByLogin(String login) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.login = :login", User.class);
        query.setParameter("login", login);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(getUser(id).orElse(null));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }




}
