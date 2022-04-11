package com.chalmersmegagame.game.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class ControllerController {

    // TODO: Make incorporated with database

    @GetMapping("/{id}")
    public String getController(@PathVariable String id) {
        List<String> controllers = Arrays.asList("test", "controller");
        return controllers.stream().filter(controller -> controller.equals(id)).findFirst().orElse(null);
    }

}
