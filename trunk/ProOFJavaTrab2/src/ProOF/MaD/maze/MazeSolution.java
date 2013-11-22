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

    public MazeSolution() {
        solutionLimitSize = 10000;
    }

    public int getSolutionLimitSize() {
        return solutionLimitSize;
    }

    public void setSolutionLimitSize(int solutionLimitSize) {
        this.solutionLimitSize = solutionLimitSize;
    }
    
    
    
    
    
    public abstract int getSize();
    
    public abstract boolean addVertex(MazeVertex vertex);
    
    public abstract boolean addDirection(Directions direction);
    
    public abstract MazeVertex getVertexAt(int index);
    
    public abstract Directions getDirectionAt(int index);
    
    public abstract boolean setVertexAt(int index, MazeVertex vertex);
    
    public abstract boolean setDirectionAt(int index, Directions direction);
    

}