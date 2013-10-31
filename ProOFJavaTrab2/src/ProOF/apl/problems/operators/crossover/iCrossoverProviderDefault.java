/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.opt.abst.problem.meta.Solution;
import java.util.Random;

/**
 *
 * @author ito
 */
public class iCrossoverProviderDefault extends aCrossoverProvider {

    @Override
    public String name() {
	return "Default iCrossoverProvider";
    }

    @Override
    public String description() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Solution<iProblem, iObjective, iCodification, Solution> runCross(Solution<iProblem, iObjective, iCodification, Solution> s1, Solution<iProblem, iObjective, iCodification, Solution> s2) throws Exception {
	Random rnd = new Random(System.currentTimeMillis());
	iCodification crossover;
	if (Math.random() <= crossoverRate) {
	    if (crossoverList.length != 0) {
		crossover = crossoverList[rnd.nextInt(crossoverList.length)].crossover(problemNode, s1.codif(), s2.codif());
	    } else {
		System.out.println("Critical Error: Empty Mutation List.");
		return s1;
	    }
	    return problemNode.NewSolution(crossover);
	} else {
	    return null;
	}

    }
}
