/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaD.maze.components;

/**
 *
 * @author lucasaoki
 */
public class MazeVertex {

    private String id;
    private int _posX;
    private int _posY;

    public MazeVertex(String id, int posX, int posY) {

        this.id = id;
        this._posX = posX;
        this._posY = posY;
    }

    void setPosition(int x, int y) {

        this._posX = x;
        this._posY = y;
    }

    public int getPosX() {
        return _posX;
    }

    public int getPosY() {
        return _posY;
    }

    public void showVert() {
        System.out.println("v" + id + " [" + _posX + "," + _posY + "]");
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
//        if (!(obj instanceof MazeVertex)) {
//            return false;
//        }
//
//        MazeVertex vertex = (MazeVertex) obj;
//        return id.equals(vertex.id);
//    }
}
