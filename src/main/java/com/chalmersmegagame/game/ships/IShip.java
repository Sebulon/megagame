package com.chalmersmegagame.game.ships;

public interface IShip {
    double getHP();
    void setHP(double newHP);
    void modifyHP(int change);

    int getCrewSize();
    void setCrewSize(int newCrewSize);
    void modifyCrewSize(int change);

    String getFaction();
    void setFaction(String faction);
    

}