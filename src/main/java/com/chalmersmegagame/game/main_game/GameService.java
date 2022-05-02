package com.chalmersmegagame.game.main_game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.chalmersmegagame.game.minigames.MinigameService;
import com.chalmersmegagame.game.minigames.Morale.MoraleMinigame;
import com.chalmersmegagame.game.players.*;
import com.chalmersmegagame.game.roles.Role;
import com.chalmersmegagame.game.ships.*;
import com.chalmersmegagame.game.space.CelestialBody;
import com.chalmersmegagame.game.space.Planetoid;
import com.chalmersmegagame.game.space.SolarSystem;
import com.chalmersmegagame.game.space.Star;
import com.chalmersmegagame.game.space.services.CelestialBodyService;
import com.chalmersmegagame.game.space.services.SolarSystemService;
import com.chalmersmegagame.game.teams.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private ShipService shipService;
    @Autowired
    private MinigameService minigameService;
    @Autowired
    private SolarSystemService solarSystemService;
    @Autowired
    private CelestialBodyService celestialBodyService;

    public MainGame game(){
        return gameRepository.findAll().get(0);
    }

    public void setup(){
        gameRepository.save(new MainGame());

        Player p1 = new Player("player1", "Katja", Role.Captain);
        Player p2 = new Player("player2", "Kaj", Role.Scientist);
        Player p3 = new Player("player3", "Benta", Role.Captain);
        Player p4 = new Player("player4", "Bent", Role.Scientist);
        playerService.addPlayer(p1);
        playerService.addPlayer(p2);
        playerService.addPlayer(p3);
        playerService.addPlayer(p4);

        Team team1 = new Team("TestTeam1");
        Team team2 = new Team("TestTeam2");
        team1.addTeamMember(p1);
        team1.addTeamMember(p2);
        team2.addTeamMember(p3);
        team2.addTeamMember(p4);
        teamService.addTeam(team1);
        teamService.addTeam(team2);

        Star star1 = celestialBodyService.createStar(2, Star.StarTypes.YELLOW);

        Planetoid planet1 = celestialBodyService.createPlanetoid(3, Planetoid.PlanetoidTypes.FROZEN);
        Planetoid planet2 = celestialBodyService.createPlanetoid(2, Planetoid.PlanetoidTypes.HABITABLE);

        ArrayList<CelestialBody> celArr = new ArrayList<>(
            Arrays.asList(star1,
                          planet1,
                          planet2));

        SolarSystem solarSystem1 = solarSystemService.createSolarSystem(celArr);

        game().setCurrentSystem(solarSystem1);

        shipService.addPlayerShip(new PlayerShip(team1, "High Charity", "The Covenant",10, 7));
        shipService.addPlayerShip(new PlayerShip(team2, "Unyielding Hierophant", "The Covenant",40, 8));
        
        minigameService.addGatherResource(shipService.getPlayerShipByName("High Charity"), "RAW MATERIALS", 2, 5);
        minigameService.addGatherResource(shipService.getPlayerShipByName("Unyielding Hierophant"), "WATER", 1, 3);

        minigameService.addMoraleMinigame(new MoraleMinigame(shipService.getPlayerShipByName("High Charity")));
        minigameService.addMoraleMinigame(new MoraleMinigame(shipService.getPlayerShipByName("Unyielding Hierophant")));

        setCurrentTurn(1);
        
        System.out.println("Game is set up");
    }

    public void setCurrentTurn(int turn){
        game().setCurrentTurn(turn);
        gameRepository.save(game());
    }

    public int getCurrentTurn(){
        return game().getCurrentTurn();
    }

    public void nextTurn(){
        setCurrentTurn(getCurrentTurn()+1);
    }

    
    public void setCurrentSystem(SolarSystem newSystem){
        game().setCurrentSystem(newSystem);
        gameRepository.save(game());
    }

    public SolarSystem getCurrentSystem(){
        return game().getCurrentSystem();
    }

    private Connection getDBConn(){
        try{
            return DriverManager.getConnection("jdbc:h2:file:./src/main/resources/megabased", "sa", "password");
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Could not connect to database");
        }
        
    }

    @Transactional
    public void backupDB(String name){
        try{
            Statement s = getDBConn().createStatement();
            s.execute("SCRIPT TO 'file:./src/main/resources/saves/" + name + ".sql'");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    @Transactional
    public void backupDB(String name){
        em.createNativeQuery("BACKUP TO 'file:./src/main/resources/saves/" + name + ".zip'").executeUpdate();
    }
    */


    public void restoreDB(String name){
        try{
            dropDB();
            Statement s = getDBConn().createStatement();
            s.execute("RUNSCRIPT FROM 'file:./src/main/resources/saves/" + name + ".sql'");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    protected void dropDB(){
        try{
            Statement s = getDBConn().createStatement();
            s.execute("DROP ALL OBJECTS DELETE FILES");
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    public List<String> getSaveFileNames(){
       File folder = new File("./src/main/resources/saves");
       File[] files = folder.listFiles();
       ArrayList<String> fileNames = new ArrayList<>();
       for(File file : files){
           String name = file.getName();
           String shortName = FilenameUtils.removeExtension(name);
           fileNames.add(shortName);           
       }
       

        return fileNames;
    }

    
}
