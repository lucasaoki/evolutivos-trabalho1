/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaD.maze.components;

import java.awt.geom.Point2D.Double;

/**
 *
 * @author lucasaoki
 */
public class MazeVertex {

    private String id;
    private Double position;

    public MazeVertex(String id, int x, int y) {

        this.id = id;
        position = new Double(x, y);
    }

    public MazeVertex(String id, Double pos) {

        this.id = id;
        position = pos;
    }

    void setPosition(int x, int y) {

        position.setLocation(x, y);
    }

    public double getPosX() {
        return position.getX();
    }

    public double getPosY() {
        return position.getY();
    }

    public void showVert() {
        System.out.println("v" + id + " [" + position.x + "," + position.y + "]");
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MazeVertex)) {
            return false;
        }

        MazeVertex vertex = (MazeVertex) obj;
        return id.equals(vertex.id);
    }
}
