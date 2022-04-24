package com.chalmersmegagame.game.space.services;

import java.util.ArrayList;
import java.util.List;

import com.chalmersmegagame.game.main_game.GameService;
import com.chalmersmegagame.game.space.CelestialBody;
import com.chalmersmegagame.game.space.SolarSystem;
import com.chalmersmegagame.game.space.repositories.SolarSystemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolarSystemService {

    @Autowired
    SolarSystemRepository solarSystemRepository;

    @Autowired
    GameService gameService;

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

    public List<SolarSystem> getAll() {
        return solarSystemRepository.findAll();
    }

    public SolarSystem getCurrent() {
        return gameService.getCurrentSystem();
    }
}
