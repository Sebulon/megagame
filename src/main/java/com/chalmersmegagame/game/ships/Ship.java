package com.chalmersmegagame.game.ships;

public abstract class Ship implements IShip{

    private int crewSize;
    private double HP;
    private String faction;

    
    @Override
    public int getCrewSize() {
        return crewSize;
    }

    @Override
    public double getHP() {
        return HP;
    }

    @Override
    public String getFaction() {
        return faction;
    }

    @Override
    public void modifyCrewSize(int change) {
        int newCrewSize = crewSize + change;
        if(newCrewSize > 0){
            crewSize = newCrewSize;
        }else{
            crewSize = 0;
        }
        
    }

    @Override
    public void modifyHP(int change) {
        double newHP = HP + change;
        if(newHP > 0){
            HP = newHP;
        }else{
            HP = 0;
        }
        
    }

    @Override
    public void setCrewSize(int newCrewSize) {
        if(newCrewSize < 0){
            throw new IllegalArgumentException("Negative crewsizes not allowed");
        }else{
            crewSize = newCrewSize;
        }
    }

    @Override
    public void setHP(double newHP) {
        if(newHP < 0){
            throw new IllegalArgumentException("Negative HP not allowed");
        }else{
            HP = newHP;
        }
    }

    @Override
    public void setFaction(String faction) {
        this.faction = faction;   
    }

            
}
