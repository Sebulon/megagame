package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.ships.Ship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/{id}/current-ship")
    public Ship getPlayerBoardedShip(@PathVariable("id") String id) {
        Player p = playerService.getPlayer(id);
        if (p == null) return null;

        //TODO: Boarded ship is always null
        return p.getBoardedShip();
    }

    @RequestMapping("/all")
    public ResponseEntity<?> getPlayers() {
        return ResponseEntity.ok(playerService.getPlayers());
    }
}
