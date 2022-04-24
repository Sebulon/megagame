package com.chalmersmegagame.game.minigames.RefineResource;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.chalmersmegagame.game.game_resources.TransactionService;
import com.chalmersmegagame.game.ships.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Data
public class RefineMinigame {

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
    private Map<String, String> refinesInto = new HashMap<>();
    @ElementCollection
    private Map<String, Integer> baseRefinementRate = new HashMap<>();
    @ElementCollection
    private Map<String, Integer> allocatedCrew = new HashMap<>();
    @ElementCollection
    private Map<String, Integer> allocatedRawResource = new HashMap<>();
    @ElementCollection
    private Map<String, Integer> minimumCrew = new HashMap<>();

    private double excessCrewBonus = 0.50;
    
    public RefineMinigame(){}

    public void addResourceCapability(String rawResource, String refinedResource,int minimumCrew, int baseRefinementRate){
        this.minimumCrew.put(rawResource, minimumCrew);
        this.baseRefinementRate.put(rawResource, baseRefinementRate);
        this.refinesInto.put(rawResource, refinedResource);
    }


    public int refineResourceAmount(String resource){
        checkResource(resource);

        int rawResourceAmount;
        if(allocatedRawResource.containsKey(resource)){
            rawResourceAmount = allocatedRawResource.get(resource);
        }else{
            rawResourceAmount = 0;
        }

        double resMinimumCrew = minimumCrew.get(resource);
        double resAllocatedCrew = allocatedCrew.get(resource);
        int resBaseRefinementRate = baseRefinementRate.get(resource);
        
        if(resAllocatedCrew >= resMinimumCrew){
            double refinementRate = resBaseRefinementRate * ( 1 + ((resAllocatedCrew - resMinimumCrew) * excessCrewBonus));
            if(refinementRate >= rawResourceAmount){
                return rawResourceAmount;
            }else{
                return (int) refinementRate;
            }
        }else{
            return 0;
        }
    }

    private void checkResource(String resource){
        if(!baseRefinementRate.containsKey(resource)){
            throw new RuntimeException("No base extraction rate for " + resource);
        }else if(!minimumCrew.containsKey(resource)){
            throw new RuntimeException("No minimum crew for" + resource);
        }
    }

    public void resolveGatherResources(){
        for(String rawResource : allocatedCrew.keySet()){
            int quantityRefined = refineResourceAmount(rawResource);
            playerShip.addResource(refinesInto.get(rawResource), quantityRefined);
            playerShip.removeResource(rawResource, quantityRefined);
            transactionService.newTransaction(playerShip, "Refined from  " + rawResource, refinesInto.get(rawResource), quantityRefined);
        }
    }
}
