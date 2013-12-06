/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods.GA.algorithm;

import PrintImage.Windows;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerResults;
import ProOF.opt.abst.problem.meta.Solution;
import ProOF.utils.GlobalConstants;
import java.util.List;

/**
 *
 * @author ito
 */
public class iGADefault extends aGA {

    Windows[] w;
    int resetcount;

    @Override
    public String name() {
        return "GAAlgorithm Default";
    }

    @Override
    public String description() {
        return "GAAlgorithm Base description";
    }

    @Override
    public void initialize() throws Exception {
        populationList.addAll(generate(population_size));

        resetcount = 0;
//
        w = new Windows[population_size + 1];
        
        int size = 400;

        for (int c = 0; c < w.length - 1; c++) {
            w[c] = new Windows("ind " + Integer.toString(c), size, size, populationList.get(0).codif().getMaze().getMaze() ,GlobalConstants.mapadir);
        }

        w[w.length - 1] = new Windows("crossover ", size, size, populationList.get(0).codif().getMaze().getMaze(), GlobalConstants.mapadir);
        System.out.printf("INITIALIZATED\n");
    }

    @Override
    public void iterate() throws Exception {
        //System.out.printf("ITERATING\n");

        evaluate();
        if (stopNode.end()) {
            return;
        }
        
         List lold = sublistClone(populationList, 0, (int) Math.round(population_size * selectionRate));


        populationList.clear();

        populationList.addAll(lold);
        
        int popToCross =  population_size - populationList.size();
        
//        for (int c = 0; c < popToCross; c++) {
//            Solution<iProblem, iObjective, iCodification, Solution> child = cross.runCross(populationList.get(c), populationList.get(c+1));
//
//            if (child != null) {
//                populationList.add(child);
//            }
//        }
        
//        Thread.sleep(1000);
        for (int c = 0; c < populationList.size(); c++) {
            mutation.runMutation(populationList.get(c));
//          w[c].setSolution(populationList.get(c).codif().getMazeSol());
        }
    }

    @Override
    public void results(LinkerResults link) throws Exception {
        System.out.printf("iGA results\n");
    }
}
