package com.chalmersmegagame.game.roles;

import org.springframework.stereotype.Service;

@Service
public class RoleService {
    
    public String getDescription(Role role){
        return role.getDescription();
    }

    public String getDescription(String roleName){
        return getDescription(Role.valueOf(roleName));
    }


}
