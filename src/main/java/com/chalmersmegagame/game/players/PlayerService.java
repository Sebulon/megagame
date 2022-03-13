package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.ships.Ship;
import com.chalmersmegagame.game.ships.ShipService;
import com.chalmersmegagame.game.users.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final UsersService usersService;
    private final ShipService shipService;

    private final List<Player> players;

    // TODO: Make player have a good starting ship
    public PlayerService(UsersService usersService, ShipService shipService) {
        this.usersService = usersService;
        this.shipService = shipService;
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
        List<Ship> ships = shipService.getAllShips();
        return ships.get((int) Math.floor(Math.random() * ships.size()));
    }
}
