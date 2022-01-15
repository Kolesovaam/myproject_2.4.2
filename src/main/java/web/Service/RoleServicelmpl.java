package web.Service;

import web.Dao.RoleDao;
import web.model.Role;
import web.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("roleService")
public class RoleServicelmpl implements RoleService {

    private final RoleDao roleDao;


    public RoleServicelmpl(@Qualifier("roleDao")RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void setRole(Role role) {
        roleDao.setRole(role);
    }
    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    public void updateUser(User user){
        Set<Role> temp = new HashSet<>();
        user.getRoles().forEach(role -> temp.add(getRoleByName(role.getName())));
        user.setRoles(temp);
    }
}
