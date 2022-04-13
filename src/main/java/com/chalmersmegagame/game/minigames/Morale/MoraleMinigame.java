package com.chalmersmegagame.game.minigames.Morale;

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.*;

import com.chalmersmegagame.game.ships.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class MoraleMinigame{    
    @Id
    String ship;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "ship")
    @MapsId
    public PlayerShip playerShip;

    int moraleScore = 5;
    @ElementCollection
    Map<String, Integer> allocatedResources = new TreeMap<>();
    @ElementCollection
    Map<Integer, Integer> quantityMoraleImpact = new TreeMap<>();

    public MoraleMinigame(){}

    public MoraleMinigame(PlayerShip playerShip) {
        this.playerShip = playerShip;
        calcDemands();
    }

    public Map<String, Integer> getAllocatedResources() {
        return allocatedResources;
    }

    public void allocateResource(String resource, int quantity){
        int newQuantity = quantity;
        if(allocatedResources.containsKey(resource)){
            newQuantity += allocatedResources.get(resource);
        }
        allocatedResources.put(resource, newQuantity);
    }

    private void calcDemands(){
        int crewSize = playerShip.getCrewSize();

        int none = 0;
        int minimal = crewSize/4;
        int half = crewSize/2;
        int normal = crewSize;
        int luxurious = (int) (1.5*crewSize);

        quantityMoraleImpact.put(none, -4);
        quantityMoraleImpact.put(minimal, -2);
        quantityMoraleImpact.put(half, -1);
        quantityMoraleImpact.put(normal, 0);
        quantityMoraleImpact.put(luxurious, 2);

        quantityMoraleImpact.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void resolveMoraleCheck(){
        if(allocatedResources.containsKey("FOOD")){
            int quantityLevel = getMaxQuantityLevel(allocatedResources.get("FOOD"));
            moraleScore += getMoraleImpact(quantityLevel);
            allocatedResources.put("FOOD", allocatedResources.get("FOOD") - quantityLevel);
        }else{
            moraleScore += getMoraleImpact(0);
        }

        if(allocatedResources.containsKey("WATER")){
            int quantityLevel = getMaxQuantityLevel(allocatedResources.get("WATER"));
            moraleScore += getMoraleImpact(quantityLevel);
            allocatedResources.put("WATER", allocatedResources.get("WATER") - quantityLevel);
        }else{
            moraleScore += getMoraleImpact(0);
        }
    }

    private int getMoraleImpact(int allocatedQuantity){
        return quantityMoraleImpact.get(getMaxQuantityLevel(allocatedQuantity));
    }

    private int getMaxQuantityLevel(int allocatedQuantity){
        int quantityLevel = 0;

        for(Integer quantity : quantityMoraleImpact.keySet()){
            if(allocatedQuantity >= quantity){
                quantityLevel = quantity;
            } 
        }

        return quantityLevel;
    }



    

}
