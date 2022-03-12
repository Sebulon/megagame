package space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SolarSystem {
    private int size;
    private ArrayList<ICelestialObject> objectList;

    public SolarSystem (int size, Star star){
        this.size = size;
        objectList.add(star);
    }

    public void sortOrder(){
        objectList.sort((Comparator.comparingInt(ICelestialObject::getIndex)));
    }

    public void addCelestialObject(ICelestialObject object){
        if (objectList.size() <= size + 1){
            objectList.add(object);
            if (object.getIndex() == 0 && object.getType() != "Star") {
                objectList.get(objectList.size() - 1).setIndex(objectList.size() - 1);
            }
        }
        else
        {
            throw new IllegalArgumentException("Solar system is full");
        }
    }
}
