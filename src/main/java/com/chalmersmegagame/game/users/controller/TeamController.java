package com.chalmersmegagame.game.users.controller;

import org.springframework.web.bind.annotation.*;

import com.chalmersmegagame.game.users.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    
    @PostMapping()
    public void addTeam(@RequestBody Team team){
        //temporary sanity check
        System.out.println(team.getTeamName() + " created");
    }

    //Must determine how to use repositories to assign users to teams

}
