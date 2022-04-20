package com.chalmersmegagame.game.minigames;

import com.chalmersmegagame.game.ships.PlayerShip;
import com.chalmersmegagame.game.ships.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/minigames")
public class MinigameController {

    @Autowired
    MinigameService minigameService;
    @Autowired
    ShipService shipService;

    @PutMapping("/resolveMoraleChecks")
    public void resolveMoraleChecks(){
        minigameService.resolveMoraleChecks();
    }

    @PutMapping("/allocateResource/morale")
    public void allocateResourceMorale(@RequestParam PlayerShip ship, @RequestParam String resource, @RequestParam int quantity){
        minigameService.allocateResourceMorale(ship, resource, quantity);
    }

    @PutMapping("/allocateCrew/gather")
    public void allocateCrewGather(@RequestParam PlayerShip ship, @RequestParam String resource, @RequestParam int quantity){
        minigameService.allocateCrewToGather(ship, resource, quantity);
    }

    @PutMapping("/test")
    public int test(){
        int x1 = 4;
        double x2 = 3;
        double x3 = 2;
        double x = x1 * (1 + (x2 - x3)/2);
        return (int) x;
    }
    
}
