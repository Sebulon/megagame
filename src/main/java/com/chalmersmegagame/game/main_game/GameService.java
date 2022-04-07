package com.chalmersmegagame.game.main_game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.persistence.*;
import javax.transaction.Transactional;

import com.chalmersmegagame.game.players.*;
import com.chalmersmegagame.game.ships.*;
import com.chalmersmegagame.game.space.SolarSystem;
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

    public MainGame game(){
        return gameRepository.findAll().get(0);
    }

    public void setup(){
        gameRepository.save(new MainGame());

        Player p1 = new Player("player1");
        Player p2 = new Player("player2");
        Player p3 = new Player("player3");
        Player p4 = new Player("player4");
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

        shipService.addPlayerShip(new PlayerShip(team1, "High Charity", "The Covenant",10));
        shipService.addPlayerShip(new PlayerShip(team2, "Unyielding Hierophant", "The Covenant",40));

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

    @Transactional
    public void backupDB(String name){
        String databaseURL = "jdbc:h2:file:./src/main/resources/megabased";
        try{
            Connection conn = DriverManager.getConnection(databaseURL, "sa", "password");
            Statement s = conn.createStatement();
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
        String databaseURL = "jdbc:h2:file:./src/main/resources/megabased";
        try{
            Connection conn = DriverManager.getConnection(databaseURL, "sa", "password");
            Statement s = conn.createStatement();
            s.execute("DROP ALL OBJECTS DELETE FILES");
            s.execute("RUNSCRIPT FROM 'file:./src/main/resources/saves/" + name + ".sql'");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    /*
    public void restoreDB(String fileName){
        fileName = fileName + ".zip";
        System.out.println(fileName);
        String filePath = new File("src/main/resources/saves/" + fileName).getAbsolutePath();
        System.out.println(filePath);
        String dicPath = new File("src/main/resources").getAbsolutePath();

        try{
            new Restore().execute(filePath, dicPath, null);
        }catch(Exception e){
            System.out.println("fuck");
            e.printStackTrace();
        }
        
    }
    */

    
}