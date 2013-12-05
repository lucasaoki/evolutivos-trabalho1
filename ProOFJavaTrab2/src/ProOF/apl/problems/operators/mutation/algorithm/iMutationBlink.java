/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;

/**
 *
 * @author ito
 */
public class iMutationBlink extends aMutation{

	@Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
		MazeSolution mazeSol = ind.getMazeSol();
        //aMaze amaze = ind.getMaze();
        //Maze maze = amaze.getMaze();
		MazeVertex vtx1;
        
        int index1 = 0, index2 = 0;
        
		if(mem.isUsingVertex()){
			
			while(index1 < mazeSol.getSize()){
				vtx1 = mazeSol.getVertexAt(index1);
				index2 = index1 + 1;
				while(index2 != -1 && index2 < mazeSol.getSize()){
					if(vtx1.equals(mazeSol.getVertexAt(index2)) == true){
						mazeSol.removeRange(index1+1, index2);
						index2 = -1;
					}
				}
				index1++;
			}
			
		} else {
			//TODO Blink Mutation Directions
		}
    }

    @Override
    public String name() {
    	return "Blink Mutation";
    }
    
}
