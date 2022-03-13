package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.ships.Ship;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("/{id}/current-ship")
    public Ship getPlayerBoardedShip(@PathVariable("id") String id) {
        return playerService.getPlayer(id).getBoardedShip();
    }
}