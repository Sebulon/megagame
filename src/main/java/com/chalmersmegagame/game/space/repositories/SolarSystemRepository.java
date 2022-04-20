package com.chalmersmegagame.game.space.repositories;

import com.chalmersmegagame.game.space.SolarSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SolarSystemRepository extends JpaRepository<SolarSystem, String> {
    
}
