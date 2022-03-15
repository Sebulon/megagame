package com.chalmersmegagame.game;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import com.chalmersmegagame.game.ships.*;
import com.chalmersmegagame.game.teams.Team;

import org.springframework.stereotype.Component;

@Component
public class MainGame extends Canvas{

    private List<Ship> ships = new ArrayList<Ship>();  

    public MainGame(){
        Team team1 = new Team("TestTeam1");
        Team team2 = new Team("TestTeam2");

        ships.add(new PlayerShip(team1, "High Charity", "The Covenant",10));
        ships.add(new PlayerShip(team2, "Unyielding Hierophant", "The Covenant",40));
        
        System.out.println("Game is created");
    }

    public static void main(String[] args) {
        MainGame game = new MainGame();
    }


    public List<Ship> getShips(){
        return ships;
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }
}
