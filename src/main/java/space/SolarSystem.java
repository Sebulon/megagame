package space;

import java.util.ArrayList;

public class SolarSystem {
    private int size;
    private ArrayList<ICelestialObject> objectList;

    public SolarSystem (int size, Star star){
        this.size = size;
        objectList.add(star);
    }
}
