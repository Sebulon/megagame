package com.chalmersmegagame.game.roles;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleService {

    public String getDescription(Role role) {
        return role.getDescription();
    }

    public String getDescription(String roleName) {
        return getDescription(Role.valueOf(roleName));
    }

    public Role getRole(String role) {
        return Role.valueOf(role);
    }

    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }
}
