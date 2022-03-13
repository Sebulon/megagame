package com.chalmersmegagame.game.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
  
@RepositoryRestResource
public interface TeamRepository extends JpaRepository<Team, String> {
    
        
} 
