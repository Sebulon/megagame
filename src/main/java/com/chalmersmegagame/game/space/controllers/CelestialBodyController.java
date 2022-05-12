package com.chalmersmegagame.game.space.controllers;

import com.chalmersmegagame.game.space.CelestialBody;
import com.chalmersmegagame.game.space.Feature;
import com.chalmersmegagame.game.space.repositories.CelestialBodyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/celestialBodies")
public class CelestialBodyController {

    @Autowired
    CelestialBodyRepository celestialBodyRepository;

    //TODO: add resources

    @PutMapping("/{name}/size/{size}")
    public void changeCelestialBodySize(@PathVariable String name, @PathVariable int size){
        CelestialBody celestialBody = celestialBodyRepository.findById(name).get();
        celestialBody.addFeature(new Feature("Is a cold and lonely place", "Hoth"));
        celestialBody.setSize(size);
        celestialBodyRepository.save(celestialBody);
    }

    
}
