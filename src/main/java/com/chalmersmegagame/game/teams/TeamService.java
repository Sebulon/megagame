package com.chalmersmegagame.game.teams;

import java.util.List;

import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.players.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerService playerService;

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamByName(String name){
        return teamRepository.findById(name).get();
    }

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public void createTeam(String teamName){
        addTeam(new Team(teamName));
    }

    public void addTeamMember(Player player, Team team){
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
        teamRepository.delete(team);
    }

    
}
