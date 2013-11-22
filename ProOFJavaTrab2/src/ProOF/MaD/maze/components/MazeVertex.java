/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze.components;

import java.awt.geom.Point2D.Double;

/**
 *
 * @author lucasaoki
 */
public class MazeVertex {

    private String id;
    private int index;
    private Double location;

    public MazeVertex(String id, double x, double y) {

        this.id = id;
        index = Integer.parseInt(id);
        location = new Double(x, y);
    }

    public MazeVertex(String id, Double pos) {

        this.id = id;
        index = Integer.parseInt(id);
        location = pos;
    }

    void setPosition(int x, int y) {

        location.setLocation(x, y);
    }

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public Double getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }

    public void showVert() {
        System.out.println("v" + id + " [" + location.x + "," + location.y + "]");
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
