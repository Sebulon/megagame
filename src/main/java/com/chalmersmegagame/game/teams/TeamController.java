package com.chalmersmegagame.game.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/all")
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping()
    public void addTeam(@RequestBody Team team) {
        //temporary sanity check
        System.out.println(team.getTeamName() + " created");
    }

    //Must determine how to use repositories to assign users to teams

}
