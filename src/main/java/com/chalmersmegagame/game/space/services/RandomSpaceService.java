package com.chalmersmegagame.game.space.services;

import com.chalmersmegagame.game.space.*;

import java.util.ArrayList;
import java.util.Random;

public class RandomSpaceService {
    private SolarSystemService solarSystemService = new SolarSystemService();

    private int randomNumber (int max){
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    public IGravityWell generateRandomGravityWell(){
        int result = randomNumber(6);
        if (result == 1){
            return new BlackHole(randomNumber(10));
        }
        else{
            return generateRandomStar();
        }
    }

    public Planetoid generateRandomPlanetoid(int maxSize){
        int size = randomNumber(maxSize);
        int result = randomNumber(20);
        if (result == 1){
            Planetoid habitable = new Planetoid(size, Planetoid.PlanetoidTypes.HABITABLE);
            habitable.addFeature(generateRandomHabitableFeature());
            habitable.addResource("Food", randomNumber(10));
            habitable.addResource("Water", randomNumber(10));
            habitable.addResource("Minerals", Math.max(randomNumber(10) - 5, 0));
            habitable.addResource("Gasses", Math.max(randomNumber(10) - 5, 0));
            habitable.addResource("Chemicals", Math.max(randomNumber(10) - 5, 0));
            habitable.addResource("Alien Animals", randomNumber(5));
            habitable.addResource("Alien Plants", randomNumber(5));

            if(randomNumber(6) > 4){
                habitable.addSatellite(generateRandomPlanetoid(habitable.getSize()-1));
            }
            return habitable;
        }
        else if (result == 2){
            Planetoid apocalyptic = new Planetoid(size, Planetoid.PlanetoidTypes.APOCALYPTIC);
            apocalyptic.addResource("Artifacts", Math.max(randomNumber(10) - 5, 0));
            apocalyptic.addResource("Minerals", randomNumber(10));
            apocalyptic.addResource("Weapons of Mass Destruction", Math.max(randomNumber(10) - 7, 0));

            if (randomNumber(6) > 4){
                apocalyptic.addSatellite(generateRandomPlanetoid(apocalyptic.getSize() - 1));
            }
            return apocalyptic;
        }
        else if (result == 3){
            Planetoid broken = new Planetoid(size, Planetoid.PlanetoidTypes.BROKEN);
            broken.addResource("Minerals", randomNumber(20));

            if (randomNumber(6) > 4){
                broken.addSatellite(generateRandomPlanetoid(broken.getSize() - 1));
            }
            return broken;
        }
        else if (result <= 5 ){
            Planetoid molten = new Planetoid(size, Planetoid.PlanetoidTypes.MOLTEN);
            molten.addResource("Energy", randomNumber(20));
            molten.addResource("Minerals", randomNumber(10));
            molten.addResource("Chemicals", randomNumber(10));

            if (randomNumber(6) > 4){
                molten.addSatellite(generateRandomPlanetoid(molten.getSize() - 1));
            }
        }
        else if (result <= 8){
            Planetoid toxic = new Planetoid(size, Planetoid.PlanetoidTypes.TOXIC);
            toxic.addResource("Gasses", randomNumber(10));
            toxic.addResource("Chemicals", randomNumber(10));
            toxic.addResource("Minerals", randomNumber(10));
            toxic.addResource("Alien Microbes", Math.max(randomNumber(10) - 8, 0));

            if (randomNumber(6) > 4){
                toxic.addSatellite(generateRandomPlanetoid(toxic.getSize() - 1));
            }
            return toxic;
        }
        else if (result <= 11){
            Planetoid frozen = new Planetoid(size, Planetoid.PlanetoidTypes.FROZEN);
            frozen.addResource("Water", randomNumber(10));
            frozen.addResource("Liquid Gasses",randomNumber(20));
            frozen.addResource("Alien Animals", Math.max(randomNumber(10) - 8, 0));

            if (randomNumber(6) > 4){
                frozen.addSatellite(generateRandomPlanetoid(frozen.getSize() - 1));
            }
        }
        else if (result <= 14){

        }
        else if (result <= 17){

        }
        else if (result <= 20){

        }
        return null;
    }

    public Star generateRandomStar(){
        int size = randomNumber(10);
        int result = randomNumber(20);
        result += randomNumber(20);
        if (result <= 3){
            return new Star(size, Star.StarTypes.PULSAR);
        }
        else if (result == 4){
            return new Star(size, Star.StarTypes.NEUTRON);
        }
        else if (result <= 8 ){
            return new Star(randomNumber(5), Star.StarTypes.BROWN_DWARF);
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

    public SolarSystem generateRandomSolarSystem(int size){
        return null;
    }

    public Galaxy generateRandomGalaxy(int size){
        return null;
    }

    public Feature generateRandomHabitableFeature(){
        return null;
    }

}
