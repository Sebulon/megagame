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
        if (!objectList.get(0).getType().equals("Star") || !objectList.get(0).getType().equals("Black Hole")){
            throw new IllegalArgumentException("The solar system needs a strong gravity well");
        }
        this.size = size;
        this.objectList = objectList;
    }

    public void sortOrder(){
        objectList.sort((Comparator.comparingInt(ICelestialObject::getIndex)));
    }

    public void addCelestialObject(ICelestialObject object){
        if (objectList.size() <= size + 1){
            object.setIndex(objectList.size());
            objectList.add(object);
            if (object.getIndex() == 0 && object.getType() != "Star") {
                throw new RuntimeException("A solar system needs a strong gravity well");
            }
        }
        else
        {
            throw new IllegalArgumentException("Solar system is full");
        }
    }
}
