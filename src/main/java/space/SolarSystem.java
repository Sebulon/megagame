package space;

import java.util.ArrayList;
import java.util.Comparator;

public class SolarSystem {
    private int size;
    private ArrayList<ICelestialObject> objectList = new ArrayList<>();

    public SolarSystem (int size, Star star){
        this.size = size;
        objectList.add(star);
    }

    public SolarSystem (int size, ArrayList<ICelestialObject> objectList){
        if (objectList.size() > size + 1){
            throw new IllegalArgumentException("The specified solar system is too large");
        }
        if (!(objectList.get(0) )){
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
}
