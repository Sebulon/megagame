package com.chalmersmegagame.game.ships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ships")
public class ShipController {

    @Autowired
    ShipService shipService;

    @RequestMapping("/getShip/name/{shipName}")
    public Ship getShip(@PathVariable String shipName){
        return shipService.getTestShipByName(shipName);
    }

    @RequestMapping("/getPlayerShip/name/{shipName}")
    public PlayerShip getPlayerShipByName(@PathVariable String shipName){
        return shipService.getPlayerShipByName(shipName);
    }

    @RequestMapping("/getPlayerShip/team/{teamName}")
    public PlayerShip getPlayerShipByTeam(@PathVariable String teamName){
        return shipService.getPlayerShipByTeamName(teamName);
    }
    

    @RequestMapping("/allShips")
    public List<? extends Ship> getAllShips(){
        return shipService.getAllShips();
    }


    @PostMapping("/allShips")
    public void createShip(@RequestBody TestShip ship) {
        shipService.addTestShip(ship);
    }

    @PostMapping("/playerShips")
    public void createPlayerShip(@RequestBody PlayerShip ship){
        shipService.addPlayerShip(ship);
    }


    //modify hp
    @PutMapping("/{shipName}/modify/HP/{modifier}")
    public void modifyShipHP(@PathVariable String shipName, @PathVariable int modifier){
        Ship ship = shipService.getPlayerShipByName(shipName);
        shipService.modifyShipHP(ship, modifier);
    }

    //delete
    @DeleteMapping("/{shipName}/modify/delete")
    public void deleteShip(@PathVariable String shipName) {
        shipService.deleteShip(shipName);
    }

    //get resource quantities
    @RequestMapping("/playerShip/{shipName}/resources")
    public Map<String, Integer> getPlayerShipResourceQuantities(@PathVariable String shipName) {
        return shipService.getPlayerShipResourceQuantities(shipName);
    }

    //modify resource
    @PutMapping("/playerShip/{shipName}/resources/modify/{resourceName}/{quantity}")
    public void modifyPlayerShipResource(@PathVariable Map<String, String> pathVarsMap) {
        shipService.modifyPlayerShipResource(pathVarsMap.get("shipName"), pathVarsMap.get("resourceName"), Integer.parseInt(pathVarsMap.get("quantity")));
    }

    //Transfer resource
    @PutMapping("/playerShip/{shipName}/resources/transfer/{resourceName}/{quantity}/{receivingShip}")
    public void playerShipResourceTransfer(@PathVariable Map<String, String> pathVarsMap) {
        shipService.playerShipResourceTransfer(pathVarsMap.get("shipName"), pathVarsMap.get("receivingShip"), pathVarsMap.get("resourceName"), Integer.parseInt(pathVarsMap.get("quantity")));
    }

}
