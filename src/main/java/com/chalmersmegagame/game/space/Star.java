package com.chalmersmegagame.game.space;

import javax.persistence.Entity;

@Entity
public class Star extends CelestialBody implements IGravityWell {

    public Star(){}

    public Star(int size, StarTypes type){
        this.size = size;
        this.type = type;
    }

    public enum StarTypes{
        YELLOW,
        BLUE,
        RED,
        ORANGE,
        WHITE,
        BROWN_DWARF,
        NEUTRON,
        PULSAR,
        WHITE_DWARF
    }
}
