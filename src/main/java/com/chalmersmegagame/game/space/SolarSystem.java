package com.chalmersmegagame.game.space;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import javax.persistence.*;

@Entity
public class SolarSystem {

    @Id
    private String name;
    private int size;
    @OneToMany
    private List<CelestialBody> objects = new ArrayList<>();
    @OneToMany
    private Set<SolarSystem> connections;
    private Boolean visited = false;

    public SolarSystem(){}

    public <T extends CelestialBody & IGravityWell> SolarSystem (int size, T gravityWell, String name){
        this.name = name;
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

    public void addConnection(SolarSystem solarSystem){
        connections.add(solarSystem);
        solarSystem.addConnection(this);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List <CelestialBody> getCelestialObjects(){
        return objects;
    }

    public Set<SolarSystem> getConnections() {
        return connections;
    }

    public boolean isVisited() {
        return visited;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSize(){
        return size;
    }
}
