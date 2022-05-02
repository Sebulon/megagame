package com.chalmersmegagame.game.space;

import javax.persistence.Entity;

@Entity
public class BlackHole extends CelestialBody implements IGravityWell{

    public BlackHole (int size){
        this.size = size;
    }

    public BlackHole() {

    }
}
