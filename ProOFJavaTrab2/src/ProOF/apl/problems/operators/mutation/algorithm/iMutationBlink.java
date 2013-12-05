/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.apl.problems.operators.mutation.algorithm;

import java.util.ArrayList;

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.apl.problems.maze.aMaze;

/**
 *
 * @author ito
 */
public class iMutationBlink extends aMutation{

	@Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
		MazeSolution mazeSol = ind.getMazeSol();
        aMaze amaze = ind.getMaze();
        Maze maze = amaze.getMaze();
        boolean bcorr = true;
		
        int index1 = 0;
        
        Integer num;
        
        ArrayList<Integer> freq = new ArrayList<Integer>(maze.getVertices().size());
        
		if(mem.isUsingVertex()){
			
			for (int i = 0; i < maze.getVertices().size(); i++) {
				freq.set(mazeSol.getVertexAt(i).getIndex(), freq.get(mazeSol.getVertexAt(i).getIndex())+1);
			}
			
			if(bcorr == true){
				num = -1;
			} else {
				num = 999999999;
			}
			
			for (int i = 0; i < freq.size(); i++) {
				if(bcorr == true){
					if( freq.get(i) > num ){
						index1 = i;
						num = freq.get(i);
					}
				} else {
					if( freq.get(i) < num && freq.get(i) > 1){
						index1 = i;
						num = freq.get(i);
					}
				}
			}
			
			int first = -1;
			int last = -1;
			for (int i = 0; i < mazeSol.getSize(); i++) {
				if( num > 1 ){
					if(mazeSol.getVertexAt(i).getIndex() == index1){
						num--;
						if( first == -1){
							first = i;
						}
					}
				} else {
					if(mazeSol.getVertexAt(i).getIndex() == index1){
						last = i;
					}
				}
			}
			
			mazeSol.removeRange(first+1, last);
			
		} else {
			//TODO Blink Mutation Directions
		}
    }

    @Override
    public String name() {
    	return "Blink Mutation";
    }
    
}