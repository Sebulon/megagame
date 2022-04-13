package com.chalmersmegagame.game.ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.chalmersmegagame.game.game_resources.*;
import com.chalmersmegagame.game.minigames.Morale.MoraleMinigame;
import com.chalmersmegagame.game.teams.*;

import lombok.Data;

@Entity
@Data
public class PlayerShip extends Ship implements IHasResources, IHasTeam {

    @ElementCollection
    private Map<String, Integer> resources = new HashMap<>();
    @OneToOne
    private Team team;
    @OneToOne(mappedBy = "playerShip", cascade=CascadeType.ALL)
    private MoraleMinigame moraleMinigame;

    public PlayerShip() {
    }

    public PlayerShip(Team team, String shipName, String faction, int maxHP, int crewSize) {
        this.team = team;
        setName(shipName);
        setFaction(faction);

        addResource("Food", 10);
        addResource("Water", 0);
        addResource("Fuel", 50);
        addResource("Materials", 30);

        setMaxHP(maxHP);
        setHP(maxHP);

        setCrewSize(crewSize);

        moraleMinigame = new MoraleMinigame(this);
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
