package com.chalmersmegagame.game.ships;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    @Autowired
    private TestShipRepository testShipRepository;
    @Autowired
    private PlayerShipRepository playerShipRepository;

    public List<TestShip> getAllTestShips(){
        return testShipRepository.findAll();
    }

    public Ship getTestShipByName(String shipName){
        //Should probably handle NoSuchElementException thrown by .get() on Optional<TestShip>
        return testShipRepository.findById(shipName).get();
    }

    public PlayerShip getPlayerShipByName(String shipName){
        return playerShipRepository.findById(shipName).get();
    }


    public void addTestShip(TestShip ship) {
        testShipRepository.save(ship);
    }

    public void addPlayerShip(PlayerShip ship){
        playerShipRepository.save(ship);
    }

    public void modifyShipHP(Ship ship, int HPmodifier) {
        ship.modifyHP(HPmodifier);
    }

    public void deleteShip(String shipName) {
        Ship shipToDelete = getTestShipByName(shipName);
        getAllTestShips().remove(shipToDelete);
    }

    public HashMap<String, Integer> getPlayerShipResourceQuantities(String shipName) {
        return getPlayerShipByName(shipName).getResourceQuantities();
    }

    public void modifyPlayerShipResource(String shipName, String resource, int quantity) {
        PlayerShip ship = getPlayerShipByName(shipName);
        if (quantity > 0) {
            ship.addResource(resource, quantity);
        } else if (quantity < 0) {
            ship.removeResource(resource, quantity * -1);
        }
    }

    public void playerShipResourceTransfer(String sendingShip, String receivingShip, String resourceName, int quantity) {
        modifyPlayerShipResource(sendingShip, resourceName, -quantity);
        modifyPlayerShipResource(receivingShip, resourceName, quantity);
    }

    public void playerShipResourcesTransfer(String sendingShip, String receivingShip, Map<String, Integer> resources) {
        resources.forEach((resource, quantity) -> playerShipResourceTransfer(sendingShip, receivingShip, resource, quantity));
    }
}
