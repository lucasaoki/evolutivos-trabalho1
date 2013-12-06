/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.MazeSolutionVertex;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.apl.problems.maze.aMaze;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ito
 */
public class iMutationShortcut extends aMutation {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {

        MazeSolution mazeSol = ind.getMazeSol();
        aMaze amaze = ind.getMaze();
        Maze maze = amaze.getMaze();

        if (mem.isUsingVertex()) {

            MazeSolutionVertex shortcut = new MazeSolutionVertex(maze, mazeSol.getSolutionLimitSize());
            ArrayList<Integer> indexes = new ArrayList<>();
            HashMap<MazeVertex, Integer> vertexHash = new HashMap<>();
            
            if (mazeSol.isSolutionFound()) {

                for (int c = 0; c < mazeSol.getSize(); c++) {
                    indexes.add(c);
                    vertexHash.put(mazeSol.getVertexAt(c), c);
                }
                Collections.shuffle(indexes);

            } else {
                indexes.add(mazeSol.getSize() - 1);
            }

            int startIndex;
            int endIndex;
            while (indexes.size() > 0) {

                Integer index = indexes.get(0);
                indexes.remove(indexes.get(0));

                MazeVertex vex = maze.getVertexFromIndex(index);
                List<MazeVertex> connectedVertices = maze.getConnectedVertices(vex);

                if (index == 0) {
                    connectedVertices.remove(maze.getStartVert());
                } else {
                    connectedVertices.remove(maze.getVertexFromIndex(index - 1));
                }

                if (index != mazeSol.getSize() - 1) {
                    connectedVertices.remove(maze.getVertexFromIndex(index + 1));
                }

                if (connectedVertices.isEmpty()) {
                    continue;
                }
                MazeVertex vnew = connectedVertices.get(mem.rmd.nextInt(connectedVertices.size()));
                startIndex = index;
                
                do
                {
                    shortcut.addVertex(vnew);
                    connectedVertices = maze.getConnectedVertices(vnew);
                    connectedVertices.remove(vnew);
                    
                    vex = vnew;
                    
                    if (connectedVertices.isEmpty())
                        break;
                    
                    vnew = connectedVertices.get(mem.rmd.nextInt(connectedVertices.size()));
                    
                }while (mazeSol.getSolutionLimitSize() - mazeSol.getSize() > shortcut.getSize() && vex.getIndex() != maze.getEndVert().getIndex() && !vertexHash.containsKey(vex));
                
                if (vertexHash.containsKey(vex))
                    endIndex = vertexHash.get(vex);
                else
                    endIndex = mazeSol.getSize() -1;
                
                mazeSol.removeRange(startIndex + 1, endIndex);
                
                mazeSol.addVertexRangeAt(startIndex + 1, shortcut.getVertexRange(0, shortcut.getSize() -1));
                break;
            }

        } else {

        }

        return;

//        int index;
//        int maxShortcut = mazeSol.getSolutionLimitSize();
//
//        if (mem.isUsingVertex()) {
//
//            index = mem.rmd.nextInt(mazeSol.getSize());
//            MazeVertex vinit = mazeSol.getVertexAt(index);
//
//            for (int i = 0; i < index + 1; i++) {
//                shortcut.addVertex(mazeSol.getVertexAt(i));
//            }
//
//            List<MazeVertex> connectedVertices = maze.getConnectedVertices(vinit);
//            index = -1;
//            do {
//                Collections.shuffle(connectedVertices);
//                vinit = connectedVertices.get(0);
//                shortcut.addVertex(vinit);
//                connectedVertices = maze.getConnectedVertices(vinit);
//
//                for (int i = 0; i < mazeSol.getSize(); i++) {
//                    if (mazeSol.getVertexAt(i).equals(vinit)) {
//                        index = i;
//                        break;
//                    }
//                }
//
//            } while (index == -1 || shortcut.getSize() >= maxShortcut);
//
//            if (index != -1) {
//                for (int i = index + 1; i < mazeSol.getSize(); i++) {
//                    if (!shortcut.addVertex(mazeSol.getVertexAt(i))) {
//                        break;
//                    }
//                }
//            }
//
//            mazeSol.removeRange(0, mazeSol.getSize() - 1);
//            for (int i = 0; i < shortcut.getSize(); i++) {
//                mazeSol.addVertex(shortcut.getVertexAt(i));
//            }
//
//        } else {
//            //TODO shortcut
//        }
    }

    @Override
    public String name() {
        return "Shortcut Mutation";
    }

}
