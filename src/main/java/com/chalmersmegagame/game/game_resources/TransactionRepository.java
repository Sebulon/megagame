package com.chalmersmegagame.game.game_resources;

import java.util.List;

import com.chalmersmegagame.game.ships.PlayerShip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    public List<Transaction> findByRecipient(PlayerShip recipient);

    public List<Transaction> findBySource(String source);
    
}
