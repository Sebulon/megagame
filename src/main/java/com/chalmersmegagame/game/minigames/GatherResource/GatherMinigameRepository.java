package com.chalmersmegagame.game.minigames.GatherResource;

import java.util.List;
import java.util.Optional;

import com.chalmersmegagame.game.ships.PlayerShip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GatherMinigameRepository extends JpaRepository<GatherMinigame, String>{

}
