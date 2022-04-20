package com.chalmersmegagame.game.minigames.RefineResource;

import javax.persistence.*;

import com.chalmersmegagame.game.ships.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class RefineMinigame {

    @Id
    String ship;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "ship")
    @MapsId
    private PlayerShip playerShip;
    
    
}
