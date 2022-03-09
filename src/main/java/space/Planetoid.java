package space;

import com.chalmersmegagame.game.game_resources.IHasResources;

import java.util.ArrayList;
import java.util.HashMap;

public class Planetoid extends CelestialBody implements IHasResources {

    ArrayList<String> resources;
    HashMap<String, Integer> resourceQuantities;
    ArrayList<Planetoid> satellites;

    public Planetoid (int size, int distance, String type){
        this.size = size;
        this.distance = distance;
        this.type = type;
    }

    public ArrayList<Planetoid> getSatellites() {
        return satellites;
    }

    public void addSatellites(Planetoid satellite) {
        satellites.add(satellite);
    }

    @Override
    public ArrayList<String> getResources() {
        return resources;
    }

    @Override
    public HashMap<String, Integer> getResourceQuantities() {
        return resourceQuantities;
    }

    @Override
    public void addResource(String resourceName, int quantity) {

    }

    @Override
    public void removeResource(String resourceName, int quantity) {

    }
}
