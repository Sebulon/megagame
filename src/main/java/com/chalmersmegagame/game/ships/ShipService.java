package com.chalmersmegagame.game.ships;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import com.chalmersmegagame.game.game_resources.TransactionService;
import com.chalmersmegagame.game.teams.Team;
import com.chalmersmegagame.game.teams.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    @Autowired
    private TestShipRepository testShipRepository;
    @Autowired
    private PlayerShipRepository playerShipRepository;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TransactionService transactionService;

    private <T extends Ship> JpaRepository<T, String>  getRepoByContains(Ship ship){
        if(testShipRepository.existsById(ship.getName())){
            return (JpaRepository<T, String>) testShipRepository;
        }else if(playerShipRepository.existsById(ship.getName())){
            return (JpaRepository<T, String>) playerShipRepository;
        }else{
            throw new NoSuchElementException("No repo containing that ship found");
        }
    }


    public List<TestShip> getAllTestShips(){
        return testShipRepository.findAll();
    }

    public List<PlayerShip> getAllPlayerShips(){
        return playerShipRepository.findAll();
    }

    public List<Ship> getAllShips(){
        List<Ship> shipList = new ArrayList<>();
        shipList.addAll(getAllPlayerShips());
        shipList.addAll(getAllTestShips());

        return shipList;
    }

    public TestShip getTestShipByName(String shipName){
        //Should probably handle NoSuchElementException thrown by .get() on Optional<TestShip>
        return testShipRepository.findById(shipName).get();
    }

    public PlayerShip getPlayerShipByName(String shipName){
        return playerShipRepository.findById(shipName).get();
    }

    public PlayerShip getPlayerShipByTeam(Team team){
        return playerShipRepository.findByTeam(team);
    }

    public PlayerShip getPlayerShipByTeamName(String teamName){
        return getPlayerShipByTeam(teamService.getTeamByName(teamName));
    }

    public <T extends Ship> T getShipByName(String shipName){
        try{
            return (T) getTestShipByName(shipName);
        }catch(Exception e){}
        try{
            return (T) getPlayerShipByName(shipName);
        }catch(Exception e){}

        return null;
    }

    public void addTestShip(TestShip ship) {
        testShipRepository.save(ship);
    }

    public void addPlayerShip(PlayerShip ship){
        playerShipRepository.save(ship);
    }

    @Transactional
    public void modifyShipHP(Ship ship, int HPmodifier) {
        ship.modifyHP(HPmodifier);
    }

    //delete
    public <T extends Ship> void deleteShip(String shipName) {
        getRepoByContains(getShipByName(shipName)).delete(getShipByName(shipName));
    }

    public Map<String, Integer> getPlayerShipResourceQuantities(String shipName){
        return getPlayerShipByName(shipName).getResourceQuantities();
    }

    @Transactional
    public void modifyPlayerShipResource(PlayerShip ship, String resource, int quantity) {
        if (quantity > 0) {
            ship.addResource(resource, quantity);
        } else if (quantity < 0) {
            ship.removeResource(resource, quantity * -1);
        }
    }

    @Transactional
    public void modifyPlayerShipResource(String shipName, String resource, int quantity) {
        PlayerShip ship = getPlayerShipByName(shipName);
        modifyPlayerShipResource(ship, resource, quantity);
    }

    public void playerShipResourceTransfer(String sendingShip, String receivingShip, String resourceName, int quantity) {
        modifyPlayerShipResource(sendingShip, resourceName, -quantity);
        modifyPlayerShipResource(receivingShip, resourceName, quantity);
        transactionService.newTransaction(getPlayerShipByName(receivingShip), sendingShip, resourceName, quantity);
    }

    public void playerShipResourcesTransfer(String sendingShip, String receivingShip, Map<String, Integer> resources) {
        resources.forEach((resource, quantity) -> playerShipResourceTransfer(sendingShip, receivingShip, resource, quantity));
    }

    @Transactional
    public void removeTeamFromShip(PlayerShip ship){
        ship.setTeam(null);
    }

    public PlayerShip getPlayerShipByPlayer(String id) {
        return getPlayerShipByTeam(teamService.getTeamByPlayer(id));
    }
}
