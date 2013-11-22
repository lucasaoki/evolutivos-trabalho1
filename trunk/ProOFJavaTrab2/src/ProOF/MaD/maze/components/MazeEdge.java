/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze.components;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 *
 * @author lucasaoki
 */
public class MazeEdge extends DefaultWeightedEdge {

    private String id;
    private final MazeVertex v1;
    private final MazeVertex v2;

    public MazeEdge(String id, MazeVertex v1, MazeVertex v2) {
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
    }

    public double calcEdgeWeight() {
        double wgt = 0;

        wgt = Math.sqrt((Math.pow(v1.getX() + v2.getX(), 2)) + Math.pow(v1.getY() + v2.getY(), 2));

        return wgt;
    }

    public MazeVertex getV1() {
        return v1;
    }

    public MazeVertex getV2() {
        return v2;
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
