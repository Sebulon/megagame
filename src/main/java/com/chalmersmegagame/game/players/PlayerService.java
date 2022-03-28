package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.ships.Ship;
import com.chalmersmegagame.game.ships.ShipService;
import com.chalmersmegagame.game.ships.TestShip;
import com.chalmersmegagame.game.teams.Team;
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
    @Autowired
    private PlayerRepository playerRepository;

    private List<Player> players;


    public Player getPlayer(String id) {
        return players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

}
