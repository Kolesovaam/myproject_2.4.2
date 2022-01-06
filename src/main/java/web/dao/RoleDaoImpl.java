package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void setRole(Role role) {
        entityManager.persist(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }


}
