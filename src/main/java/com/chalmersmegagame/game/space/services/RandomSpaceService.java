package com.chalmersmegagame.game.space.services;

import com.chalmersmegagame.game.space.*;

import java.util.ArrayList;
import java.util.Random;

public class RandomSpaceService {
    private SolarSystemService solarSystemService = new SolarSystemService();

    public IGravityWell generateRandomGravityWell(){
        Random size = new Random();
        DiceService diceService = new DiceService();
        diceService.addDie(6);
        int result = diceService.rollSum();
        if (result == 1){
            return new BlackHole(size.nextInt(1) + 1);
        }
        else{
            return generateRandomStar();
        }
    }

    public Planetoid generateRandomPlanetoid(){

    }

    public Star generateRandomStar(){
        Random size = new Random();
        DiceService diceService = new DiceService();
        diceService.addDie(20);
        int result = diceService.rollSum();
        if (result == 1){
            return new Star(size.nextInt(10) + 1, Star.StarTypes.PULSAR);
        }
        else if (result == 2){
            return new Star(size.nextInt(10) + 1, Star.StarTypes.NEUTRON);
        }
    }

    public SolarSystem generateRandomSolarSystem(){

    }

    public Galaxy generateRandomGalaxy(){


    }


}
