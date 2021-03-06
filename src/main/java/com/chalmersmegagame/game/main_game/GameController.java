package com.chalmersmegagame.game.main_game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/game")
public class GameController {
    
    @Autowired
    GameService gameService;

    @PostMapping()
    public void defaultSetup(){
        gameService.setup();
    }

    @RequestMapping("/currentTurn")
    public int getCurrentTurn(){
        return gameService.getCurrentTurn();
    }

    @PutMapping("/turn/next")
    public void nextTurn(){
        gameService.nextTurn();
    }

    @PutMapping("/turn/{newTurn}")
    public void setTurn(@PathVariable int newTurn){
        gameService.setCurrentTurn(newTurn);
    }


    @PostMapping("/backup/{saveName}")
    public void backupDB(@PathVariable String saveName){
        gameService.backupDB(saveName);
    }

    @PostMapping("/restore/{saveName}")
    public void restoreDB(@PathVariable String saveName){
        gameService.restoreDB(saveName);
    }

    @DeleteMapping("/drop")
    public void dropDB(){
        gameService.dropDB();
    }

    @RequestMapping("/saves")
    public List<String> getSaveFileNames(){
        return gameService.getSaveFileNames();
    }
    


    
}
