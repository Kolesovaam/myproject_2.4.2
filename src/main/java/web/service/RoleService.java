package web.service;

import web.model.Role;
import web.model.User;

import java.util.Set;

public interface RoleService {
    void setRole(Role role);
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
    void updateUser(User user);
}
