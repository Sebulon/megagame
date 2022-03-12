package space;

import java.util.ArrayList;

public class Star extends CelestialBody {

    public Star(int size) {
        this.type = "Star";
        this.index = 0;
        this.size = size;
    }

    public Star(int size, int index){
        this.type = "Star";
        this.index = index;
        this.size = size;
    }
}
