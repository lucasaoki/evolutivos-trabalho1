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
public abstract class MazeSolution{
    
    protected double totalDistance;
    protected boolean totalDistanceValid;
    protected boolean flag = true;
    protected int solutionLimitSize;
    
    protected Maze maze;

    public MazeSolution(Maze maze, int solutionLimitSize) {
        this.solutionLimitSize = solutionLimitSize;
        totalDistanceValid =false;
        this.maze = maze;
    }

    public boolean isTotalDistanceValid() {
        return totalDistanceValid;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
        totalDistanceValid = true;
    }
    
   public int getSolutionLimitSize() {
        return solutionLimitSize;
    }

    public void setSolutionLimitSize(int solutionLimitSize) {
        this.solutionLimitSize = solutionLimitSize;
    }
    
    public boolean isSolutionFound()
    {
        return getVertexAt(getSize() - 1).getIndex() == maze.getEndVert().getIndex();
    }
    
    public abstract int getSize();
    
    public abstract boolean addVertex(MazeVertex vertex);
    
    public abstract boolean addVertexAt(int index, MazeVertex vertex);
    
    public abstract boolean addVertexRange( List<MazeVertex> vertices);
    
    public abstract boolean addVertexRangeAt(int indexStart, List<MazeVertex> vertices);
    
    public abstract boolean addDirection(Directions direction);
    
    public abstract boolean addDirectionAt(int index, Directions direction);
    
    public abstract boolean addDirectionRange( List<Directions> directions);
     
    public abstract boolean addDirectionRangeAt(int indexStart, List<Directions> directions);
    
    public abstract MazeVertex getVertexAt(int index);
    
    public abstract List<MazeVertex> getVertexRange(int indexStart, int indexEnd);
    
    public abstract Directions getDirectionAt(int index);
    
    public abstract List<Directions> getDirectionsRange(int indexStart, int indexEnd);
    
    public abstract boolean setVertexAt(int index, MazeVertex vertex);
    
    public abstract boolean setDirectionAt(int index, Directions direction);
    
    public abstract boolean removeAt(int index);
    
    public abstract boolean removeRange(int indexStart, int indexEnd);
    
    public abstract void Copy(MazeSolution mazesol);
    
    public abstract boolean validate();

}
