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
        objectList.sort((Comparator.comparingInt(ICelestialObject::getDistance)));
    }

    public void addCelestialObject(ICelestialObject object){
        if (objectList.size() <= size + 1){
            objectList.add(object);
        }
        else
        {

        }
    }
}
