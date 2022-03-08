package com.chalmersmegagame.game.ships;

import java.util.ArrayList;
import java.util.HashMap;

import com.chalmersmegagame.game.game_resources.*;
import com.chalmersmegagame.game.teams.*;

public class PlayerShip extends Ship implements IHasResources, IHasTeam{

    private HashMap<String, Integer> resources = new HashMap<>();
    private Team team;

    public PlayerShip(){};

    public PlayerShip(Team team, String shipName, String faction, int maxHP){
        this.team = team;
        setName(shipName);
        setFaction(faction);

        resources.put("Food", 0);
        resources.put("Water", 0);
        resources.put("Fuel", 0);
        resources.put("Materials", 0);

    }

    @Override
    public ArrayList<String> getResources() {
        return new ArrayList<String>(resources.keySet());
    }

    @Override
    public HashMap<String, Integer> getResourceQuantities() {
        return resources;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public void addResource(String resourceName, int quantity) {
        if(resources.containsKey(resourceName)){
            int oldQuantity = resources.get(resourceName);
            resources.put(resourceName, oldQuantity + quantity);
        }else{
            resources.put(resourceName, quantity);
        }
        
    }

    @Override
    public void removeResource(String resourceName, int quantity) {
        if(resources.containsKey(resourceName)){
            int oldQuantity = resources.get(resourceName);
            int newQuantity = oldQuantity - quantity;

            if(newQuantity < 0){
                throw new RuntimeException("Can not remove " + quantity + " " + resourceName + ", only has " + oldQuantity);
            }else{
                resources.put(resourceName, newQuantity);
            }
            
        }else{
            throw new IllegalArgumentException("This ship doesn't have the resource: " + resourceName);
        }
        
    }


    
}
