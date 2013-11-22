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
import ProOF.opt.abst.problem.meta.codification.Codification;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ito
 */
public class iCrossoverDefault extends aCrossover {

    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {

        if (mem.isUsingVertex()) {
            HashMap<MazeVertex, Integer> vertex = new HashMap<>();
            ArrayList<Integer> vind1Index = new ArrayList<>();
            ArrayList<Integer> vind2Index = new ArrayList<>();

            MazeSolution mazeSol = ind1.getMazeSol();

            for (int c = 0; c < mazeSol.getSize(); c++) {
                vertex.put(mazeSol.getVertexAt(c), c);
            }
            mazeSol = ind2.getMazeSol();

            for (int c = 0; c < mazeSol.getSize(); c++) {
                if (vertex.containsKey(mazeSol.getVertexAt(c))) {
                    vind1Index.add(vertex.get(mazeSol.getVertexAt(c)));
                    vind2Index.add(c);
                }
            }

        }

        return (iCodification) mem.NewCodification();
    }

    @Override
    public String name() {
        return "DefaultCrossover";
    }

}
