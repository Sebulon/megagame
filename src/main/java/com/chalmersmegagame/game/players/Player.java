package com.chalmersmegagame.game.players;

import javax.persistence.*;

import com.chalmersmegagame.game.roles.Role;

/**
 * Class representing a player
 */

@Entity
public class Player {

    @Id
    private String id;

    private String name;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    public Player() {
    }

    public Player(String id) {
        this.id = id;
    }

    public Player(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role != null ? role.getName() : null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setRole(Role role) {
        if (this.role != null) throw new IllegalStateException("Should not change role if already assigned");

        this.role = role;
    }
}
