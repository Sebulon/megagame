package com.chalmersmegagame.game.teams;

import com.chalmersmegagame.game.players.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {

    String teamName;
    private List<Player> teamMembers = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {
    }


    public List<Player> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(Player player) {
        teamMembers.add(player);
    }

    public void removeTeamMember(Player player) {
        teamMembers.remove(player);
    }

    public String getTeamName() {
        return teamName;
    }


}
