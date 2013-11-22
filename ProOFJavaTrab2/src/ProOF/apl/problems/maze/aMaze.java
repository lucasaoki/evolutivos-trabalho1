/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.com.Communication;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.StreamPrinter;
import ProOF.com.language.Node;
import java.util.ArrayList;

/**
 *
 * @author ito
 */
public abstract class aMaze extends Node {

    private StreamPrinter com;

    protected Maze maze;
    protected int startVertexIndex;
    protected int endVertexIndex;
    protected MazeSolution optimalSolution;

    public aMaze() {
        com = null;
        maze = null;
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

        if (sol.getVertexAt(sol.getSize() - 1).getIndex() != endVertexIndex) {
            sol.setSolutionFound(false);
            sum += 1000;  //FIXME: parametrizar esse 1000
        } else {
            sol.setSolutionFound(true);
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
        startVertexIndex = link.Int("start Vertex", maze.getStartVert().getIndex(), 0, maze.vertexSet().size());
        endVertexIndex = link.Int("end Vertex", maze.getEndVert().getIndex(), 0, maze.vertexSet().size());
        ArrayList<MazeVertex> optimalVerticesPath = maze.optimalVerticesPath(maze.getVertexFromIndex(startVertexIndex), maze.getVertexFromIndex(endVertexIndex));

        optimalSolution.addDirectionRange(optimalVerticesPath);
        
        _evaluate(optimalSolution);

    }

    @Override
    public void load() throws Exception {
        com = Communication.mkPrinter("Function Info");

    }

    @Override
    public void start() throws Exception {
        //init code here if any
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