/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MaD.maze;

import MaD.maze.components.MazeVertex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ito
 */
public class MazeSolution {
    private List<MazeVertex> vertexList;
    
    
    private MazeVertex startVertex;
    
    private MazeVertex endVertex;

    public MazeSolution(MazeVertex startVertex, MazeVertex endVertex) {
        this.vertexList = new ArrayList<>();
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public MazeVertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(MazeVertex startVertex) {
        this.startVertex = startVertex;
    }

    public MazeVertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(MazeVertex endVertex) {
        this.endVertex = endVertex;
    }

    public List<MazeVertex> getVertexList() {
        return vertexList;
    }

    
    
 
    
    
    
    
    
}
