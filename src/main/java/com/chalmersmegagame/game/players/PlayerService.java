package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.ships.Ship;
import com.chalmersmegagame.game.ships.ShipService;
import com.chalmersmegagame.game.ships.TestShip;
import com.chalmersmegagame.game.users.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    //Autowired automatically gets created instance, so you don't need to feed constructor
    @Autowired
    private UsersService usersService;
    @Autowired
    private ShipService shipService;

    private List<Player> players;

    //Runs after startup is complete
    //@EventListener(ApplicationReadyEvent.class)
    private void setup(){
        players = usersService.createPlayers();
        populatePlayersWithRandomShips();
    }

    public Player getPlayer(String id) {
        return players.stream()
                .filter(player -> player.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    // TODO: Remove these methods when previous todo is done
    private void populatePlayersWithRandomShips() {
        players.forEach(player -> player.setBoardedShip(randomShip()));
    }

    private Ship randomShip() {
        List<TestShip> ships = shipService.getAllTestShips();
        return ships.get((int) Math.floor(Math.random() * ships.size()));
    }
}
