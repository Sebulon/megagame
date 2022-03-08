package com.chalmersmegagame.game;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import com.chalmersmegagame.game.ships.*;

import org.springframework.stereotype.Component;

@Component
public class MainGame extends Canvas implements Runnable{

    private List<Ship> ships = new ArrayList<Ship>();  
    private Thread thread;

    public MainGame(){
        ships.add(new TestShip("High Charity"));
        ships.add(new TestShip("Unyielding Hierophant"));
        ships.get(1).setHP(39);
        //new ApplicationView(600, 400, "GameView", this);
        System.out.println("Game is created");
    }

    public static void main(String[] args) {
        MainGame game = new MainGame();
    }



    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    public List<Ship> getShips(){
        return ships;
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }
}
