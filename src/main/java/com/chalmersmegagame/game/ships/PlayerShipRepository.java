package com.chalmersmegagame.game.ships;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerShipRepository extends JpaRepository<PlayerShip, String> {
    
}
