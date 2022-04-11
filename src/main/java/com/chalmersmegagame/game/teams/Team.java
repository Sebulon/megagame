package com.chalmersmegagame.game.teams;

import com.chalmersmegagame.game.players.Player;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
public class Team {

    @Id
    private String name;
    @OneToMany
    private List<Player> members = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public Team() {
    }

    public void addTeamMember(Player player) {
        members.add(player);
    }

    public void removeTeamMember(Player player) {
        members.remove(player);
    }



}
