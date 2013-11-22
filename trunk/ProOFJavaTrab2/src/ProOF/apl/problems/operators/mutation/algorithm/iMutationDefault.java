/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.MaD.maze.Maze;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.MazeSolutionVertex;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.apl.problems.maze.aMaze;

/**
 *
 * @author ito
 */
public class iMutationDefault extends aMutation{

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
    	MazeSolution mazeSol = ind.getMazeSol();
        aMaze amaze = ind.getMaze();
        Maze maze = amaze.getMaze();
        Random rand = new Random();
        int index;
        
        if (mem.isUsingVertex()){
        	index = rand.nextInt(mazeSol.getSize());
            MazeVertex vinit = mazeSol.getVertexAt(index);
            
            MazeSolutionVertex shortcut = new MazeSolutionVertex(maze, mazeSol.getSolutionLimitSize());
            
            for (int i = 0; i < index+1; i++) {
				shortcut.addVertex(mazeSol.getVertexAt(i));
			}
                  
            List<MazeVertex> conectedVertices = maze.getConnectedVertices(vinit);
            index = -1;
            do
            {
                Collections.shuffle(conectedVertices);
                vinit = conectedVertices.get(0);
                shortcut.addVertex(vinit);
                conectedVertices =  maze.getConnectedVertices( conectedVertices.get(0));
                
                for (int i = 0; i < mazeSol.getSize(); i++) {
					if( mazeSol.getVertexAt(i).equals(vinit) ){
						index = i;
						break;
					}
				}
                
            
            }while (index == -1);
            
            for (int i = index+1; i < mazeSol.getSolutionLimitSize(); i++) {
				if(!shortcut.addVertex(mazeSol.getVertexAt(i))){
					break;
				}
			}
            
            mazeSol.removeRange(0, mazeSol.getSize()-1);
            for (int i = 0; i < shortcut.getSize(); i++) {
				mazeSol.addVertex(shortcut.getVertexAt(i));
			}
           
            
        }
        else
        {
            
        }
    }

    @Override
    public String name() {
       return "Shortcut Mutation";
    }
    
}