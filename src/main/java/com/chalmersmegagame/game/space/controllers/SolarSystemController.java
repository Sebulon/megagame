package com.chalmersmegagame.game.space.controllers;

import com.chalmersmegagame.game.space.SolarSystem;
import com.chalmersmegagame.game.space.services.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/solar-systems")
public class SolarSystemController {

    @Autowired
    SolarSystemService solarSystemService;

    @GetMapping("/all")
    public List<SolarSystem> getAll() {
        return solarSystemService.getAll();
    }

    @GetMapping("/current")
    public SolarSystem getCurrent() {
        return solarSystemService.getCurrent();
    }
}
