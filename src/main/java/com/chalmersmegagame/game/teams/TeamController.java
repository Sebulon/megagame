package com.chalmersmegagame.game.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")

//TODO: skapa teams och ändra vilket team en spelare är i
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/all")
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping()
    public void addTeam(@RequestBody Team team) {
        //TODO: do something with data
        //temporary sanity check
        System.out.println(team.getName() + " created");
        team.getMembers().forEach(player -> System.out.println(player.getId()));
    }

    @DeleteMapping("/delete/{teamName}")
    public void deleteTeam(@PathVariable String teamName) {
        //TODO: Add delete thing for teams
        System.out.println("Deleting team " + teamName);
    }



    //Must determine how to use repositories to assign users to teams

}
