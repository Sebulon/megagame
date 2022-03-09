package space;

import java.util.ArrayList;

public class Star extends CelestialBody {

    public Star(int size) {
        this.setType("Star");
        this.setDistance(0);
        this.setSize(size);
    }

    public Star(int size, int distance){
        this.setType("Star");
        this.setDistance(distance);
        this.setSize(size);
    }
}
