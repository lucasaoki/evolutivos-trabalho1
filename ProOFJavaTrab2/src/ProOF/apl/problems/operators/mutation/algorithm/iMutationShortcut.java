/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import ProOF.MaD.maze.Directions;
import ProOF.MaD.maze.Maze;
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

                MazeVertex vex = mazeSol.getVertexAt(index);
                List<MazeVertex> connectedVertices = maze.getConnectedVertices(vex);

                if (index == 0) {
                    connectedVertices.remove(maze.getStartVert());
                } else {
                    connectedVertices.remove(mazeSol.getVertexAt(index - 1));
                }

                if (index != mazeSol.getSize() - 1) {
                    connectedVertices.remove(mazeSol.getVertexAt(index + 1));
                }

                if (connectedVertices.isEmpty()) {
                    continue;
                }
                MazeVertex vnew = connectedVertices.get(mem.rmd.nextInt(connectedVertices.size()));
                startIndex = index;

                do {
                    shortcut.addVertex(vnew);
                    connectedVertices = maze.getConnectedVertices(vnew);
                    connectedVertices.remove(vnew);

                    vex = vnew;

                    if (connectedVertices.isEmpty()) {
                        break;
                    }

                    vnew = connectedVertices.get(mem.rmd.nextInt(connectedVertices.size()));

                } while (mazeSol.getSolutionLimitSize() - mazeSol.getSize() > shortcut.getSize() && vex.getIndex() != maze.getEndVert().getIndex() && !vertexHash.containsKey(vex));

                if (vertexHash.containsKey(vex)) {
                    endIndex = vertexHash.get(vex);
                } else {
                    endIndex = mazeSol.getSize() - 1;
                }

                if (startIndex <= endIndex) {
                    break;
                }

                startIndex++;

                if (startIndex >= mazeSol.getSize()) {
                    mazeSol.addVertexRange(shortcut.getVertexRange(0, shortcut.getSize() - 1));
                } else {
                     if (!mazeSol.addVertexRangeAt(startIndex, shortcut.getVertexRange(0, shortcut.getSize() - 1))) {
                        System.out.println("erro ao adicionar range");
                    }
                     else
                     {
                         mazeSol.removeRange(startIndex+shortcut.getSize(), endIndex+shortcut.getSize());
                     }
                    
                   
                }

                break;
            }

//            MazeSolutionVertex shortcut = new MazeSolutionVertex(maze, mazeSol.getSolutionLimitSize());
//            ArrayList<Integer> indexes = new ArrayList<>();
//            HashMap<MazeVertex, Integer> vertexHash = new HashMap<>();
//            
//            if (mazeSol.isSolutionFound()) {
//
//                for (int c = 0; c < mazeSol.getSize(); c++) {
//                    indexes.add(c);
//                    vertexHash.put(mazeSol.getVertexAt(c), c);
//                }
//                Collections.shuffle(indexes);
//
//            } else {
//                indexes.add(mazeSol.getSize() - 1);
//            }
//
//            int startIndex;
//            int endIndex;
//            while (indexes.size() > 0) {
//
//                Integer index = indexes.get(0);
//                indexes.remove(indexes.get(0));
//
//                MazeVertex vex = maze.getVertexFromIndex(index);
//                List<MazeVertex> connectedVertices = maze.getConnectedVertices(vex);
//
//                if (index == 0) {
//                    connectedVertices.remove(maze.getStartVert());
//                } else {
//                    connectedVertices.remove(maze.getVertexFromIndex(index - 1));
//                }
//
//                if (index != mazeSol.getSize() - 1) {
//                    connectedVertices.remove(maze.getVertexFromIndex(index + 1));
//                }
//
//                if (connectedVertices.isEmpty()) {
//                    continue;
//                }
//                MazeVertex vnew = connectedVertices.get(mem.rmd.nextInt(connectedVertices.size()));
//                startIndex = index;
//                
//                do
//                {
//                    shortcut.addVertex(vnew);
//                    connectedVertices = maze.getConnectedVertices(vnew);
//                    connectedVertices.remove(vnew);
//                    
//                    vex = vnew;
//                    
//                    if (connectedVertices.isEmpty())
//                        break;
//                    
//                    vnew = connectedVertices.get(mem.rmd.nextInt(connectedVertices.size()));
//                    
//                }while (mazeSol.getSolutionLimitSize() - mazeSol.getSize() > shortcut.getSize() && vex.getIndex() != maze.getEndVert().getIndex() && !vertexHash.containsKey(vex));
//                
//                if (vertexHash.containsKey(vex))
//                    endIndex = vertexHash.get(vex);
//                else
//                    endIndex = mazeSol.getSize() -1;
//                
//                mazeSol.removeRange(startIndex + 1, endIndex);
//                
//                mazeSol.addVertexRangeAt(startIndex + 1, shortcut.getVertexRange(0, shortcut.getSize() -1));
//                break;
//            }
        } else {

            int changeChance = 6;
            int includeChance = 3;
            int index;

            for (int i = 0; i < mazeSol.getSize(); i++) {
                index = mem.rmd.nextInt(10);
                if (index < changeChance) {
                    index = mem.rmd.nextInt(4);
                    switch (index) {
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
                index = mem.rmd.nextInt(10);
                if (index < includeChance) {
                    index = mem.rmd.nextInt(4);
                    switch (index) {
                        case 0:
                            mazeSol.addDirectionAt(i, Directions.RIGHT);
                            break;
                        case 1:
                            mazeSol.addDirectionAt(i, Directions.LEFT);
                            break;
                        case 2:
                            mazeSol.addDirectionAt(i, Directions.FORWARD);
                            break;
                        case 3:
                            mazeSol.addDirectionAt(i, Directions.BACKWARD);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    @Override
    public String name() {
        return "Shortcut Mutation";
    }

}
