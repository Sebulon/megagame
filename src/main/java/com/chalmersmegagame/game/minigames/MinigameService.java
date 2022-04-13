package com.chalmersmegagame.game.minigames;

import javax.transaction.Transactional;

import com.chalmersmegagame.game.minigames.Morale.MoraleMinigame;
import com.chalmersmegagame.game.minigames.Morale.MoraleMinigameRepository;
import com.chalmersmegagame.game.ships.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinigameService {

    @Autowired
    ShipService shipService;
    @Autowired
    MoraleMinigameRepository moraleMinigameRepository;

    public MoraleMinigame getMoraleMinigame(PlayerShip ship){
        return moraleMinigameRepository.findById(ship.getName()).get();
    }

    @Transactional
    public void addMoraleMinigame(MoraleMinigame mg){
        moraleMinigameRepository.save(mg);
    }

    @Transactional
    public void resolveMoraleChecks() {
        for(MoraleMinigame mg: moraleMinigameRepository.findAll()){
            mg.resolveMoraleCheck();
        }
    }

    @Transactional
    public void allocateResourceMorale(PlayerShip ship, String resource, int quantity){
        try{
            shipService.modifyPlayerShipResource(ship, resource, -quantity);
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Could not remove " + quantity + " " + resource);
        }

        getMoraleMinigame(ship).allocateResource(resource, quantity);                        
    }
    
}
