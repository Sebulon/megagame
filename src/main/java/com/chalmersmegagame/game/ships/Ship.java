package com.chalmersmegagame.game.ships;

import javax.persistence.*;

@MappedSuperclass
public abstract class Ship implements IShip{

    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String name;
    private int crewSize;
    private int HP;
    private int maxHP;
    private String faction;
    
    
    @Override
    public int getCrewSize() {
        return crewSize;
    }

    @Override
    public int getHP() {
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
        int newHP = HP + change;
        if(newHP > maxHP){
            HP = maxHP;
        }else if(newHP > 0){
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
    public void setHP(int newHP) {
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
    public int getMaxHP() {
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
