package com.chalmersmegagame.game.ships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController
@RequestMapping("/api/ships")
public class ShipController {

    @Autowired
    ShipService shipService;

    @RequestMapping("/getShip/name/{shipName}")
    public Ship getShip(@PathVariable String shipName){
        return shipService.getShipByName(shipName);
    }

    @RequestMapping("/allShips")
    public List<Ship> getAllShips(){
        return shipService.getAllShips();
    }

    @RequestMapping("/playerShip")
    public Ship getPlayerShip(@RequestParam("id") String id) {
        // TODO: Do something with id for getting the correct ship based on user
        System.out.println(id);
        int randomNr = (int) (Math.random() * shipService.getAllShips().size());
        return shipService.getAllShips().get(randomNr);
    }

    @PostMapping("/allShips")
    public void createShip(@RequestBody TestShip ship) {
        shipService.addShip(ship);
    }

    @PutMapping("/{shipName}/modify/HP/{modifier}")
    public void modifyShipHP(@PathVariable String shipName, @PathVariable int modifier){
        Ship ship = shipService.getShipByName(shipName);
        shipService.modifyShipHP(ship, modifier);
    }

    @DeleteMapping("/{shipName}/modify/delete")
    public void deleteShip(@PathVariable String shipName) {
        shipService.deleteShip(shipName);
    }


}
