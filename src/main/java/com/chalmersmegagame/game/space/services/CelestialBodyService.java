package com.chalmersmegagame.game.space.services;

import java.util.List;

import javax.transaction.Transactional;

import com.chalmersmegagame.game.space.*;
import com.chalmersmegagame.game.space.repositories.CelestialBodyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CelestialBodyService {

    @Autowired
    CelestialBodyRepository celestialBodyRepository;

    int nameCount = 1;

    @Transactional
    public Planetoid createPlanetoid(int size, Enum type){
        Planetoid planet = new Planetoid(size, type);
        autoNameCelestialBody(planet);
        celestialBodyRepository.save(planet);
        return planet;    
    }

    @Transactional
    public Star createStar(int size, Star.StarTypes type){
        Star star = new Star(size, type);
        autoNameCelestialBody(star);
        celestialBodyRepository.save(star);
        return star;
    }

    
    public void nameCelestialBody(CelestialBody celestialBody, String name){
        celestialBody.setName(name);
    }

    public void autoNameCelestialBody(CelestialBody celestialBody){
        String name = celestialBody.getType() + " " + nameCount;
        nameCount++;
        nameCelestialBody(celestialBody, name);
    }

    public Planetoid getPlanetoidByName(String planetName){
        return (Planetoid) celestialBodyRepository.findById(planetName).get();
    }

    public Planetoid getFirstPlanet(){
        List<CelestialBody> celestialBodies = celestialBodyRepository.findAll();
        for(CelestialBody celestialBody : celestialBodies){
            if(celestialBody instanceof Planetoid){
                return (Planetoid) celestialBody;
            }
        }

        return null;
    }

    public void addPlanetResource(Planetoid planet, String resource, int quantity){
        planet.addResource(resource, quantity);
    }
    


}
