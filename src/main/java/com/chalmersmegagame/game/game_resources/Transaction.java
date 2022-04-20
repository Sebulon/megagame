package com.chalmersmegagame.game.game_resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.chalmersmegagame.game.ships.PlayerShip;

import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private PlayerShip recipient;
    private String source;
    @ElementCollection
    private Map<String, Integer> resources;
    private String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    public Transaction(){}

    public Transaction(PlayerShip recipient, String source, Map<String, Integer> resources){
        this.recipient = recipient;
        this.source = source;
        this.resources = resources;
    }

    public Transaction(PlayerShip recipient, String source, String resource, int quantity){
        this.recipient = recipient;
        this.source = source;
        this.resources = new HashMap<>();
        resources.put(resource, quantity);
    }

    
    
}
