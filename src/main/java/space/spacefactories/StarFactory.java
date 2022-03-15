package space.spacefactories;

import space.Star;

public class StarFactory {

    public Star createStandardStar(int size){
        return new Star(size,0,"Star");
    }

    public Star createStandardStarWithIndex(int size, int index){
        return new Star(size, index, "Star");
    }

    public Star createStar(int size, int index, String type){
        return new Star(size, index, type);
    }
    
}
