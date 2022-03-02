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
    private boolean running = false;

    public MainGame(){
        ships.add(new TestShip("High Charity"));
        ships.add(new TestShip("Unyielding Hierophant"));
        ships.get(1).setHP(39);
        //new ApplicationView(600, 400, "GameView", this);
        System.out.println("Game is created");
    }

    public static void main(String[] args) {
        MainGame game = new MainGame();
        if(game.running = true){
            System.out.println("Game is running");
        }
    }


    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    public List<Ship> getShips(){
        return ships;
    }
}
