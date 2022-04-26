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

    public Feature generateRandomHabitableFeature(){
        return null;
    }

    public Planetoid generateRandomPlanetoid(){
        return null;
    }

    public Star generateRandomStar(){
        Random random = new Random();
        int size = random.nextInt(10) + 1;
        DiceService diceService = new DiceService();
        diceService.intArrayToDice(new int[]{20,20});
        int result = diceService.rollSum();
        if (result <= 3){
            return new Star(size, Star.StarTypes.PULSAR);
        }
        else if (result == 4){
            return new Star(size, Star.StarTypes.NEUTRON);
        }
        else if (result <= 8 ){
            return new Star(size, Star.StarTypes.BROWN_DWARF);
        }
        else if (result <= 16 ){
            return new Star(size, Star.StarTypes.ORANGE);
        }
        else if (result <= 19){
            return new Star(size, Star.StarTypes.BLUE);
        }
        else if (result <= 27){
            return new Star(size, Star.StarTypes.YELLOW);
        }
        else if (result <= 34){
            return new Star(size, Star.StarTypes.RED);
        }
        else if (result <= 40){
            return new Star(size, Star.StarTypes.WHITE);
        }
        return null;
    }

    public SolarSystem generateRandomSolarSystem(){
        return null;
    }

    public Galaxy generateRandomGalaxy(){
        return null;
    }


}
