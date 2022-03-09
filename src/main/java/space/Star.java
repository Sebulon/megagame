package space;

import java.util.ArrayList;

public class Star extends CelestialBody {

    public Star(int size) {
        this.type = "Star";
        this.distance = 0;
        this.size = size;
    }

    public Star(int size, int distance){
        this.type = "Star";
        this.distance = distance;
        this.size = size;
    }
}
