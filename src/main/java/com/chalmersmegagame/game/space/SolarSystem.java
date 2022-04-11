package com.chalmersmegagame.game.space;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SolarSystem {

    @Id
    private String name;
    private int size;
    @OneToMany
    private List<CelestialBody> objects = new ArrayList<>();

    public SolarSystem(){};

    public <T extends CelestialBody & IGravityWell> SolarSystem (int size, T gravityWell){
        this.size = size;
        objects.add(gravityWell);
    }

    public SolarSystem (int size, ArrayList<CelestialBody> objectList){
        if (objectList.size() > size + 1){
            throw new IllegalArgumentException("The specified solar system is too large");
        }
        if (!(objectList.get(0) instanceof IGravityWell)){
            throw new IllegalArgumentException("The solar system needs a strong gravity well");
        }
        this.size = size;
        this.objects = objectList;
    }

    public void addCelestialObject(CelestialBody object){
        if (objects.size() <= size + 1){
            objects.add(object);
        }
        else
        {
            throw new IllegalArgumentException("Solar system is full");
        }
    }

    public List <CelestialBody> getCelestialObjects(){
        return objects;
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }
}
