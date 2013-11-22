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
public class MazeSolutionVertex extends MazeSolution{

    ArrayList<MazeVertex> mazeVertex;

    public MazeSolutionVertex(Maze maze, int solutionLimitSize) {
        super(maze, solutionLimitSize);
         mazeVertex = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return mazeVertex.size();
    }

    @Override
    public boolean addVertex(MazeVertex vertex) {
        if (mazeVertex.size() >= solutionLimitSize){
            System.out.println("Solution is full of vertex!");
            return false;
        }
        else
        {
            mazeVertex.add(vertex);
            totalDistanceValid = false;
            return true;
        }
    }

    @Override
    public boolean addDirection(Directions direction) {
		MazeVertex vtx;
    	if (mazeVertex.size() >= solutionLimitSize){
    		System.out.println("Solution is full of vertex!");
            return false;
    	} else {
    		if( mazeVertex.size() >= 0 ){
    			if( mazeVertex.size() == 0 ){
    				vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), maze.getStartVert(), direction);
    			} else if (mazeVertex.size() == 1) {
    				vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), mazeVertex.get(mazeVertex.size()-1), direction);
    			} else {
    				vtx = MazeUtils.GetDestiny(maze, mazeVertex.get(mazeVertex.size()-2), mazeVertex.get(mazeVertex.size()-1), direction);
    			}

    			if(vtx != null){
    				mazeVertex.add(vtx);
    				totalDistanceValid = false;
    				return true;
    			} else
    				return false;

    		}
    		else
    			return false;
    	}
    }

    @Override
    public MazeVertex getVertexAt(int index) {
       if (index >= 0 && index < mazeVertex.size())
           return mazeVertex.get(index);
       else
           return null;
    }

    @Override
    public Directions getDirectionAt(int index) {
        if( index >= 0 ){
        	if( index == 0 ){
        		return MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), mazeVertex.get(index).getLocation());
        	} else if ( index == 1) {
				return MazeUtils.GetDirections(maze.getStartVert().getLocation(), mazeVertex.get(index-1).getLocation(), mazeVertex.get(index).getLocation());
			} else {
				return MazeUtils.GetDirections(mazeVertex.get(index-2).getLocation(), mazeVertex.get(index-1).getLocation(), mazeVertex.get(index).getLocation());
			}
        }
        else
        	return null;
    }

    @Override
    public boolean setVertexAt(int index, MazeVertex vertex) {
       if (index >= 0 && index < mazeVertex.size())
       {
          mazeVertex.set(index, vertex);
          totalDistanceValid = false;
          return true;
       }
       else
           return false;
    }

    @Override
    public boolean setDirectionAt(int index, Directions direction) {
    	MazeVertex vtx;
    	
    	if( index >= 0 && index < mazeVertex.size() ){
    		if(index == 0){
    			vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), maze.getStartVert(), direction);
    		} else if (index == 1) {
				vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), mazeVertex.get(index-1), direction);
			} else {
				vtx = MazeUtils.GetDestiny(maze, mazeVertex.get(index-2), mazeVertex.get(index-1), direction);
			}
    		if(vtx != null)
    			return this.setVertexAt(index, vtx);
    		else
    			return false;
    		
    	} else
    		return false;
    }

    @Override
    public boolean addVertexAt(int index, MazeVertex vertex) {
    	if( mazeVertex.size() >= solutionLimitSize){
    		System.out.println("Solution is full of vertex!");
            return false;
    	} else {
    		if (index >= 0 && index < mazeVertex.size()){
    			mazeVertex.add(index, vertex);
    			totalDistanceValid = false;
    			return true;
    		}
    		else
    			return false;
    	}
    }

    @Override
    public boolean addDirectionAt(int index, Directions direction) {
        MazeVertex vtx;
    	
    	if(mazeVertex.size() >= solutionLimitSize){
        	System.out.println("Solution is full of vertex!");
            return false;
        } else {
        	if( index >= 0 && index < mazeVertex.size() ){
        		if( index == 0 ){
        			vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), maze.getStartVert(), direction);
        		} else if (index == 1) {
					vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), mazeVertex.get(index-1), direction);
				} else {
					vtx = MazeUtils.GetDestiny(maze, mazeVertex.get(index-2), mazeVertex.get(index-1), direction);
				}
        		
        		if(vtx != null ){
        			return this.addVertexAt(index, vtx);
        		} else
        			return false;
        	} else 
        		return false;
        }
    }

    @Override
    public boolean addVertexRange(List<MazeVertex> vertices) {
        
    	if(vertices == null ){
    		System.out.println("MazeSolutionVertex.addVertexRange: ERROR: Null Parameter.");
    		return false;
    	} else {
    		if (mazeVertex.size() > solutionLimitSize + vertices.size() ){
    			System.out.println("Solution is full of vertex!");
    			return false;
    		}
    		else
    		{
    			for (int c= 0; c< vertices.size();c++)
    			{
    				mazeVertex.add(vertices.get(c));
    			}   
    			totalDistanceValid = false;
    			return true;
    		}
    	}
    }


    @Override
    public boolean addDirectionRange(List<MazeVertex> vertices) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAt(int index) {
        if (index >= 0 && index < mazeVertex.size()){
        	mazeVertex.remove(index);
        	totalDistanceValid = false;
        	return true;
        }
        else
        	return false;
    }

    @Override
    public boolean removeRange(int indexStart, int indexEnd) {
    	
    	if(indexEnd > indexStart){
    		if( indexStart >= 0 && indexEnd < mazeVertex.size() )
    		{
    			for (int i = indexStart; i < indexEnd+1; i++) {
    				mazeVertex.remove(indexStart);
    			}
    			totalDistanceValid = false;
    			return true;
    		}
    		else
    			return false;
    	} else {
    		if( indexEnd >= 0 && indexStart < mazeVertex.size() )
    		{
    			for (int i = indexEnd; i < indexStart; i++) {
					mazeVertex.remove(indexEnd);
				}
    			totalDistanceValid = false;
    			return true;
    		}
    		else
    			return false;
    	}
    }

	@Override
	public boolean addVertexRangeAt(int indexStart, List<MazeVertex> vertices) {
		int index = 0;
		
		if( mazeVertex.size() + vertices.size() > solutionLimitSize ){
			System.out.println("Solution is full of vertex!");
            return false;
		} else {
			if (indexStart >= 0 && indexStart <= mazeVertex.size()){
				for (int i = indexStart; i < vertices.size(); i++) {
					mazeVertex.add(i, vertices.get(index++));
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
		
		if(directions == null ){
			System.out.println("MazeSolutionVertex.addDirectionRangeAt: ERROR: Null Parameter.");
			return false;
		}
		
		if( mazeVertex.size() + directions.size() >= solutionLimitSize ){
			System.out.println("Solution is full of vertex!");
            return false;
		} else {
			if( indexStart >= 0 && indexStart < mazeVertex.size() ){
				for (int i = indexStart; i < indexStart+directions.size(); i++) {
					this.addDirectionAt(i, directions.get(index++));
				}
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<MazeVertex> getVertexRange(int indexStart, int indexEnd) {
		
		List<MazeVertex> list;
		
		if( indexEnd > indexStart){
			if( indexStart >= 0 && indexEnd < mazeVertex.size() ){
			
				return mazeVertex.subList(indexStart, indexEnd);
			} 
			else
				return null;
			
		} else {
			if( indexEnd >=0 && indexStart < mazeVertex.size() ){
				list = mazeVertex.subList(indexEnd, indexStart);
				Collections.reverse(list);
				
				return list;
			}
			else
				return null;
		}
	}

	@Override
	public List<Directions> getDirectionsRange(int indexStart, int indexEnd) {
		List<Directions> directions = new ArrayList<Directions>();
		
		if(indexStart < indexEnd ){
			if( indexStart >= 0 && indexEnd < mazeVertex.size() ){
				for (int i = indexStart; i < indexEnd+1; i++) {
					directions.add(this.getDirectionAt(i));
				}
				return directions;
			} else
				return null;
		} else {
			if( indexEnd >= 0 && indexStart < mazeVertex.size() ){
				for (int i = indexStart; i > indexEnd-1; i--) {
					directions.add(this.getDirectionAt(i));
				}
				return directions;
			} else
				return null;
		}
	}  
}
