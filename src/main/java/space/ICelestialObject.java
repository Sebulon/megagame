package space;

import java.util.ArrayList;

public interface ICelestialObject {

    public String getType();

    public ArrayList<Feature> getFeatures();

    public int getDistance();

    public void setType(String type);

    public void addFeature(Feature feature);

    public void setDistance(int distance);
}
