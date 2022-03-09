package space;

import java.util.ArrayList;

public interface ICelestialObject {

    public String getType();

    public int getSize();

    public ArrayList<Feature> getFeatures();

    public int getDistance();

    public void setType(String type);

    public void setSize(int size);

    public void addFeature(Feature feature);

    public void setDistance(int distance);
}
