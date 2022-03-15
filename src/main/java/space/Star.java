package space;


public class Star extends CelestialBody {

    private String stellarClass;
    /*public Star(int size) {
        this.type = "Star";
        this.index = 0;
        this.size = size;
    }

    public Star(int size, int index){
        this.type = "Star";
        this.index = index;
        this.size = size;
    }*/

    public Star(int size, int index, String type){
        if (!typeHandler.getStarTypes().contains(type)){
            throw new IllegalArgumentException("Illegal type");
        }
        this.index = index;
        this.size = size;
        this.type = type;
    }

    public String getStellarClass() {
        return this.stellarClass;
    }

    public void setStellarClass(String stellarClass) {
        this.stellarClass = stellarClass;
    }
}
