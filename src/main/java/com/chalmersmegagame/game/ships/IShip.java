package com.chalmersmegagame.game.ships;

public interface IShip {
    double getHP();
    void setHP(double newHP);
    void modifyHP(int change);

    double getMaxHP();
    void setMaxHP(int maxHP);

    int getCrewSize();
    void setCrewSize(int newCrewSize);
    void modifyCrewSize(int change);

    String getFaction();
    void setFaction(String faction);

    String getName();
    void setName(String name);
    

}