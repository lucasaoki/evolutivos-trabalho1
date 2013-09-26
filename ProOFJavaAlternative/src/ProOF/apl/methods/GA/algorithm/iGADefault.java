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
	if (stopNode.end()) {
	    return;
	}

	List lold = sublistClone(populationList, 0, (int) Math.round(population_size * selectionRate));
	List lnew = generate((int) Math.round(population_size * newPopForCrossover));
	populationList.clear();

//	System.out.println("AfterClean  Pop size: " + Integer.toString(populationList.size()));

	populationList.addAll(lold);
//	System.out.println("AfterAddOld  Pop size: " + Integer.toString(populationList.size()));
	populationList.addAll(lnew);
//	System.out.println("AfterAddNew  Pop size: " + Integer.toString(populationList.size()));

	//Collections.shuffle(populationList);

	double limitCount = populationList.size() / 2f;
//	for (int c = 0; c < limitCount; c++) {
//	    Solution<iProblem, iObjective, iCodification, Solution> child = cross.runCross(populationList.get(c), populationList.get(populationList.size() - 1 - c));
//
//	    populationList.add(child);
//
////	    System.out.print(Integer.toString(c) + " ");
//	}
	for (int c = 0; c < limitCount; c++) {
	    Solution<iProblem, iObjective, iCodification, Solution> child = cross.runCross(populationList.get(c * 2), populationList.get(c * 2 + 1));

	    populationList.add(child);

//	    System.out.print(Integer.toString(c) + " ");
	}
//	System.out.println("End Conting: ");
//	System.out.println("AfterCrossover  Pop size: " + Integer.toString(populationList.size()));
//	System.out.println("AfterCompleting Pop size: " + Integer.toString(populationList.size()));

	for (int c = 0; c < populationList.size(); c++) {
	    mutation.runMutation(populationList.get(c));
	}

	//selection();

	populationList.addAll(generate(population_size - populationList.size()));

	//for (int c = 0;)

    }

    @Override
    public void results(LinkerResults link) throws Exception {
	System.out.printf("iGA results\n");
    }
}
