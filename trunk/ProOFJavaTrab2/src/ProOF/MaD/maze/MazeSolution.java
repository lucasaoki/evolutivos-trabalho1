/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeVertex;



/**
 *
 * @author ito
 */
public abstract class MazeSolution{
    
    protected int solutionLimitSize;
    protected boolean solutionFound;

    public MazeSolution(int solutionLimitSize) {
        this.solutionLimitSize = solutionLimitSize;
        solutionFound = false;
    }

    public boolean isSolutionFound() {
        return solutionFound;
    }

    public void setSolutionFound(boolean solutionFound) {
        this.solutionFound = solutionFound;
    }
    
    

    public int getSolutionLimitSize() {
        return solutionLimitSize;
    }

    public void setSolutionLimitSize(int solutionLimitSize) {
        this.solutionLimitSize = solutionLimitSize;
    }
    
    
    
    
    
    public abstract int getSize();
    
    public abstract boolean addVertex(MazeVertex vertex);
    
    public abstract boolean addVertexAt(int index, MazeVertex vertex);
    
    public abstract boolean addDirection(Directions direction);
    
    public abstract boolean addDirectionAt(int index, Directions direction);
    
    public abstract boolean removeVertexAt(int index);
    
    public abstract boolean removeDirectionAt(int index);
    
    public abstract MazeVertex getVertexAt(int index);
    
    public abstract Directions getDirectionAt(int index);
    
    public abstract boolean setVertexAt(int index, MazeVertex vertex);
    
    public abstract boolean setDirectionAt(int index, Directions direction);
    

}
