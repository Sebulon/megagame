package space;

import java.util.ArrayList;

public abstract class CelestialBody implements ICelestialObject {

    private String type;
    private ArrayList<Feature> features;
    private int distance;
    private int size;

    public int getSize(){
        return size;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public ArrayList<Feature> getFeatures() {
        return features;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void addFeature(Feature feature) {
        features.add(feature);
    }

    @Override
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
