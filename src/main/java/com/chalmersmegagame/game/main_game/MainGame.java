package com.chalmersmegagame.game.main_game;

import javax.persistence.*;

import com.chalmersmegagame.game.space.SolarSystem;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class MainGame{

    @Id
    private String sessionName;
    private int turn;
    @OneToOne
    private SolarSystem currentSystem;

    public MainGame(){
        sessionName = "First session";
        turn = 0;
    }

    public void setCurrentTurn(int turn){
        this.turn = turn;
    }

    public int getCurrentTurn(){
        return turn;
    }


}
