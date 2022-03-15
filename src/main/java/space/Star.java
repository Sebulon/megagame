package space;


public class Star extends CelestialBody {

    public Star(int size, String type){
        if (!typeHandler.getStarTypes().contains(type)){
            throw new IllegalArgumentException("Illegal type");
        }
        this.size = size;
        this.type = type;
    }

}
