/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover.algorithm;

import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ito
 */
public class iCrossoverDefault extends aCrossover {

    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {

        MazeSolution mazeSol1 = ind1.getMazeSol();
        MazeSolution mazeSol2 = ind2.getMazeSol();

        if (mem.isUsingVertex()) {
            HashMap<MazeVertex, Integer> vertex = new HashMap<>();
            ArrayList<Integer> vind1Index = new ArrayList<>();
            ArrayList<Integer> vind2Index = new ArrayList<>();

            for (int c = 0; c < mazeSol1.getSize(); c++) {
                vertex.put(mazeSol1.getVertexAt(c), c);
            }

            for (int c = 0; c < mazeSol2.getSize(); c++) {
                if (vertex.containsKey(mazeSol2.getVertexAt(c))) {
                    vind1Index.add(vertex.get(mazeSol2.getVertexAt(c)));
                    vind2Index.add(c);
                }
            }

            boolean retExist = false;

            //verifica se tem algum em comum
            if (vind1Index.isEmpty()) {
                retExist = true;
            } else {
                iCodification newInd = (iCodification) mem.NewCodification();
                MazeSolution newMazeSol = newInd.getMazeSol();
                if (vind1Index.size() == 1) {
                    System.out.println("NOVO INDIVIDUO unico ponto!!!");
                    System.out.println("index " + vind2Index.get(0));
                    if (newMazeSol.addVertexRange(mazeSol2.getVertexRange(0, vind2Index.get(0)))
                            && newMazeSol.addVertexRange(mazeSol1.getVertexRange(vind1Index.get(0) + 1, mazeSol1.getSize() - 1))) {
                        return newInd;
                    } else {
                        retExist = true;
                    }
                } else {
                    //se nao escolhe um intervalo

                    int n1, n2;

                    n1 = mem.rmd.nextInt(vind2Index.size());

                    do {
                        n2 = mem.rmd.nextInt(vind2Index.size());
                    } while (n1 == n2);

                    if (n2 < n1) {
                        int tmp = n1;
                        n1 = n2;
                        n2 = tmp;
                    }
                    
//                    int v1n1 = vind1Index.get(n1);
//                    int v1n2 = vind1Index.get(n2);
//                    int v2n1 = vind2Index.get(n1);
//                    int v2n2 = vind2Index.get(n2);

                    if (newMazeSol.addVertexRange(mazeSol2.getVertexRange(0, vind2Index.get(n1)-1))) {
                        System.out.println("index ind2 corte " + Integer.toString( vind2Index.get(n1) - 1));
                        if (newMazeSol.addVertexRange(mazeSol1.getVertexRange(vind1Index.get(n1) , vind1Index.get(n2)))) {
                            System.out.println("index ind1 inicio " + vind1Index.get(n1));
                            System.out.println("index ind1 fim " + vind1Index.get(n2));
                            if (newMazeSol.addVertexRange(mazeSol2.getVertexRange(vind2Index.get(n2) + 1, mazeSol2.getSize() - 1))) {

                                System.out.println("index ind2 retorno " + Integer.toString( vind2Index.get(n2) + 1));

                                return newInd;
                            }
                        }
                    }

                    retExist = true;
                }
            }

            if (retExist) {
                if (mazeSol1.getTotalDistance()
                        > mazeSol2.getTotalDistance()) {
                    return ind2;
                } else {
                    return ind1;
                }
            }

            //should never goes here
            return null;
        } else {
            //not using vertex
            if (mazeSol1.getTotalDistance()
                    > mazeSol2.getTotalDistance()) {
                return ind2;
            } else {
                return ind1;
            }
        }
    }

    @Override
    public String name() {
        return "DefaultCrossover";
    }

}
