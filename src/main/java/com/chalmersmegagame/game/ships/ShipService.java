package com.chalmersmegagame.game.ships;

import java.util.List;

import com.chalmersmegagame.game.MainGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    @Autowired
    private MainGame game;

    public List<Ship> getAllShips(){
        return game.getShips();
    }

    public Ship getShipByName(String shipName){
        return getAllShips().stream().filter(t -> t.getName().equals(shipName)).findFirst().get();
    }

    public void addShip(Ship ship) {
        game.addShip(ship);
    }

    public void modifyShipHP(Ship ship, int HPmodifier){
        ship.modifyHP(HPmodifier);
    }
    
}
