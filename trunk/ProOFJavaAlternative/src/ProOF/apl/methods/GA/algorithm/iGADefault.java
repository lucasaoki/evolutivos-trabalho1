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
	//System.out.printf("ITERATING\n");

	evaluate();

	List lold = sublistClone(populationList, 0, Math.round(population_size * 0.4f));
	List lnew = generate(Math.round(population_size * 0.1f));
	populationList.clear();

//	System.out.println("AfterClean  Pop size: " + Integer.toString(populationList.size()));

	populationList.addAll(lold);
//	System.out.println("AfterAddOld  Pop size: " + Integer.toString(populationList.size()));
	populationList.addAll(lnew);
//	System.out.println("AfterAddNew  Pop size: " + Integer.toString(populationList.size()));


	double limitCount = populationList.size() / 2f;
	for (int c = 0; c < limitCount; c++) {
	    Solution<iProblem, iObjective, iCodification, Solution> child = cross.runCross(populationList.get(c * 2), populationList.get(c * 2 + 1));

	    populationList.add(child);

//	    System.out.print(Integer.toString(c) + " ");
	}
//	System.out.println("End Conting: ");
//	System.out.println("AfterCrossover  Pop size: " + Integer.toString(populationList.size()));

	populationList.addAll(generate(population_size - populationList.size()));

//	System.out.println("AfterCompleting Pop size: " + Integer.toString(populationList.size()));

	for (int c = 0; c < populationList.size(); c++) {
	    mutation.runMutation(populationList.get(c));
	}

	//for (int c = 0;)

    }

    @Override
    public void results(LinkerResults link) throws Exception {
	System.out.printf("iGA results\n");
    }
}
