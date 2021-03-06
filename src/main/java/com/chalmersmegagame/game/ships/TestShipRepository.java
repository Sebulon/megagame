package com.chalmersmegagame.game.ships;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TestShipRepository extends JpaRepository<TestShip, String> {
    
}
