package com.chalmersmegagame.game.players;

import javax.persistence.*;

import com.chalmersmegagame.game.ships.Ship;
import com.chalmersmegagame.game.teams.Team;

/**
 * Class representing a player and at what ship it is on.
 */

 @Entity
public class Player {

    @Id
    public final String id;

    @ManyToOne
    public final Team team;
    
    @Transient
    private Ship boardedShip;

    public Player(String id, Team team) {
        this.id = id;
        this.team = team;
    }

    public Ship getBoardedShip() {
        return boardedShip;
    }

    public void setBoardedShip(Ship boardedShip) {
        this.boardedShip = boardedShip;
    }

}
