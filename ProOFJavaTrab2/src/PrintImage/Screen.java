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

import java.awt.Toolkit;
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

    public void draw(Graphics2D g) {

        Graphics2D g2d = (Graphics2D) g;
        BufferedImage resizedImage = new BufferedImage(screen_width, screen_height, img.getType());
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(img, 0, 0, screen_width, screen_height, null);
        g2.dispose();   
        double max_x, max_y;
        double min_x, min_y;
        g2d.drawImage(img, 0, 0, null);
        g2d.setColor(Color.red);

        ArrayList<MazeVertex> vertices = maze.getVertices();
        Set<MazeEdge> edges = maze.edgeSet();

        max_x = vertices.get(0).getX();
        max_y = vertices.get(0).getY();
        min_x = vertices.get(0).getX();
        min_y = vertices.get(0).getY();
        for (MazeVertex vertex : vertices) {
            if (vertex.getX() > max_x) {
                max_x = vertex.getX();
            }
            if (vertex.getY() > max_y) {
                max_y = vertex.getY();
            }
            if (vertex.getX() < min_x) {
                min_x = vertex.getX();
            }
            if (vertex.getY() < min_y) {
                min_y = vertex.getY();
            }
        }

        for (MazeEdge edge : edges) {
            MazeVertex vertex = maze.getEdgeSource(edge);
            MazeVertex vertex2 = maze.getEdgeTarget(edge);
            g2d.drawLine((int) ((vertex.getX() * screen_width / max_x)), (int) ((vertex.getY() * screen_height / max_y)), (int) ((vertex2.getX() * screen_width / max_x)), (int) ((vertex2.getY() * screen_height / max_y)));
        }

        g2d.setColor(Color.blue);
        for (MazeVertex vertex : vertices) {
            g2d.drawString("" + vertex.getIndex() + "", (int) ((vertex.getX() * screen_width / max_x)), (int) ((vertex.getY() * screen_height / max_y) + 20));
            g2d.fillOval((int) ((vertex.getX() * screen_width / max_x)), (int) ((vertex.getY() * screen_height / max_y)), 8, 8);
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

    public void drawMazeSolution(MazeSolution mazeS) {
        for (int c = 0; c < mazeS.getSize() - 1; c++) {
            MazeVertex vertexAt = mazeS.getVertexAt(c);
            MazeVertex vertexAt1 = mazeS.getVertexAt(c + 1);

            this.getGraphics().drawLine((int) vertexAt.getX(), (int) vertexAt.getY(), (int) vertexAt1.getX(), (int) vertexAt1.getY());
        }

    }
}
