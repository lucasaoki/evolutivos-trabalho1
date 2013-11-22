/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeEdge;
import ProOF.MaD.maze.components.MazeVertex;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author aoki
 */
public class Maze extends SimpleWeightedGraph<MazeVertex, MazeEdge> {

//    private WeightedGraph<MazeVertex, MazeEdge> maze;
    private final String dataFile;
    private ArrayList<MazeVertex> vertices;
    private ArrayList<MazeEdge> edges;
    private MazeVertex startVert;
    private MazeVertex endVert;
    private DijkstraShortestPath dijPath;

    public Maze(String dataFile) {

        super(MazeEdge.class);
        this.dataFile = dataFile;
        loadMaze();
        //vertices
        startVert = vertices.get(0);
        endVert = vertices.get(vertices.size() - 1);
        //edges and its weights
        dijPath = new DijkstraShortestPath(this, startVert, endVert);
    }

    private void loadMaze() {
        /* @TODO Read maze info, setup model. */
        /* Load dataFile */
        try {
            File f = new File(dataFile);
            InputStream is = new FileInputStream(f);
            Scanner input = new Scanner(is);

            while (input.hasNext()) {
                String nextToken = input.nextLine();
                if (nextToken.equals("Vertice")) {
                    int n = input.nextInt();
                    vertices = new ArrayList<>(n);
                    for (int i = 0; i < n; i++) {
                        vertices.add(new MazeVertex(String.valueOf(i), input.nextInt(), input.nextInt()));
                        addVertex(vertices.get(i));
                    }
                }
                if (nextToken.equals("Edge")) {
                    int n = input.nextInt();
                    edges = new ArrayList<>(n);
                    for (int i = 0; i < n; i++) {
                        MazeVertex v1 = vertices.get(input.nextInt());
                        MazeVertex v2 = vertices.get(input.nextInt());
                        MazeEdge e = new MazeEdge(String.valueOf(i), v1, v2);
                        edges.add(e);
                        this.addEdge(v1, v2, e);
                        this.setEdgeWeight(e, e.calcEdgeWeight());
                    }
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MazeVertex getStartVert() {
        return startVert;
    }

    public MazeVertex getEndVert() {
        return endVert;
    }

    public ArrayList<MazeVertex> getVertices() {
        return vertices;
    }

    Set<MazeEdge> getEdgesFromVertex(MazeVertex vert) {
        return this.edgesOf(vert);
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

    public static void main(String[] args) {
        Maze mz = new Maze("media/Graph.txt");

//        System.out.println(mz.optimalSolutionWeight());
    }
}
