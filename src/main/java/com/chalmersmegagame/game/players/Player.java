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

    // TODO: Should not only be captain
    @Enumerated(EnumType.STRING)
    private Role role; 

    public Player() {
    }

    public Player(String id) {
        this.id = id;
    }

    public Player(String id, String name, Role role){
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getRole(){
        return role.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
