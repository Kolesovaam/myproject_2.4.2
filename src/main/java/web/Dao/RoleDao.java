package web.Dao;

import web.model.Role;

import java.util.Set;

public interface RoleDao {
    void setRole(Role role);
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
}
