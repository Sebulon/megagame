package com.chalmersmegagame.game.players;

import javax.persistence.*;

import com.chalmersmegagame.game.roles.Role;
import com.chalmersmegagame.game.ships.Ship;
import lombok.Data;

/**
 * Class representing a player and at what ship it is on.
 */

@Entity
@Data
public class Player {

    @Id
    private String id;

    @Transient
    private Ship boardedShip;

    // TODO: Should not only be captain
    private Role role = Role.Captain;

    public Player() {
    }

    public Player(String id) {
        this.id = id;
    }

    public String getDescription() {
        return role.getDescription();
    }

    public String getMiniGameDescription() {
        return role.getMiniGameDescription();
    }
}
