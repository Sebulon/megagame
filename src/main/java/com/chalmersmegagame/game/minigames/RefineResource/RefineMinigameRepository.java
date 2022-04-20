package com.chalmersmegagame.game.minigames.RefineResource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RefineMinigameRepository extends JpaRepository<RefineMinigame, String>{
    
}
