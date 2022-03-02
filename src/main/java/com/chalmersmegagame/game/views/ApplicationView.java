package com.chalmersmegagame.game.views;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.chalmersmegagame.game.MainGame;
import com.chalmersmegagame.game.ships.*;

public class ApplicationView extends Canvas{

    private MainGame game;
    private JFrame frame;

    public ApplicationView(int width, int height, String title, MainGame game){
        this.frame = new JFrame(title);
        this.game = game;

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        drawShips();
        frame.setVisible(true);
    }

    private void drawShips(){
        String[] columnNames = {"Name", "Faction", "HP", "Crew Size"};

        String[][] shipDataArray = new String[game.getShips().size()][4];

        for (int i = 0; i < game.getShips().size(); i++) {
            Ship ship = game.getShips().get(i);

            shipDataArray[i][0] = ship.getName();
            shipDataArray[i][1] = ship.getFaction();
            shipDataArray[i][2] = ""+ship.getHP();
            shipDataArray[i][3] = ""+ship.getCrewSize();            
        }

        JTable shipsTable = new JTable(shipDataArray, columnNames);
        shipsTable.setBounds(0, 0, 200, 300);

        JScrollPane sp = new JScrollPane(shipsTable);

        frame.add(sp);

    }
}