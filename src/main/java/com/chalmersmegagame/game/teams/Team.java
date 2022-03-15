package com.chalmersmegagame.game.teams;

import com.chalmersmegagame.game.players.Player;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    String name;
    @OneToMany
    private List<Player> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public Team() {
    }


    public List<Player> getTeamMembers() {
        return members;
    }

    public void addTeamMember(Player player) {
        members.add(player);
    }

    public void removeTeamMember(Player player) {
        members.remove(player);
    }

    public String getTeamName() {
        return name;
    }


}
