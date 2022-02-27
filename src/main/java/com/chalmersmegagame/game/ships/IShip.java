package com.chalmersmegagame.game.ships;

public interface IShip {
    int getHP();
    void setHP(int newHP);
    void modifyHP(int change);

    int getMaxHP();
    void setMaxHP(int maxHP);

    int getCrewSize();
    void setCrewSize(int newCrewSize);
    void modifyCrewSize(int change);

    String getFaction();
    void setFaction(String faction);

    String getName();
    void setName(String name);
    

}