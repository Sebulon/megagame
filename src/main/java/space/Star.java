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

    public Star(int size, int index, String type){
        if (type.equals("Star") || type.equals("Black Hole")){
            throw new IllegalArgumentException("Illegal type");
        }
        this.index = index;
        this.size = size;
        this.type = type;
    }

}
