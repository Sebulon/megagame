package space;

import java.util.ArrayList;
import java.util.Set;

public class SolarSystem {
    private int size;
    private ArrayList<ICelestialObject> objectList = new ArrayList<>();
    private Set<SolarSystem> connections;

    public SolarSystem (int size, IGravityWell gravityWell){
        this.size = size;
        objectList.add(gravityWell);
    }

    public SolarSystem (int size, ArrayList<ICelestialObject> objectList){
        if (objectList.size() > size + 1){
            throw new IllegalArgumentException("The specified solar system is too large");
        }
        if (!(objectList.get(0) instanceof IGravityWell)){
            throw new IllegalArgumentException("The solar system needs a strong gravity well");
        }
        this.size = size;
        this.objectList = objectList;
    }

    public void addCelestialObject(ICelestialObject object){
        if (objectList.size() <= size + 1){
            objectList.add(object);
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

    public ArrayList <ICelestialObject> getCelestialObjects(){
        return objectList;
    }

    public Set<SolarSystem> getConnections() {
        return connections;
    }
}
