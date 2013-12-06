/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeVertex;
import ProOF.MaD.maze.utils.MazeUtils;

import java.util.ArrayList;
import java.util.Collections;
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
    	Directions dir;
        if(vertex != null){
        	if(mazeDirections.size() >= solutionLimitSize ){
    			System.out.println("Solution is full of direction!");
                return false;
    		} else {
    			if(mazeDirections.size() >= 0){
    				if(mazeDirections.size() == 0){
    					dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), vertex.getLocation());
    				} else if (mazeDirections.size() == 1) {
    					dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertex.getLocation());
    				} else {
    					dir = MazeUtils.GetDirections(MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-2).getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertex.getLocation());
    				}
    				
    				if(dir != null ){
    					mazeDirections.add(dir);
    					totalDistanceValid = false;
    					return true;
    				} else
    					return false;
    			} else
    				return false;
    		}
        }
        return false;
    }

    @Override
    public boolean addDirection(Directions direction) {
    	if(direction != null){
    		if( mazeDirections.size() >= solutionLimitSize ){
    			System.out.println("Solution is full of direction!");
                return false;
    		} else{
    			mazeDirections.add(direction);
    			totalDistanceValid = false;
    			return true;
    		}
    	} else
    		return false;
    }

    @Override
    public MazeVertex getVertexAt(int index) {
        return MazeUtils.getVertex(maze, mazeDirections, index);
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
    	Directions dir;
    	
    	if( index >= 0 && index < mazeDirections.size() && vertex != null){
    		if(mazeDirections.size() == 0){
    			dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), vertex.getLocation());
    		} else if (mazeDirections.size() == 1) {
    			dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertex.getLocation());
    		} else {
    			dir = MazeUtils.GetDirections(MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-2).getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertex.getLocation());
    		}
    		
    		if( dir != null){
    			mazeDirections.set(index, dir);
    			totalDistanceValid = false;
    			return true;
    		} else
    			return false;
    	}
    	return false;
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
    	Directions dir;
    	if(mazeDirections.size() >= solutionLimitSize ){
    		System.out.println("Solution is full of direction!");
            return false;
    	} else {
    		if( index >= 0 && index < mazeDirections.size() && vertex != null ){
    			if(mazeDirections.size() == 0){
    				dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), vertex.getLocation());
    			} else if (mazeDirections.size() == 1) {
    				dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertex.getLocation());
    			} else {
    				dir = MazeUtils.GetDirections(MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-2).getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertex.getLocation());
    			}

    			if( dir != null){
    				mazeDirections.add(index, dir);
    				totalDistanceValid = false;
    				return true;
    			} else
    				return false;
    		}
    		return false;
    	}
    }

    @Override
    public boolean addDirectionAt(int index, Directions direction) {
    	if(direction != null){
    		if(mazeDirections.size() >= solutionLimitSize){
    			System.out.println("Solution is full of direction!");
    			return false;
    		} else {
    			if(index >= 0 && index < mazeDirections.size()){
    				mazeDirections.add(index, direction);
    				totalDistanceValid = false;
    				return true;
    			} else
    				return false;
    		}
    	} else
    		return false;
    }

    @Override
    public boolean addVertexRange(List<MazeVertex> vertices) {
        boolean res = false;
        Directions dir;
        
        if(vertices != null){
        	if(mazeDirections.size() + vertices.size() >= solutionLimitSize ){
        		System.out.println("Solution is full of direction!");
                return false;
        	} else {
        		for (int i = 0; i < vertices.size(); i++) {
        			if(mazeDirections.size() == 0){
            			dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), vertices.get(i).getLocation());
            		} else if (mazeDirections.size() == 1) {
            			dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertices.get(i).getLocation());
            		} else {
            			dir = MazeUtils.GetDirections(MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-2).getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertices.get(i).getLocation());
            		}
        			
        			if(dir != null){
        				res = mazeDirections.add(dir);
        			}
				}
        		totalDistanceValid = false;
        		return res;
        	}
        }
        return false;
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
    			totalDistanceValid = false;
    			return res;
    		}
    	} else
    		return false;
    }

    @Override
    public boolean removeAt(int index) {
        if(index >= 0 && index < mazeDirections.size()){
        	mazeDirections.remove(index);
        	totalDistanceValid = false;
        	return true;
        }
        return false;
    }

    @Override
    public boolean removeRange(int indexStart, int indexEnd) {
    	if( indexEnd >= 0 && indexEnd < mazeDirections.size() && indexStart >=0 && indexStart < mazeDirections.size() )
    	{
    		if(indexEnd > indexStart){
    			for (int i = indexStart; i < indexEnd+1; i++) {
    				mazeDirections.remove(indexStart);
    			}
    			totalDistanceValid = false;
    			return true;

    		} else {
    			for (int i = indexEnd; i < indexStart+1; i++) {
    				mazeDirections.remove(indexEnd);
    			}
    			totalDistanceValid = false;
    			return true;
    		}
    	}
    	return false;
    }

	@Override
	public boolean addVertexRangeAt(int indexStart, List<MazeVertex> vertices) {
		int index = 0;
		Directions dir;

		if( mazeDirections.size() + vertices.size() > solutionLimitSize ){
			System.out.println("Solution is full of direction!");
			return false;
		} else {
			if (indexStart >= 0 && indexStart < mazeDirections.size()){
				for (int i = indexStart; i < vertices.size(); i++) {
					if(mazeDirections.size() == 0){
            			dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), vertices.get(index++).getLocation());
            		} else if (mazeDirections.size() == 1) {
            			dir = MazeUtils.GetDirections(maze.getStartVert().getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertices.get(index++).getLocation());
            		} else {
            			dir = MazeUtils.GetDirections(MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-2).getLocation(), MazeUtils.getVertex(maze, mazeDirections, mazeDirections.size()-1).getLocation(), vertices.get(index++).getLocation());
            		}
        			
        			if(dir != null){
        				mazeDirections.add(i, dir);
        			}
				}
				totalDistanceValid = false;
				return true;
			}
			else
				return false;
		}
	}

	@Override
	public boolean addDirectionRangeAt(int indexStart, List<Directions> directions) {
		int index = 0;

		if( mazeDirections.size() + directions.size() > solutionLimitSize ){
			System.out.println("Solution is full of direction!");
			return false;
		} else {
			if (indexStart >= 0 && indexStart <= mazeDirections.size()){
				for (int i = indexStart; i < directions.size(); i++) {
					mazeDirections.add(i, directions.get(index++));
				}
				totalDistanceValid = false;
				return true;
			}
			else
				return false;
		}
	}

	@Override
	public List<MazeVertex> getVertexRange(int indexStart, int indexEnd) {
		List<MazeVertex> list = new ArrayList<MazeVertex>();
		MazeVertex vtx;

		if( indexEnd >= 0 && indexEnd < mazeDirections.size() && indexStart >= 0 && indexStart < mazeDirections.size() ){
			if( indexEnd > indexStart){
				for (int i = indexStart; i < indexEnd; i++) {
					vtx = MazeUtils.getVertex(maze, mazeDirections, i);
					list.add(vtx);
				}
				return list;

			} else {
				for (int i = indexEnd; i < indexStart; i++) {
					vtx = MazeUtils.getVertex(maze, mazeDirections, i);
					list.add(vtx);
				}
				Collections.reverse(list);
				return list;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Directions> getDirectionsRange(int indexStart, int indexEnd) {
		ArrayList<Directions> list = new ArrayList<Directions>();

		if( indexEnd >= 0 && indexEnd < mazeDirections.size() && indexStart >= 0 && indexStart < mazeDirections.size() ){
			if( indexEnd > indexStart){
				
				for (int i = indexStart; i < indexEnd; i++) {
					list.add(mazeDirections.get(i));
				}
				return list;

			} else {
				for (int i = indexEnd; i < indexStart; i++) {
					list.add(mazeDirections.get(i));
				}
				Collections.reverse(list);
				return list;

			}
		}
		return null;
	}

    @Override
    public void Copy(MazeSolution mazesol) {
    	if (mazesol instanceof MazeSolutionDirection)
        {
            MazeSolutionDirection m = (MazeSolutionDirection)mazesol;
            
            this.totalDistance = m.totalDistance;
            this.totalDistanceValid = m.totalDistanceValid;
            this.mazeDirections.clear();
            
            for(int c = 0 ;c < m.mazeDirections.size(); c++)
            {
                this.mazeDirections.add(m.mazeDirections.get(c));
            }
            
        }    
    	
    }

    @Override
    public MazeVertex repair(MazeVertex current, MazeVertex last) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validate(MazeSolution mazeS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
