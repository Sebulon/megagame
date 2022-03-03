package com.chalmersmegagame.game.ships;

public class TestShip extends Ship {

    private int crewSize;
    private int HP;
    private int maxHP;
    private String faction;
    private String name;

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
