package com.chalmersmegagame.game.teams;

import org.springframework.web.bind.annotation.*;

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
