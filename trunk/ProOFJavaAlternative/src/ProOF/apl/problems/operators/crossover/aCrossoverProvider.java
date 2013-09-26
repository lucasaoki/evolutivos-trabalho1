/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.language.Node;
import ProOF.gen.operator.oCrossover;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.Solution;
import ProOF.utils.GlobalConstants;

/**
 *
 * @author ito
 */
public abstract class aCrossoverProvider extends Node {

    protected iProblem problemNode;
    protected oCrossover<iProblem, iCodification>[] crossoverList;
    protected double crossoverRate;

    public oCrossover<iProblem, iCodification> getCross(int index) {
	if (index >= 0 && index < crossoverList.length) {
	    return crossoverList[index];
	} else {
	    throw new ArrayIndexOutOfBoundsException(index);
	}
    }

    public abstract Solution<iProblem, iObjective, iCodification, Solution> runCross(Solution<iProblem, iObjective, iCodification, Solution> s1, Solution<iProblem, iObjective, iCodification, Solution> s2) throws Exception;

    public double getCrossoverRate() {
	return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
	this.crossoverRate = crossoverRate;
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	problemNode = link.need(Problem.class, problemNode);
	crossoverList = link.needs(oCrossover.class, new oCrossover[1]);
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {
	crossoverRate = link.Dbl("Crossover Rate", GlobalConstants.crossoverRate, 0, 1);
    }

    @Override
    public void load() throws Exception {
    }

    @Override
    public void start() throws Exception {
	//initialization code here
    }

    @Override
    public boolean validation(LinkerValidations link) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void results(LinkerResults link) throws Exception {
    }
}
