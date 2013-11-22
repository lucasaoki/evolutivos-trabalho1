/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeVertex;
import java.util.ArrayList;

/**
 *
 * @author ito
 */
public class MazeSolutionVertex extends MazeSolution{

    ArrayList<MazeVertex> mazeVertex;

    public MazeSolutionVertex(int solutionLimitSize) {
        super(solutionLimitSize);
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
            return true;
        }
    }

    @Override
    public boolean addDirection(Directions direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setVertexAt(int index, MazeVertex vertex) {
       if (index >= 0 && index < mazeVertex.size())
       {
          mazeVertex.set(index, vertex);
       
           return true;
       }
       else
           return false;
    }

    @Override
    public boolean setDirectionAt(int index, Directions direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
}
