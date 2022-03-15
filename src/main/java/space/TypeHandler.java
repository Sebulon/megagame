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
        starTypes.add("Yellow Star");
        starTypes.add("Blue Star");
        starTypes.add("Red Star");
        starTypes.add("Orange Star");
        starTypes.add("White Star");
        starTypes.add("Brown Dwarf");
        starTypes.add("Black Hole");
        starTypes.add("Neutron Star");
        starTypes.add("Pulsar");
        starTypes.add("White Dwarf");
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
