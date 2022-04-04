package com.chalmersmegagame.game.teams;

import java.util.Arrays;
import java.util.List;

import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.players.PlayerService;
import com.chalmersmegagame.game.ships.PlayerShip;
import com.chalmersmegagame.game.ships.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private ShipService shipService;

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamByName(String name){
        return teamRepository.findById(name).get();
    }

    public Team getTeamByPlayer(Player player){
        return teamRepository.findByMembers(player);
    }

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public void createTeam(String teamName){
        addTeam(new Team(teamName));
    }

    public void addTeamMember(Player player, Team team){
        Team oldTeam = getTeamByPlayer(player);
        if(oldTeam != null){
            oldTeam.removeTeamMember(player);
            teamRepository.save(oldTeam);
        }
        team.addTeamMember(player);
        teamRepository.save(team);
    }

    public void addTeamMember(String playerId, String teamName){
        addTeamMember(playerService.getPlayer(playerId), getTeamByName(teamName));
    }

    public void removeTeamMember(Player player, Team team){
        team.removeTeamMember(player);
        teamRepository.save(team);
    }

    public void removeTeam(Team team){
        PlayerShip teamShip = shipService.getPlayerShipByTeam(team);
        if(teamShip != null){
            shipService.removeTeamFromShip(teamShip);
        }

        teamRepository.delete(team);
    }



    
}
