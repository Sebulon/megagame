package com.chalmersmegagame.game.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    //Autowired automatically gets created instance, so you don't need to feed constructor
    @Autowired
    private PlayerRepository playerRepository;

    public Player getPlayer(String id) {
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

}
