package com.chalmersmegagame.game.users;

import com.chalmersmegagame.game.users.user.*;

import java.util.ArrayList;
import java.util.List;

public class Team {

    String teamName;
    private List<User> teamMembers = new ArrayList<>();

    public Team(String teamName){
        this.teamName = teamName;
    }

    public Team(){};

    public List<User> getTeamMembers(){
        return teamMembers;
    }

    public void addTeamMember(User user){
        teamMembers.add(user);
    }

    public void removeTeamMember(User user){
        teamMembers.remove(user);
    }

    public String getTeamName(){
        return teamName;
    }

    



    
}
