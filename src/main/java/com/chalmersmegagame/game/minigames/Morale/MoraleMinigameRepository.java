package com.chalmersmegagame.game.minigames.Morale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoraleMinigameRepository extends JpaRepository<MoraleMinigame, String>{
    
}
