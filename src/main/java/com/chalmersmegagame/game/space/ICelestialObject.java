package com.chalmersmegagame.game.space;

import java.util.List;

public interface ICelestialObject {

    public Enum getType();

    public int getSize();

    public List<Feature> getFeatures();

    public void setType(Enum type);

    public void setSize(int size);

    public void addFeature(Feature feature);
}
