/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze.teste;

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.components.MazeVertex;
import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.alg.DijkstraShortestPath;

/**
 *
 * @author lucasaoki
 */
public class TesteDjikstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 15; i < 61; i = i + 5) {

            double startTime = 0;
            double finalTime = 0;
            double totalTime = 0;
            double value = 0;
            String file = "media/maze" + i + "_out.png_graph.txt";
            System.out.println(file);

            Maze maze = new Maze(file);
//            MazeVertex start = maze.getVertexFromIndex(0);
//            MazeVertex dest = maze.getVertexFromIndex(maze.getVertices().size() - 1);

            ArrayList<MazeVertex> vertList = maze.getVertices();
            MazeVertex start = vertList.get(0);
            double menor = Point2D.distance(0, 0, start.getX(), start.getY());

            MazeVertex dest = vertList.get(0);
            double maior = Point2D.distance(0, 0, dest.getX(), dest.getY());

            for (int j = 1; j < vertList.size(); j++) {
                MazeVertex tmp = vertList.get(j);
                double atual = Point2D.distance(0, 0, tmp.getX(), tmp.getY());
                if (atual < menor) {
                    start = tmp;
                    menor = atual;
                }

                if (atual > maior) {
                    dest = tmp;
                    maior = atual;
                }
            }
//            System.out.println(start.getLocation());
//            System.out.println(dest.getLocation());

            startTime = System.currentTimeMillis();
            DijkstraShortestPath dij = new DijkstraShortestPath(maze, start, dest);
            finalTime = System.currentTimeMillis();
            totalTime = finalTime - startTime;

            try {
                FileWriter fstream = new FileWriter("media/times.txt", true);
                BufferedWriter bw = new BufferedWriter(fstream);

                bw.write(i + "x" + i + "\t" + totalTime);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(TesteDjikstra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
