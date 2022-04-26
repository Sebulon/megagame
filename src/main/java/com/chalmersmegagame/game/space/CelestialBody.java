package com.chalmersmegagame.game.space;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CelestialBody implements ICelestialObject {

    @Id
    private String name;
    protected Enum type;
    @ManyToMany 
    protected List<Feature> features = new ArrayList<>();
    protected int size;

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public Enum getType() {
        return this.type;
    }

    @Override
    public List<Feature> getFeatures() {
        return this.features;
    }

    @Override
    public void setType(Enum type) {
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

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
