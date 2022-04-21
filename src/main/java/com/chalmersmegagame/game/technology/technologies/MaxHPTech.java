package com.chalmersmegagame.game.technology.technologies;

import com.chalmersmegagame.game.ships.Ship;
import com.chalmersmegagame.game.technology.Technology;

public abstract class MaxHPTech extends Technology {
    private Ship ship;
    private int newMaxHP;

    public MaxHPTech (Ship ship, int newMaxHP){
        if (newMaxHP < this.ship.getMaxHP()){
            throw new IllegalArgumentException("The new Max HP is too low");
        }
        this.ship = ship;
        this.newMaxHP = newMaxHP;
    }
    @Override
    public void activate (){
        ship.setMaxHP(newMaxHP);
        this.setResearched(true);
    }

}
