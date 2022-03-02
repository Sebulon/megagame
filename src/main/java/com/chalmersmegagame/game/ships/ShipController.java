package com.chalmersmegagame.game.ships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.chalmersmegagame.game.*;

@RestController
public class ShipController {

    @Autowired
    private MainGame game;

    @RequestMapping("/api/displayShip")
    public String displayShip() {
        return "TestShip: The Forward Until Dawn";
    }


    @RequestMapping("/api/allShips")
    public List<Ship> getAllShips() {
        return game.getShips();
    }

    @RequestMapping("/api/playerShip")
    public Ship getPlayerShip(@RequestParam("id") String id) {
        // TODO: Do something with id for getting the correct ship based on user
        System.out.println(id);
        int randomNr = (int) (Math.random() * game.getShips().size());
        return game.getShips().get(randomNr);
    }


}
