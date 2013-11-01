/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaD.maze.components;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 *
 * @author lucasaoki
 */
public class MazeEdge extends DefaultWeightedEdge {

    private String id;

    public MazeEdge(String id) {
        this.id = id;
    }

//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (!(obj instanceof MazeEdge)) {
//            return false;
//        }
//
//        MazeEdge edge = (MazeEdge) obj;
//        return id.equals(edge.id);
//    }
}
