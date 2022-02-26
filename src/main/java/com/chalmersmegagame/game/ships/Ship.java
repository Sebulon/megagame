package com.chalmersmegagame.game.ships;

public abstract class Ship implements IShip{

    private int crewSize;
    private double HP;
    private double maxHP;
    private String faction;
    private String name;

    
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name.length() == 0){
            throw new IllegalArgumentException("Names cannot be empty");
        }else{
            this.name = name;
        }
        
    }

    @Override
    public double getMaxHP() {
        return maxHP;
    }

    @Override
    public void setMaxHP(int maxHP) {
        if(maxHP < 0){
            throw new IllegalArgumentException("Negative maxHP not allowed");
        }else{
            this.maxHP = maxHP;
        }

        if(HP > maxHP){
            setHP(maxHP);
        }
        
    }

            
}
