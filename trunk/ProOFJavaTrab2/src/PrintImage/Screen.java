/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintImage;

/**
 *
 * @author Seiji
 */
import MaD.maze.Maze;
import MaD.maze.components.MazeEdge;
import MaD.maze.components.MazeVertex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Screen extends JPanel {

    private int screen_width, screen_height;
    private BufferedImage img;
    private Maze maze;

    public Screen(int width, int height, Maze maze) {
        try {
            this.maze = maze;
            this.img = ImageIO.read(new File(""));
            screen_width = width;
            screen_height = height;
            
            setPreferredSize(new Dimension(width, height));
            setBackground(Color.white);
            setDoubleBuffered(true);
        } catch (IOException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, 0, 0, null);
        g2d.setColor(Color.red);

        maze.getVertices();
        Set<MazeEdge > edges = maze.edgeSet();
        for(MazeEdge edge : edges){
           MazeVertex vertex =  maze.getEdgeSource(edge) ;
            g2d.drawOval(vertex.getPosX(), vertex.getPosY(), 2, 2);
        }
    }

    public void paint(Graphics screen) {
        super.paint(screen);

        draw((Graphics2D) screen);

        Toolkit.getDefaultToolkit().sync();
        screen.dispose();
    }

    public void callback(String[][] m) {
        repaint();
        try {
            Thread.sleep(3);
        } catch (InterruptedException ie) {
        }
    }
}
