package com.chalmersmegagame.game.space.repositories;

import com.chalmersmegagame.game.space.CelestialBody;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CelestialBodyRepository extends JpaRepository<CelestialBody, String> {
    
}
