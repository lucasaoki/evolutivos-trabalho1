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
	Solution<iProblem, iObjective, iCodification, Solution> s;
	for (int c = 0; c < population_size; c++) {
	    s = problemNode.NewSolution();
	    initializerOperatorNode.initialize(problemNode, s.codif());
	    problemNode.evaluate(s);
	    //TODO: FIRST EVALUATION?
	}
	System.out.printf("INITIALIZATED\n");
    }

    @Override
    public void iterate() throws Exception {
	System.out.printf("ITERATING\n");
	Solution<iProblem, iObjective, iCodification, Solution> s;
	s = problemNode.NewSolution();
	initializerOperatorNode.initialize(problemNode, s.codif());
	problemNode.evaluate(s);
    }

    @Override
    public void results(LinkerResults link) throws Exception {
	System.out.printf("iGA results\n");
    }
}
