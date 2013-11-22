/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeVertex;
import java.util.List;

/**
 *
 * @author ito
 */
public class MazeSolutionDirection extends MazeSolution{

    public MazeSolutionDirection(Maze maze, int solutionLimitSize) {
        super(maze, solutionLimitSize);
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addVertex(MazeVertex vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDirection(Directions direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MazeVertex getVertexAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Directions getDirectionAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setVertexAt(int index, MazeVertex vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setDirectionAt(int index, Directions direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addVertexAt(int index, MazeVertex vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDirectionAt(int index, Directions direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addVertexRange(List<MazeVertex> vertices) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDirectionRange(List<MazeVertex> vertices) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeRange(int indexStart, int indexEnd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public boolean addVertexRangeAt(int indexStart, List<MazeVertex> vertices) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDirectionRangeAt(int indexStart,
			List<Directions> directions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MazeVertex> getVertexRange(int indexStart, int indexEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Directions> getDirectionsRange(int indexStart, int indexEnd) {
		// TODO Auto-generated method stub
		return null;
	}

  
    
}
