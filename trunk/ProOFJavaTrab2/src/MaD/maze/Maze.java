/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaD.maze;

import MaD.maze.components.MazeEdge;
import MaD.maze.components.MazeVertex;
import java.util.ArrayList;
import java.util.List;
import org.jgrapht.WeightedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author aoki
 */
public class Maze {

    private WeightedGraph<MazeVertex, MazeEdge> maze;
    private ArrayList<MazeVertex> vertices;
    private ArrayList<MazeEdge> edges;
    private MazeVertex startVert;
    private MazeVertex endVert;
    private DijkstraShortestPath dijPath;

    public Maze(String mazeInfoFile) {

        maze = new SimpleWeightedGraph<MazeVertex, MazeEdge>(MazeEdge.class);
        //vertices
        //startVert
        //endVert
        //edges and its weights
        dijPath = new DijkstraShortestPath(maze, startVert, endVert);
    }

    public boolean loadMaze() {
        /* @TODO Read maze info, setup model. */
        return false;
    }

    /* @TODO Maybe, return MazeSolution */
    List optimalSolutionPath() {

        List path = dijPath.getPathEdgeList();
        if (path != null) {
            System.out.println("Shortest path between " + startVert + " - " + endVert);
            System.out.println(path);
        }
        /* @TODO set a return or write it to a file */
        return path;
    }

    double optimalSolutionWeight() {

        double tmp = dijPath.getPathLength();
        return tmp;
    }
}
