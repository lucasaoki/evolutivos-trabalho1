/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.opt.abst.problem.meta.Solution;

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
    public Solution<iProblem, iObjective, iCodification, Solution> runCross(Solution<iProblem, iObjective, iCodification, Solution> s1, Solution<iProblem, iObjective, iCodification, Solution> s2) {
	return s1;
    }
}
