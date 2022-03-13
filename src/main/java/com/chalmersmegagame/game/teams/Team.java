package com.chalmersmegagame.game.teams;

import com.chalmersmegagame.game.users.user.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    String name;
    @OneToMany
    private List<User> members = new ArrayList<>();

    public Team(String teamName){
        this.name = teamName;
    }

    public Team(){};

    public List<User> getTeamMembers(){
        return members;
    }

    public void addTeamMember(User user){
        members.add(user);
    }

    public void removeTeamMember(User user){
        members.remove(user);
    }

    public String getTeamName(){
        return name;
    }

    



    
}
