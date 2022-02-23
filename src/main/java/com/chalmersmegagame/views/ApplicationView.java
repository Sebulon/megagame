package com.chalmersmegagame.views;

import java.awt.*;
import javax.swing.JFrame;
import com.chalmersmegagame.game.MainGame;

public class ApplicationView extends Canvas{

    public ApplicationView(int width, int height, String title, MainGame game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        //game.start();
    }
}