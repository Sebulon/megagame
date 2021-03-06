package com.chalmersmegagame.game.teams;

import java.util.List;
import java.util.stream.Collectors;

import com.chalmersmegagame.game.players.Player;
import com.chalmersmegagame.game.players.PlayerService;
import com.chalmersmegagame.game.ships.PlayerShip;
import com.chalmersmegagame.game.ships.ShipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private ShipService shipService;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamByName(String name) {
        return teamRepository.findById(name).orElse(null);
    }

    public Team getTeamByPlayer(Player player) {
        return teamRepository.findByMembers(player);
    }

    public Team getTeamByPlayer(String id) {
        return getTeamByPlayer(playerService.getPlayer(id));
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public void createTeam(String teamName) {
        addTeam(new Team(teamName));
    }

    public void removeTeam(String teamName) {
        Team team = teamRepository.findById(teamName).orElse(null);
        if (team == null) return;
        PlayerShip teamShip = shipService.getPlayerShipByTeam(team);
        if (teamShip != null) {
            shipService.removeTeamFromShip(teamShip);
        }

        teamRepository.delete(team);
    }


    public void changeTeam(String teamName, List<Player> players) {
        Team realTeam = teamRepository.findById(teamName).orElse(null);
        if (realTeam == null) return;

        List<Player> newMembers = players.stream()
                .map(player -> playerService.getPlayer(player.getId()))
                .collect(Collectors.toList());
        realTeam.setMembers(newMembers);
        teamRepository.save(realTeam);
    }
}
