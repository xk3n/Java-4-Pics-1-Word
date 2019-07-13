/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4pics1word;

import java.awt.Color;
import javax.swing.*;

public class Main implements Runnable {
    int width = 500;
    int height = 700;
    JFrame f;
    JLabel bg;
    JLabel logo;
    JButton play,exit;
    ImageIcon bgImage = new ImageIcon("assets\\bg.png");
    ImageIcon logoImage = new ImageIcon("assets\\logo.png");
    ImageIcon playImage = new ImageIcon("assets\\play.png");
    ImageIcon exitImage = new ImageIcon("assets\\exit.png");
    public static void main(String[] args) {
        Main game = new Main();
        game.run();
    }

    @Override
    public void run() {
        f = new JFrame("4 Pics 1 word");
        f.setSize(width, height);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        
        play = new JButton(playImage);
        play.setOpaque(false);
        play.setBackground(Color.red);
        play.setBorder(null);
        play.setBounds(width/2-playImage.getIconWidth()/2, height/2+50, playImage.getIconWidth(), playImage.getIconHeight());
        f.add(play);
        
        exit = new JButton(exitImage);
        exit.setOpaque(false);
        exit.setBackground(Color.red);
        exit.setBorder(null);
        exit.setBounds(width/2-exitImage.getIconWidth()/2, height/2+200, exitImage.getIconWidth(), exitImage.getIconHeight());
        f.add(exit);
        
        
        logo = new JLabel(logoImage);
        logo.setBounds(width/2-logoImage.getIconWidth()/2, height/2-logoImage.getIconHeight(), logoImage.getIconWidth(), logoImage.getIconHeight());
        f.add(logo);
                
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, width, height);
        f.add(bg);
        
        play.addActionListener(e->{
            f.dispose();
            new Game();
        });
        
        
        exit.addActionListener(e->{
            int exitChoice = JOptionPane.showConfirmDialog(
                                f, 
                                "Do you really want to exit?", 
                                "Confirmation", 
                                JOptionPane.YES_NO_OPTION, 
                                JOptionPane.ERROR_MESSAGE);
            if(exitChoice == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });
    }
    
}
