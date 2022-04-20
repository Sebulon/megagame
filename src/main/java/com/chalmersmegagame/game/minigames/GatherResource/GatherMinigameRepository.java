package com.chalmersmegagame.game.minigames.GatherResource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GatherMinigameRepository extends JpaRepository<GatherMinigame, String>{

}
