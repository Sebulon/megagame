package com.chalmersmegagame.game.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/{role}/description")
    public String getDescription(@PathVariable String role) {
        return roleService.getDescription(role);
    }

    @RequestMapping("/{role}")
    public Role getRole(@PathVariable String role) {
        return roleService.getRole(role);
    }

    @RequestMapping("/all")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
