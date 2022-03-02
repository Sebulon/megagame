package com.chalmersmegagame.game.ships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.chalmersmegagame.game.*;
@RestController
public class ShipController {
    
    @Autowired
    private MainGame game;

    @RequestMapping("/displayShip")
    public String displayShip(){
        return "TestShip: The Forward Until Dawn";
    }


    @RequestMapping("/allShips")
    public List<Ship> getAllShips(){
        return game.getShips(); 
    }
    

}
