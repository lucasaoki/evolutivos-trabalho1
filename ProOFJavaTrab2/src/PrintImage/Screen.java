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
import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.components.MazeEdge;
import ProOF.MaD.maze.components.MazeVertex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Dimension;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Screen extends JPanel {

    private int screen_width, screen_height;
    private BufferedImage img;
    private Maze maze;
    private MazeSolution mazeS;
    private int flag = 0;

    public Screen(int width, int height, Maze maze, String imageFail) {
        try {
            this.maze = maze;
            this.img = ImageIO.read(new File(imageFail));
            screen_width = width;
            screen_height = height;

            setPreferredSize(new Dimension(width, height));
            setBackground(Color.white);
            setDoubleBuffered(true);
        } catch (IOException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Draw(Graphics2D g) {
    Graphics2D g2d = (Graphics2D) g;
        
        double max_x, max_y;
        g2d.setColor(Color.red);
        ArrayList<MazeVertex> vertices = maze.getVertices();
        Set<MazeEdge> edges = maze.edgeSet();

        max_x = img.getWidth();
        max_y = img.getHeight();
        g2d.setColor(Color.LIGHT_GRAY);
        for (MazeEdge edge : edges) {
            MazeVertex vertex = maze.getEdgeSource(edge);
            MazeVertex vertex2 = maze.getEdgeTarget(edge);
            int pos_x = (int) ((vertex.getX() * screen_width / max_x));
            int pos_y = (int) ((vertex.getY() * screen_height / max_y));
            int pos_x1 = (int) ((vertex2.getX() * screen_width / max_x));
            int pos_y1 = (int) ((vertex2.getY() * screen_height / max_y));
            g2d.drawLine( pos_x ,pos_y , pos_x1, pos_y1);
        }

        g2d.setColor(Color.red);
        for (MazeVertex vertex : vertices) {
            int pos_x = (int) ((vertex.getX() * screen_width / max_x));
            int pos_y = (int) ((vertex.getY() * screen_height / max_y));
            g2d.drawString("" + vertex.getIndex() + "", (pos_x-4), (pos_y-10));
            g2d.fillOval((int) ((vertex.getX()* screen_width / max_x)-4), (int) ((vertex.getY() * screen_height / max_y)-4), 8, 8);
        }
        if(mazeS != null){
            double angle  = 90;
            double[] contador = new double[mazeS.getSize()];
            for(int c = 0 ; c < mazeS.getSize(); c++){
                contador[c] = 0;
            }
            for (int c = 0; c < mazeS.getSize() - 1; c++) {
                MazeVertex vertex = mazeS.getVertexAt(c);
                MazeVertex vertex1 = mazeS.getVertexAt(c + 1);
                int pos_x = (int) ((vertex.getX() * screen_width / max_x));
                int pos_y = (int) ((vertex.getY() * screen_height / max_y));
                int pos_x1 = (int) ((vertex1.getX() * screen_width / max_x));
                int pos_y1 = (int) ((vertex1.getY() * screen_height / max_y));
                
                if(c == mazeS.getSize() - 1){
                    g2d.setColor(Color.ORANGE);
                    g2d.fillOval(pos_x1-4, pos_y1-4, 10, 10);
                }
                else{
                    if(c == 0){
                        g2d.setColor(Color.magenta);
                        g2d.fillOval(pos_x-4, pos_y-4, 10, 10);
                    }
                }
                g2d.setColor(Color.green);
                g2d.drawLine(pos_x, pos_y, pos_x1, pos_y1);  
                double pos_angle = 15*Math.cos(Math.toRadians( contador[vertex.getIndex()]*angle));
                g2d.drawString("" + c + "", (int) ((pos_x-4) + pos_angle), (int) ((pos_y-10) - pos_angle));
                contador[vertex.getIndex()]++;
            }
        }
    }

    @Override
    public void paint(Graphics screen) {
        super.paint(screen);

        Draw((Graphics2D) screen);
        this.getGraphics().dispose();
    }

    public void callback(String[][] m) {
        repaint();
        try {
            Thread.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    public void drawMazeSolution(MazeSolution mazeS) {
        this.mazeS = mazeS;
    }
}
