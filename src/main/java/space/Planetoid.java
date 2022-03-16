package space;

import com.chalmersmegagame.game.game_resources.IHasResources;

import java.util.ArrayList;
import java.util.HashMap;

public class Planetoid extends CelestialBody implements IHasResources {

    private HashMap<String, Integer> resources = new HashMap<>();
    HashMap<String, Integer> resourceQuantities;
    ArrayList<Planetoid> satellites = new ArrayList<>();
    private int satelliteWeight;
    private boolean isSatellite;

    public Planetoid (int size, String type){
        if (!typeHandler.getPlanetoidTypes().contains(type)){
            throw new IllegalArgumentException("Illegal type");
        }
        this.size = size;
        this.type = type;
    }

    public Planetoid (int size, String type, Planetoid satellite){
        if (satellite.size >= this.size){
            throw new IllegalArgumentException("Satellite is too large");
        }
        this.size = size;
        this.type = type;
        satellite.setSatellite(true);
        this.satellites.add(satellite);
        this.satelliteWeight += satellite.size;
    }

    public Planetoid (int size, String type, ArrayList<Planetoid> satellites){
        if (satellites.stream().mapToInt(Planetoid :: getSize).sum() >= satelliteWeight){
            throw new IllegalArgumentException("The total size of the satellites is too large");
        }
        this.size = size;
        this.type = type;
        this.satellites = satellites;
        satelliteWeight += satellites.stream().mapToInt(Planetoid :: getSize).sum();
    }

    public ArrayList<Planetoid> getSatellites() {
        return satellites;
    }

    public void addSatellite(Planetoid satellite) {
        if (satellite.size >= this.size) {
            throw new IllegalArgumentException("Satellite is too large");
        }
        if (satelliteWeight + satellite.size >= size){
            throw new IllegalArgumentException("Satellite is either too large or the orbits are full");
        }
        satellite.setSatellite(true);
        this.satellites.add(satellite);
        satelliteWeight += satellite.size;
    }

    @Override
    public ArrayList<String> getResources() {
        return new ArrayList<String>(this.resources.keySet());
    }

    @Override
    public HashMap<String, Integer> getResourceQuantities() {
        return this.resourceQuantities;
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

    public boolean isSatellite() {
        return isSatellite;
    }

    public void setSatellite(boolean satellite) {
        this.isSatellite = satellite;
    }
}
