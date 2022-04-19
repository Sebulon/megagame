package com.chalmersmegagame.game.game_resources;

import java.util.List;

import com.chalmersmegagame.game.ships.PlayerShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @RequestMapping("/all")
    public List<Transaction> getAll(){
        return transactionService.getAllTransactions();
    }

    @RequestMapping("/{ship}")
    public List<Transaction> getShipTransactions(@PathVariable PlayerShip ship){
        return transactionService.getAllTransactions(ship);
    }
    
}
