/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.apl.problems.iCodification;

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
        
        maze = new Maze("media/Graph.txt");	
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        
        double sum = 0;
        MazeSolution sol = codif.getMazeSol();
        
        sum+= maze.getdistance( maze.getVertexFromIndex(startVertexIndex),  sol.getVertexAt(c));
        
        for (int c= 0 ;c < codif.getMazeSol().getSize()- 1; c++)
        {
            sum+= maze.getdistance( sol.getVertexAt(c), sol.getVertexAt(c+1));
        }
        
        if (sol.getVertexAt(sol.getSize() - 1).getId() != endVertexIndex){
            sol.setSolutionFound(false);
            sum+=1000;
        }
        
        return sum;

    }
}
