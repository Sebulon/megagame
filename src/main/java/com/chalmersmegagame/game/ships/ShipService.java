package com.chalmersmegagame.game.ships;

import java.util.HashMap;
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

    public PlayerShip getPlayerShipByName(String shipName){
        Ship ship = getShipByName(shipName);
        if(ship instanceof PlayerShip){
            PlayerShip playerShip = (PlayerShip) ship;
            return playerShip;
        }else{
            throw new RuntimeException("No PlayerShip with name " + shipName + " found");
        }
    }

    public void addShip(Ship ship) {
        game.addShip(ship);
    }

    public void modifyShipHP(Ship ship, int HPmodifier){
        ship.modifyHP(HPmodifier);
    }

    public void deleteShip(String shipName) {
        Ship shipToDelete = getShipByName(shipName);
        getAllShips().remove(shipToDelete);
    }

    public HashMap<String, Integer> getPlayerShipResourceQuantities(String shipName){
        return getPlayerShipByName(shipName).getResourceQuantities();
    }

    public void modifyPlayerShipResource(String shipName, String resource, int quantity){
        PlayerShip ship = getPlayerShipByName(shipName);
        if(quantity > 0){
            ship.addResource(resource, quantity);
        }else if(quantity < 0){
            ship.removeResource(resource, quantity);
        }
    }
}
