package com.chalmersmegagame.game.minigames;

import java.util.Optional;

import javax.transaction.Transactional;

import com.chalmersmegagame.game.minigames.GatherResource.GatherMinigame;
import com.chalmersmegagame.game.minigames.GatherResource.GatherMinigameRepository;
import com.chalmersmegagame.game.minigames.Morale.MoraleMinigame;
import com.chalmersmegagame.game.minigames.Morale.MoraleMinigameRepository;
import com.chalmersmegagame.game.minigames.RefineResource.RefineMinigameRepository;
import com.chalmersmegagame.game.minigames.vaultle.VaultleMinigame;
import com.chalmersmegagame.game.minigames.vaultle.VaultleMinigameRepository;
import com.chalmersmegagame.game.ships.*;
import com.chalmersmegagame.game.space.Planetoid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MinigameService {

    @Autowired
    ShipService shipService;
    @Autowired
    MoraleMinigameRepository moraleMinigameRepository;
    @Autowired
    RefineMinigameRepository refineMinigameRepository;
    @Autowired
    GatherMinigameRepository gatherMinigameRepository;
    @Autowired
    VaultleMinigameRepository vaultleMinigameRepository;

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

    @Transactional
    public void addGatherResource(PlayerShip ship, String resource, int minimumCrew, int baseExtractionRate){
        GatherMinigame gatherMinigame;

        Optional<GatherMinigame> opGather = gatherMinigameRepository.findById(ship.getName());
        if(opGather.isEmpty()){
            gatherMinigame = new GatherMinigame(ship);
        }else{
            gatherMinigame = opGather.get();
        }
        
        gatherMinigame.addResource(resource, minimumCrew, baseExtractionRate);
        gatherMinigameRepository.save(gatherMinigame);
    }

    @Transactional
    public void setGatherPlanet(PlayerShip ship, Planetoid planet){
        GatherMinigame gatherMinigame = gatherMinigameRepository.findById(ship.getName()).get();
        gatherMinigame.setSourcePlanet(planet);
    }

    @Transactional
    public void allocateCrewToGather(PlayerShip ship, String resource, int crewQuantity){
        GatherMinigame gatherMinigame = gatherMinigameRepository.findById(ship.getName()).get();
        gatherMinigame.getAllocatedCrew().put(resource, crewQuantity);
    }


    public VaultleMinigame getVaultleMinigame(PlayerShip ship){
        if(vaultleMinigameRepository.findById(ship.getName()).isPresent()){
            return vaultleMinigameRepository.findById(ship.getName()).get(); //Osäker
        }
        //Throw exeption
        return null;
    }

    @Transactional
    public void addVaultleMinigame(VaultleMinigame mg){ vaultleMinigameRepository.save(mg); }

    @Transactional
    public int[] checkQuess(@RequestParam PlayerShip ship, String guess){
        VaultleMinigame mg = getVaultleMinigame(ship);
        return mg.guess(guess);
    }

    @Transactional
    public String getTheAnswer(PlayerShip ship){
        VaultleMinigame mg = getVaultleMinigame(ship);
        return mg.getTheWord();
    }


}
