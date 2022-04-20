package com.chalmersmegagame.game.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/all")
    public ResponseEntity<?> getPlayers() {
        return ResponseEntity.ok(playerService.getPlayers());
    }

    @RequestMapping("/{id}")
    public Player getPlayer(@PathVariable String id) {
        return playerService.getPlayer(id);
    }

    @PostMapping("/add")
    public void createPlayer(@RequestBody Player newPlayer) {
        playerService.addPlayer(newPlayer);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable String id) {
        playerService.removePlayer(id);
    }
}
