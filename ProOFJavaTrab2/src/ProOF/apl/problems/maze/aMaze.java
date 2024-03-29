/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import PrintImage.Windows;
import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.MazeSolutionVertex;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.com.Communication;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.StreamPrinter;
import ProOF.com.language.Node;
import ProOF.utils.GlobalConstants;
import java.awt.Window;
import java.util.ArrayList;

/**
 *
 * @author ito
 */
public abstract class aMaze extends Node {

    private StreamPrinter com;
    
    protected Windows winMaze;

    protected Maze maze;
    protected int startVertexIndex;
    protected int endVertexIndex;
    protected MazeSolution optimalSolution;

    public aMaze() {
        com = null;
        maze = null;
        optimalSolution = null;
    }

    public Maze getMaze() {
        return maze;
    }

    public int getStartVertexIndex() {
        return startVertexIndex;
    }

    public int getEndVertexIndex() {
        return endVertexIndex;
    }

    protected double _evaluate(MazeSolution sol) {
        double sum = 0;

        sum += maze.getEdgeWeight(maze.getEdge(maze.getVertexFromIndex(startVertexIndex), sol.getVertexAt(0)));

        for (int c = 0; c < sol.getSize() - 1; c++) {
            sum += maze.getEdgeWeight(maze.getEdge(sol.getVertexAt(c), sol.getVertexAt(c + 1)));
        }

        if (!sol.isSolutionFound()) {
            sum += 999000;  //FIXME: parametrizar esse 1000
        }

        sol.setTotalDistance(sum);

        return sum;
    }

    public abstract double Evaluate(iCodification codif) throws Exception;

    public MazeSolution getDefinedMinGlobal() throws Exception {
        return optimalSolution;
    }

    protected void printLine(String str) throws Exception {
        com.printString("Info", str);
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {

        startVertexIndex = link.Int("start Vertex", GlobalConstants.vertexDefaultStartIndex, 0, 999999);
        endVertexIndex = link.Int("end Vertex", GlobalConstants.vertexDefaultEndIndex, 0, 999999);
    }

    @Override
    public void load() throws Exception {
        com = Communication.mkPrinter("Function Info");

    }

    @Override
    public void start() throws Exception {
        //init code here if any
        
        maze.initialize(maze.getVertexFromIndex(startVertexIndex), maze.getVertexFromIndex(endVertexIndex));
        
        ArrayList<MazeVertex> optimalVerticesPath = maze.optimalVerticesPath(maze.getVertexFromIndex(startVertexIndex), maze.getVertexFromIndex(endVertexIndex));

        optimalSolution = new MazeSolutionVertex(maze,maze.getVertices().size());
        optimalSolution.addVertexRange(optimalVerticesPath);
        optimalSolution.removeAt(0);
        
        System.out.println("Melhor solucao: ");
        for (int c= 0;c < optimalVerticesPath.size(); c++)
        {
            System.out.println(optimalVerticesPath.get(c).getIndex());
        }

        _evaluate(optimalSolution);
        
        System.out.println("Distancia: " + optimalSolution.getTotalDistance());
        
        Windows w = new Windows("Solucao otima",600, 600, maze, GlobalConstants.mapadir);
        w.setSolution(optimalSolution);
    }

    @Override
    public boolean validation(LinkerValidations link) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void results(LinkerResults link) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
