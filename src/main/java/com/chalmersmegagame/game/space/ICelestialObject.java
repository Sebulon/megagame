package com.chalmersmegagame.game.space;

import java.util.List;

public interface ICelestialObject {

    public String getType();

    public int getSize();

    public List<Feature> getFeatures();

    public void setType(String type);

    public void setSize(int size);

    public void addFeature(Feature feature);
}
