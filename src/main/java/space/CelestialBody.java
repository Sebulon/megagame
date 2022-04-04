package space;

import java.util.ArrayList;

public abstract class CelestialBody implements ICelestialObject {

    protected String type;
    protected ArrayList<Feature> features = new ArrayList<>();
    protected int size;
    protected TypeHandler typeHandler = TypeHandler.getInstance();

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public ArrayList<Feature> getFeatures() {
        return this.features;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void addFeature(Feature feature) {
        this.features.add(feature);
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
