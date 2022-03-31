package com.chalmersmegagame.game.ships;

import java.util.List;

import com.chalmersmegagame.game.teams.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlayerShipRepository extends JpaRepository<PlayerShip, String> {
    PlayerShip findByTeam(Team team);
    
}
