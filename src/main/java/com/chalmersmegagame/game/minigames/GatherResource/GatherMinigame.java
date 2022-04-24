package com.chalmersmegagame.game.minigames.GatherResource;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.chalmersmegagame.game.game_resources.TransactionService;
import com.chalmersmegagame.game.ships.*;
import com.chalmersmegagame.game.space.Planetoid;
import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Data
public class GatherMinigame {

    @Transient
    @Autowired
    TransactionService transactionService;

    @Id
    String ship;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "ship")
    @MapsId
    private PlayerShip playerShip;

    @ElementCollection
    private Map<String, Integer> allocatedCrew = new HashMap<>();
    @ElementCollection
    private Map<String, Integer> minimumCrew = new HashMap<>();
    @ElementCollection
    private Map<String, Integer> baseExtractionRate = new HashMap<>();
    @ManyToOne
    private Planetoid sourcePlanet;

    public GatherMinigame(){}

    public GatherMinigame(PlayerShip playerShip){
        this.playerShip = playerShip;
        
    }

    public void addResourceCapability(String resource, int minimumCrew, int baseExtractionRate){
        this.minimumCrew.put(resource, minimumCrew);
        this.baseExtractionRate.put(resource, baseExtractionRate);
    }

    public int gatherResourceAmount(String resource){
        checkResource(resource);

        int availableResource;
        if(sourcePlanet.getResources().contains(resource)){
            availableResource = sourcePlanet.getResourceQuantities().get(resource);
        }else{
            availableResource = 0;
        }

        double resMinimumCrew = minimumCrew.get(resource);
        double resAllocatedCrew = allocatedCrew.get(resource);
        int resBaseExtractionRate = baseExtractionRate.get(resource);
        
        if(resAllocatedCrew >= resMinimumCrew){
            double extractionRate = resBaseExtractionRate * ( 1 + ((resAllocatedCrew - resMinimumCrew)/2));
            if(extractionRate >= availableResource){
                return availableResource;
            }else{
                return (int) extractionRate;
            }
        }else{
            return 0;
        }
        
    }

    public int gatherResource(String resource, Planetoid planet){
        sourcePlanet = planet;
        return gatherResourceAmount(resource);
    }

    private void checkResource(String resource){
        if(!baseExtractionRate.containsKey(resource)){
            throw new RuntimeException("No base extraction rate for " + resource);
        }else if(!minimumCrew.containsKey(resource)){
            throw new RuntimeException("No minimum crew for" + resource);
        }
    }

    public void resolveGatherResources(){
        for(String resource : allocatedCrew.keySet()){
            int quantityGathered = gatherResourceAmount(resource);
            playerShip.addResource(resource, quantityGathered);
            transactionService.newTransaction(playerShip, "Gathered from planet " + sourcePlanet.getName(), resource, quantityGathered);
        }
    }



        
}
