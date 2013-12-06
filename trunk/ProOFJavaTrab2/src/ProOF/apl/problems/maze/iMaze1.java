/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.components.MazeEdge;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ito
 */
public final class iMaze1 extends aMaze {

    @Override
    public String name() {
        return "Maze function1";
    }

    @Override
    public void load() throws Exception {
        super.load();
    }

    @Override
    public String description() {
        return "Maze information";
    }

    public iMaze1() {
        super();
        maze = new Maze("../../../media/Graph.txt");

    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {

        return _evaluate(codif.getMazeSol());
    }

}
