package com.chalmersmegagame.game;

import java.awt.*;
import java.util.List;

import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.players.PlayerService;
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
    @Autowired
    private PlayerService playerService;

    public MainGame(){}

    @EventListener(ApplicationReadyEvent.class)
    private void setup(){
        Player p1 = new Player("player1");
        Player p2 = new Player("player2");
        Player p3 = new Player("player3");
        Player p4 = new Player("player4");
        playerService.addPlayer(p1);
        playerService.addPlayer(p2);
        playerService.addPlayer(p3);
        playerService.addPlayer(p4);

        Team team1 = new Team("TestTeam1");
        Team team2 = new Team("TestTeam2");
        team1.addTeamMember(p1);
        team1.addTeamMember(p2);
        team2.addTeamMember(p3);
        team2.addTeamMember(p4);
        teamService.addTeam(team1);
        teamService.addTeam(team2);

        shipService.addPlayerShip(new PlayerShip(team1, "High Charity", "The Covenant",10));
        shipService.addPlayerShip(new PlayerShip(team2, "Unyielding Hierophant", "The Covenant",40));
        
        System.out.println("Game is set up");

    }

    public List<Ship> getShips(){
        return shipService.getAllShips();
    }


}
