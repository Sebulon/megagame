package com.chalmersmegagame.game.ships;

import javax.persistence.*;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class Ship implements IShip{

    @Id
    private String name;
    private int crewSize;
    private int HP;
    private int maxHP;
    private String faction;

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
    public void setName(String name) {
        if(name.length() == 0){
            throw new IllegalArgumentException("Names cannot be empty");
        }else{
            this.name = name;
        }
        
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
