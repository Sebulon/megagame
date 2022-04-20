package com.chalmersmegagame.game.game_resources;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.chalmersmegagame.game.ships.PlayerShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public void newTransaction(PlayerShip recipient, String source, String resource, int quantity){
        Transaction t = new Transaction(recipient, source, resource, quantity);
        transactionRepository.save(t);

    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public List<Transaction> getAllTransactions(PlayerShip ship){
        return Stream.concat(getRecivievedTransactions(ship).stream(), getSourceTransactions(ship.getName()).stream()).collect(Collectors.toList());
    }

    public List<Transaction> getRecivievedTransactions(PlayerShip ship){
        return transactionRepository.findByRecipient(ship);

    }

    public List<Transaction> getSourceTransactions(String source){
        return transactionRepository.findBySource(source);
    }
        
}
