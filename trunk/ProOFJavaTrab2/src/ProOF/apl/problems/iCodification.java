/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import MaD.maze.Maze;
import MaD.maze.MazeSolution;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author ito
 */
public class iCodification extends Codification<iProblem,iCodification> {
    
    private final Maze maze;
    private final MazeSolution mazeSol;
    
    public iCodification(Maze maze) throws Exception {
        this.maze = maze;
        mazeSol = new MazeSolution();
    }
    
    public MazeSolution MazeIndividual()
    {
        return mazeSol;
    }


    @Override
    public iCodification New(iProblem prob) throws Exception {
	return new iCodification(maze);
    }

    @Override
    public void Copy(iProblem prob, iCodification source) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
