/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeVertex;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ito
 */
public class MazeSolutionDirection extends MazeSolution{
	
	ArrayList<Directions> mazeDirections;

    public MazeSolutionDirection(Maze maze, int solutionLimitSize) {
        super(maze, solutionLimitSize);
        mazeDirections = new ArrayList<>();
    }

    @Override
    public int getSize() {
    	return mazeDirections.size();
    }

    @Override
    public boolean addVertex(MazeVertex vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDirection(Directions direction) {
    	if(direction != null){
    		if(mazeDirections.size() >= solutionLimitSize ){
    			System.out.println("Solution is full of direction!");
                return false;
    		} else{
    			mazeDirections.add(direction);
    			totalDistanceValid=false;
    			return true;
    		}
    	} else
    		return false;
    }

    @Override
    public MazeVertex getVertexAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Directions getDirectionAt(int index) {
    	if( index >= 0 && index < mazeDirections.size() ){
    		return mazeDirections.get(index);
    	} else
    		return null;
    }

    @Override
    public boolean setVertexAt(int index, MazeVertex vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setDirectionAt(int index, Directions direction) {
    	if(direction != null){
    		if( index >= 0 && index < mazeDirections.size() ){
    			mazeDirections.set(index, direction);
    			totalDistanceValid=false;
    			return true;
    		} else
    			return false;
    		
    	} else
    		return false;
    }

    @Override
    public boolean addVertexAt(int index, MazeVertex vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDirectionAt(int index, Directions direction) {
    	if(direction != null){
    		if(mazeDirections.size() >= solutionLimitSize){
    			if(index >= 0 && index < mazeDirections.size()){
    				System.out.println("Solution is full of direction!");
                    return false;
    			} else {
    				mazeDirections.add(index, direction);
    				totalDistanceValid = false;
    				return true;
    			}
    		} else
    			return false;
    	} else
    		return false;
    }

    @Override
    public boolean addVertexRange(List<MazeVertex> vertices) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDirectionRange(List<Directions> directions) {
    	boolean res = false;
    	
    	if(directions != null){
    		if(mazeDirections.size() + directions.size() >= solutionLimitSize ){
    			System.out.println("Solution is full of direction!");
                return false;
    		} else {
    			for (int i = 0; i < directions.size(); i++) {
					res = this.addDirection(directions.get(i));
				}
    			return res;
    		}
    	} else
    		return false;
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
