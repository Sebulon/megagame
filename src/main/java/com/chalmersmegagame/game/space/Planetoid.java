package com.chalmersmegagame.game.space;

import com.chalmersmegagame.game.game_resources.IHasResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity 
public class Planetoid extends CelestialBody implements IHasResources {

    @ElementCollection
    private Map<String, Integer> resources = new HashMap<>();
    @OneToMany
    private List<Planetoid> satellites = new ArrayList<>();
    private int satelliteWeight;

    public Planetoid(){}

    public Planetoid (int size, Enum type){
        this.size = size;
        this.type = type;
    }

    public Planetoid (int size, Enum type, Planetoid satellite){
        if (satellite.size >= this.size){
            throw new IllegalArgumentException("Satellite is too large");
        }
        this.size = size;
        this.type = type;
        this.satellites.add(satellite);
        this.satelliteWeight += satellite.size;
    }

    public Planetoid (int size, Enum type, ArrayList<Planetoid> satellites){
        if (satellites.stream().mapToInt(Planetoid :: getSize).sum() >= satelliteWeight){
            throw new IllegalArgumentException("The total size of the satellites is too large");
        }
        this.size = size;
        this.type = type;
        this.satellites = satellites;
        satelliteWeight += satellites.stream().mapToInt(Planetoid :: getSize).sum();
    }

    public List<Planetoid> getSatellites() {
        return satellites;
    }

    public void addSatellite(Planetoid satellite) {
        if (satellite.size >= this.size) {
            throw new IllegalArgumentException("Satellite is too large");
        }
        if (satelliteWeight + satellite.size >= size){
            throw new IllegalArgumentException("Satellite is either too large or the orbits are full");
        }
        this.satellites.add(satellite);
        satelliteWeight += satellite.size;
    }

    @Override
    public ArrayList<String> getResources() {
        return new ArrayList<>(this.resources.keySet());
    }

    @Override
    public Map<String, Integer> getResourceQuantities() {
        return resources;
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

    public enum PlanetoidTypes{
        HABITABLE,
        APOCALYPTIC,
        TOXIC,
        FROZEN,
        MOLTEN,
        BARREN,
        GAS_GIANT,
        BROKEN,
        ASTEROID
    }

}
