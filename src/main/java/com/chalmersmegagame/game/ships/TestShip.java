package com.chalmersmegagame.game.ships;

import javax.persistence.Entity;

@Entity
public class TestShip extends Ship {

    /* these variables are here but unused solely for automatic JSON parsing with Spring Boot
    not entierly sure if still actually needed*/
    


    public TestShip(){

    }

    public TestShip(String shipName){
        setName(shipName);
        setFaction("The Covenant");
        setMaxHP(10);
        setHP(9);
        setCrewSize(100);

    }
    
}
