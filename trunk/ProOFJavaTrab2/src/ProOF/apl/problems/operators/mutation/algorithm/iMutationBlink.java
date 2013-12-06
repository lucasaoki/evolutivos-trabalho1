/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.apl.problems.operators.mutation.algorithm;

import java.util.ArrayList;

import ProOF.MaD.maze.Directions;
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
        for (int c = 0; c < maze.getVertices().size();c ++)
            freq.add(0);
        
		if(mem.isUsingVertex()){
			
			for (int i = 0; i < mazeSol.getSize(); i++) {
				freq.set(mazeSol.getVertexAt(i).getIndex(), freq.get(mazeSol.getVertexAt(i).getIndex())+1);
			}
			
			if(bcorr == true){
				num = -1;
			} else {
				num = 999999999;
			}
			
			for (int i = 0; i < freq.size(); i++) {
				if(bcorr == true){
					if( freq.get(i) > num && freq.get(i) > 1){
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
			if( first != -1 && last != -1){
				mazeSol.removeRange(first+1, last);
			}
		
		} else {
			int changeChance = 6;
        	int excludeChance = 3;
        	
        	
        	for (int i = 0; i < mazeSol.getSize(); i++) {
				index1 = mem.rmd.nextInt(10);
				if( index1 < excludeChance ){
					mazeSol.removeAt(i);
				} else {
					index1 = mem.rmd.nextInt(10);
					if(index1 < changeChance ){
						index1 = mem.rmd.nextInt(4);
						switch (index1) {
						case 0:
							mazeSol.setDirectionAt(i, Directions.RIGHT);
							break;
						case 1:
							mazeSol.setDirectionAt(i, Directions.LEFT);
							break;
						case 2:
							mazeSol.setDirectionAt(i, Directions.FORWARD);
							break;
						case 3:
							mazeSol.setDirectionAt(i, Directions.BACKWARD);
							break;
						default:
							break;
						}
					}
				}
			}
		}
    }

    @Override
    public String name() {
    	return "Blink Mutation";
    }
    
}
