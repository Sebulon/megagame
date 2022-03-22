package com.chalmersmegagame.game.teams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamByName(String name){
        return teamRepository.findById(name).get();
    }

    public void addTeam(Team team){
        teamRepository.save(team);
    }
}
