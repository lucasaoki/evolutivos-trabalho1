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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.Transparency;

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
    Graphics2D g2d;

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
        g2d = (Graphics2D) g;
        double max_x, max_y;
        g2d.setColor(Color.red);
        ArrayList<MazeVertex> vertices = maze.getVertices();
        Set<MazeEdge> edges = maze.edgeSet();

        float[] hsb;
        max_x = img.getWidth();
        max_y = img.getHeight();

        g2d.setFont(new Font("TimesRoman", Font.BOLD, 10));
        g2d.setStroke(new BasicStroke(1));

        BufferedImage tmpImage = getGraphicsConfiguration().createCompatibleImage(screen_width, screen_height, Transparency.TRANSLUCENT);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.drawImage(img, 0, 0, screen_width, screen_height, null);

        for (MazeEdge edge : edges) {
            MazeVertex vertex = maze.getEdgeSource(edge);
            MazeVertex vertex2 = maze.getEdgeTarget(edge);

            int pos_x = (int) ((vertex.getX() * screen_width / max_x));
            int pos_y = (int) ((vertex.getY() * screen_height / max_y));
            int pos_x1 = (int) ((vertex2.getX() * screen_width / max_x));
            int pos_y1 = (int) ((vertex2.getY() * screen_height / max_y));

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(pos_x, pos_y, pos_x1, pos_y1);
        }

        for (MazeVertex vertex : vertices) {
            int pos_x = (int) ((vertex.getX() * screen_width / max_x));
            int pos_y = (int) ((vertex.getY() * screen_height / max_y));

            g2d.setColor(Color.magenta);
            g2d.fillOval((int) (pos_x - 4), (int) (pos_y - 4), 8, 8);

            g2d.setColor(Color.blue);
            g2d.drawString("" + vertex.getIndex() + "", (pos_x - 4), (pos_y - 5));
        }
        if (mazeS != null) {
            double angle = 60;
            double[] contador = new double[vertices.size()];
            for (int c = 0; c < vertices.size(); c++) {
                contador[c] = 0;
            }

            MazeVertex vert_inicial = maze.getStartVert();
            MazeVertex vert_end = maze.getEndVert();
            int initial_x = (int) ((vert_inicial.getX() * screen_width / max_x));
            int initial_y = (int) ((vert_inicial.getY() * screen_height / max_y));
            int end_x = (int) ((vert_end.getX() * screen_width / max_x));
            int end_y = (int) ((vert_end.getY() * screen_height / max_y));
            int aux_x = (int) ((mazeS.getVertexAt(0).getX() * screen_width / max_x));
            int aux_y = (int) ((mazeS.getVertexAt(0).getY() * screen_height / max_y));

            g2d.setColor(Color.blue);
            g2d.fillOval(initial_x - 4, initial_y - 4, 10, 10);

            //yellow
            g2d.setStroke(new BasicStroke(3));
            setColor(0, 255, 255);
            g2d.fillOval(end_x - 4, end_y - 4, 10, 10);

            
            //Green
            g2d.setStroke(new BasicStroke(3));
            setColor(107,142,35);
            g2d.drawLine(initial_x, initial_y, aux_x, aux_y);

            for (int c = 0; c < mazeS.getSize() - 1; c++) {
                MazeVertex vertex = mazeS.getVertexAt(c);
                MazeVertex vertex1 = mazeS.getVertexAt(c + 1);

                int pos_x = (int) ((vertex.getX() * screen_width / max_x));
                int pos_y = (int) ((vertex.getY() * screen_height / max_y));
                int pos_x1 = (int) ((vertex1.getX() * screen_width / max_x));
                int pos_y1 = (int) ((vertex1.getY() * screen_height / max_y));

                if (c == mazeS.getSize() - 2) {
                    g2d.setColor(Color.orange);
                    g2d.fillOval(pos_x1 - 4, pos_y1 - 4, 10, 10);
                }
                //Green
                g2d.setStroke(new BasicStroke(3));
                setColor(107, 142, 35);
                g2d.drawLine(pos_x, pos_y, pos_x1, pos_y1);
                g2d.setStroke(new BasicStroke(1));

                double pos_angle_cos = 10 * Math.cos(Math.toRadians(contador[vertex.getIndex()] * angle));
                double pos_angle_sin = -10 * Math.sin(Math.toRadians(contador[vertex.getIndex()] * angle));

                setColor(213, 100, 0);
                g2d.drawLine(pos_x, pos_y, pos_x1, pos_y1);g2d.drawString("" + c + "", (int) ((pos_x) + pos_angle_sin), (int) ((pos_y) + pos_angle_cos));
                contador[vertex.getIndex()]++;
            }
        }
    }
    private void setColor(int r, int g, int b){
        
        float[] hsb = Color.RGBtoHSB(  r, g, b, null);
        g2d.setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
        
    } 
    @Override
    public void paint(Graphics screen) {
        super.paint(screen);

        Draw((Graphics2D) screen);
        g2d.dispose();
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
