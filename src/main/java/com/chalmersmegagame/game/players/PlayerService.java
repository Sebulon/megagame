package com.chalmersmegagame.game.players;

import com.chalmersmegagame.game.roles.Role;
import com.chalmersmegagame.game.teams.Team;
import com.chalmersmegagame.game.teams.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    //Autowired automatically gets created instance, so you don't need to feed constructor
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamService teamService;

    public Player getPlayer(String id) {
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    public void removePlayer(String id) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) return;

        Team team = teamService.getTeamByPlayer(player);
        if (team != null) {
            team.removeTeamMember(player);
        }

        playerRepository.deleteById(id);
    }

    public void setRole(String id, String role) {
        Player player = getPlayer(id);
        Role newRole = Role.valueOf(role);
        player.setRole(newRole);
        playerRepository.save(player);
    }
}
