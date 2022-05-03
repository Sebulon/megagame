package com.chalmersmegagame.game.ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.chalmersmegagame.game.game_resources.*;
import com.chalmersmegagame.game.minigames.GatherResource.GatherMinigame;
import com.chalmersmegagame.game.minigames.Morale.MoraleMinigame;
import com.chalmersmegagame.game.minigames.vaultle.VaultleMinigame;
import com.chalmersmegagame.game.teams.*;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class PlayerShip extends Ship implements IHasResources, IHasTeam {

    @ElementCollection
    private Map<String, Integer> resources = new HashMap<>();
    @OneToOne
    private Team team;
    /*
    @ToString.Exclude
    @OneToOne(mappedBy = "playerShip", cascade=CascadeType.ALL)
    private MoraleMinigame moraleMinigame;
    */
    @ToString.Exclude
    @OneToOne(mappedBy = "playerShip", cascade=CascadeType.ALL)
    private VaultleMinigame vaultleMinigame;

    
    public PlayerShip() {
    }

    public PlayerShip(Team team, String shipName, String faction, int maxHP, int crewSize) {
        this.team = team;
        setName(shipName);
        setFaction(faction);

        setResource("Food", 10);
        setResource("Water", 0);
        setResource("Fuel", 50);
        setResource("Materials", 30);

        setMaxHP(maxHP);
        setHP(maxHP);

        setCrewSize(crewSize);

        //When I tried to merge, I guess it commented out one of them? Or was the first one 
        //already commented out?
        //moraleMinigame = new MoraleMinigame(this);
        //moraleMinigame = new MoraleMinigame(this);
        vaultleMinigame = new VaultleMinigame(this);
    }

    @Override
    public ArrayList<String> getResources() {
        if(resources == null){
            return null;
        }
        return new ArrayList<String>(resources.keySet());
    }

    @Override
    public Map<String, Integer> getResourceQuantities() {
        return resources;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    public void setResource(String resourceName, int quantity){
        resources.put(resourceName, quantity);
    }

    @Override
    public void addResource(String resourceName, int quantity) {
        resourceName = resourceName.toUpperCase();

        if (quantity < 0) {
            throw new IllegalArgumentException("Add can not be negative");
        } else if (resources.containsKey(resourceName)) {
            int oldQuantity = resources.get(resourceName);
            int newQuantity = oldQuantity + quantity;
            resources.put(resourceName, newQuantity);
        } else {
            resources.put(resourceName, quantity);
        }

    }

    @Override
    public void removeResource(String resourceName, int quantity) {
        resourceName = resourceName.toUpperCase();

        if (quantity < 0) {
            throw new IllegalArgumentException("May not remove negative quantity, add instead");
        }

        if (resources.containsKey(resourceName)) {
            int oldQuantity = resources.get(resourceName);
            int newQuantity = oldQuantity - quantity;

            if (newQuantity < 0) {
                throw new IllegalArgumentException("Can not remove " + quantity + " " + resourceName + ", only has " + oldQuantity);
            } else {
                resources.put(resourceName, newQuantity);
            }

        } else {
            throw new IllegalArgumentException("This ship doesn't have the resource: " + resourceName);
        }
    }
}
