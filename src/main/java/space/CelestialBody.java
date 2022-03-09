package space;

import java.util.ArrayList;

public abstract class CelestialBody implements ICelestialObject {

    protected String type;
    protected ArrayList<Feature> features;
    protected int distance;
    protected int size;

    @Override
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

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
