package com.chalmersmegagame.game.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.chalmersmegagame.game.players.Player;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/all")
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/get/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        return teamService.getTeamByName(teamName);
    }

    @RequestMapping("getByPlayer")
    public Team getTeamByPlayer(@RequestBody Player player) {
        return teamService.getTeamByPlayer(player);
    }

    @PostMapping()
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @PutMapping("/{teamName}/change")
    public void changeTeam(@PathVariable String teamName, @RequestBody List<String> newMembers) {
        teamService.changeTeam(teamName, newMembers);
    }

    @DeleteMapping("/{teamName}/delete")
    public void deleteTeam(@PathVariable String teamName) {
        teamService.removeTeam(teamName);
    }
}
