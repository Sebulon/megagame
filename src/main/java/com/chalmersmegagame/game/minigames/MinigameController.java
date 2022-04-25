package com.chalmersmegagame.game.minigames;

import com.chalmersmegagame.game.minigames.vaultle.VaultleMinigameRepository;
import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.ships.PlayerShip;
import com.chalmersmegagame.game.ships.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/minigames")
public class MinigameController {

    @Autowired
    MinigameService minigameService;
    @Autowired
    ShipService shipService;

    @PutMapping("/resolveMoraleChecks")
    public void resolveMoraleChecks(){
        minigameService.resolveMoraleChecks();
    }

    @PutMapping("/allocateResource/morale")
    public void allocateResourceMorale(@RequestParam PlayerShip ship, @RequestParam String resource, @RequestParam int quantity){
        minigameService.allocateResourceMorale(ship, resource, quantity);
    }

    @PutMapping("/allocateCrew/gather")
    public void allocateCrewGather(@RequestParam PlayerShip ship, @RequestParam String resource, @RequestParam int quantity){
        minigameService.allocateCrewToGather(ship, resource, quantity);
    }

    @PutMapping("/test")
    public int test(){
        int x1 = 4;
        double x2 = 3;
        double x3 = 2;
        double x = x1 * (1 + (x2 - x3)/2);
        return (int) x;
    }

    //Vaultle functions
    //Initializes the game, or makes it ready for another round
    @PutMapping("/initGame")
    public void InitGame(@RequestParam PlayerShip ship){
        minigameService.gameInit(ship);
    }

    //Returns the number of guesses
    @GetMapping("/numOfGuesses")
    public int numOfGuesses(@RequestParam PlayerShip ship){
        return minigameService.getNumOfGuesses(ship);
    }

    //Returns the previous guesses
    @GetMapping("/previousGuesses") //Fungerar inte
    public List<String> previousGuesses(@RequestParam PlayerShip ship){
        return minigameService.getPreviousGuesses(ship);
    }

    //Function that returns how right the player's guess is
    @RequestMapping("/guess")
    public int[] checkGuess(@RequestParam PlayerShip ship, @RequestParam String guess){
        return minigameService.checkGuess(ship, guess);
    }

    @GetMapping("/vaultleMinigame/win")
    public boolean win(@RequestParam PlayerShip ship){
        return minigameService.getWin(ship);
    }
    //Delete this later
    @GetMapping("/vaultleMinigame/answer")
    public String answer(@RequestParam PlayerShip ship){
        return minigameService.getTheAnswer(ship);
    }




    
}
