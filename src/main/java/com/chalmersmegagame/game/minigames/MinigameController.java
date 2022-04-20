package com.chalmersmegagame.game.minigames;

import com.chalmersmegagame.game.ships.PlayerShip;
import com.chalmersmegagame.game.ships.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/resolveGatherResources")
    public void resolveGatherResourcesAll(){
        minigameService.resolveGatherAll();
    }

    @PutMapping("/setGatherSourcePlanet")
    public void setGatherSourcePlanet(@RequestParam PlayerShip ship, @RequestParam String planetName){
        minigameService.setGatherSourcePlanet(ship, planetName);        
    }

    @PutMapping("/test")
    public void test(){
                
    }
    
}
