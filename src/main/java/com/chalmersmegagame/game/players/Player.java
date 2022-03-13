package com.chalmersmegagame.game.players;

import javax.persistence.*;

import com.chalmersmegagame.game.ships.Ship;

/**
 * Class representing a player and at what ship it is on.
 */

 @Entity
public class Player {

    @Id
    public final String id;
    
    @Transient
    private Ship boardedShip;

    public Player(String id) {
        this.id = id;
    }

    public Ship getBoardedShip() {
        return boardedShip;
    }

    public void setBoardedShip(Ship boardedShip) {
        this.boardedShip = boardedShip;
    }

}