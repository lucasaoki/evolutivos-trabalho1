/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods.GA.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerResults;
import ProOF.opt.abst.problem.meta.Solution;
import java.util.List;

/**
 *
 * @author ito
 */
public class iGADefault extends aGA {

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

	System.out.printf("INITIALIZATED\n");
    }

    @Override
    public void iterate() throws Exception {
	System.out.printf("ITERATING\n");

	evaluate();

	List lold = sublistClone(populationList, 0, Math.round(population_size * 0.4f));
	List lnew = generate(Math.round(population_size * 0.1f));
	populationList.clear();
	populationList.addAll(lold);
	populationList.addAll(lnew);

	for (int c = 1; c < populationList.size(); c += 2) {
	    Solution<iProblem, iObjective, iCodification, Solution> child = cross.runCross(populationList.get(c - 1), populationList.get(c));

	    // populationList.addAll(generate(1));
	    populationList.add(child);
	}

	populationList.addAll(generate(population_size - populationList.size()));
        
        for (int c = 0; c < populationList.size(); c++) {
            mutation.runMutation(populationList.get(c));
        }

    }

    @Override
    public void results(LinkerResults link) throws Exception {
	System.out.printf("iGA results\n");
    }
}
