package space;

import java.util.ArrayList;

public class TypeHandler {
    private ArrayList<String> starTypes = new ArrayList<>();
    private ArrayList<String> planetoidTypes = new ArrayList<>();
    private static TypeHandler instance;

    private TypeHandler(){
        instance = this;
        this.initPlanetoidTypes();
        this.initStarTypes();
    }

    public static TypeHandler getInstance() {
        if (TypeHandler.getInstance() == null){
           instance = new TypeHandler();
        }
        return instance;
    }

    private void initStarTypes(){

    }

    private void initPlanetoidTypes(){

    }

    public ArrayList<String> getStarTypes() {
        return starTypes;
    }

    public ArrayList<String> getPlanetoidTypes() {
        return planetoidTypes;
    }
}
