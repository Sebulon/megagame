package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.ships.Ship;

/**
 * Class representing a player and at what ship it is on.
 */
public class Player {

    public final String id;

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
