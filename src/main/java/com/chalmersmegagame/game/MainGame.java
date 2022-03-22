package com.chalmersmegagame.game;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import com.chalmersmegagame.game.ships.*;
import com.chalmersmegagame.game.teams.Team;
import com.chalmersmegagame.game.teams.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MainGame extends Canvas{
    @Autowired
    private ShipService shipService;
    @Autowired
    private TeamService teamService;

    public MainGame(){}

    @EventListener(ApplicationReadyEvent.class)
    private void setup(){
        teamService.addTeam(new Team("TestTeam1"));
        teamService.addTeam(new Team("TestTeam2"));

        shipService.addPlayerShip(new PlayerShip(teamService.getTeamByName("TestTeam1"), "High Charity", "The Covenant",10));
        shipService.addPlayerShip(new PlayerShip(teamService.getTeamByName("TestTeam2"), "Unyielding Hierophant", "The Covenant",40));
        
        System.out.println("Game is set up");

    }


}
