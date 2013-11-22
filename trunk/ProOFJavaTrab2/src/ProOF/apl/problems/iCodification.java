/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import MaD.maze.MazeSolution;
import MaD.maze.MazeSolutionDirection;
import MaD.maze.MazeSolutionVertex;
import ProOF.apl.problems.maze.aMaze;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author ito
 */
public class iCodification extends Codification<iProblem,iCodification> {
    
    private final aMaze maze;
    private final MazeSolution mazeSol;
    private final boolean useVertex;
    
    public iCodification(boolean useVertex, aMaze maze) throws Exception {
        this.maze = maze;
        
        this.useVertex = useVertex;
        
        if (useVertex)
            mazeSol = new MazeSolutionVertex();
        else
            mazeSol = new MazeSolutionDirection();
        
    }

    public aMaze getMaze() {
        return maze;
    }

    public MazeSolution getMazeSol() {
        return mazeSol;
    }

    public boolean useVertex() {
        return useVertex;
    }
    
    
    
    @Override
    public iCodification New(iProblem prob) throws Exception {
	return new iCodification(useVertex,maze);
    }

    @Override
    public void Copy(iProblem prob, iCodification source) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
