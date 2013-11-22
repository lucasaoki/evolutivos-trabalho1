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
import ProOF.utils.GlobalConstants;

/**
 *
 * @author ito
 */
public abstract class aMaze extends Node {
    
    private StreamPrinter com;
    
    protected Maze maze;
    protected int startVertexIndex;
    protected int endVertexIndex;

    public aMaze() {
	com = null;
        maze = null;
    }
    
    public Maze getMaze()
    {
        return maze;
    }

    public int getStartVertexIndex() {
        return startVertexIndex;
    }

    public int getEndVertexIndex() {
        return endVertexIndex;
    }
    
    

    public abstract double Evaluate(iCodification codif) throws Exception;

    public MazeSolution getDefinedMinGlobal() throws Exception {
        maze.getdbasdf;
	printLine("Warning: MinGlobal not defined");
	return null;
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
	startVertexIndex =  link.Int("start Vertex", maze.getStartVert(), 0, maze.vertexSet().size());
        endVertexIndex =  link.Int("end Vertex", maze.getEndVert(), 0, maze.vertexSet().size());
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
