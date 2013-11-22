/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import ProOF.MaD.maze.Maze;
import ProOF.apl.problems.iCodification;
import java.io.File;

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
    public String description() {
	return "Maze information";
    }

    public iMaze1() {

	super(new Maze(new File(".").getAbsolutePath()));
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        return 0;
	
        
        //calculate dist from codif.ind
    }
}
