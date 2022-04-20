package com.chalmersmegagame.game.space.services;

import java.util.ArrayList;

import com.chalmersmegagame.game.space.CelestialBody;
import com.chalmersmegagame.game.space.SolarSystem;
import com.chalmersmegagame.game.space.repositories.SolarSystemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolarSystemService {

    @Autowired
    SolarSystemRepository solarSystemRepository;

    int nameCount = 1;

    public SolarSystem createSolarSystem(ArrayList<CelestialBody> celestialBodies){
        SolarSystem solarSystem = new SolarSystem(celestialBodies.size(), celestialBodies);
        autoNameSolarSystem(solarSystem); 
        solarSystemRepository.save(solarSystem);     
        return solarSystem;
    }

    public void autoNameSolarSystem(SolarSystem solarSystem){
        solarSystem.setName("Solar system " + nameCount);
        nameCount++;
    }
    
}
