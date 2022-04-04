package com.chalmersmegagame.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/game")
public class GameController {
    

    @Autowired
    MainGame mainGame;

    @PostMapping("")
    public void defaultSetup(){
        mainGame.setup();
    }

    


    
}
