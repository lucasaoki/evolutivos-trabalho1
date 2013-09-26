/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.language.Node;
import ProOF.gen.operator.oMutation;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.Solution;
import ProOF.utils.GlobalConstants;

/**
 *
 * @author ito
 */
public abstract class aMutationProvider extends Node {

    protected iProblem problemNode;
    protected oMutation<iProblem, iCodification>[] mutationList;
    protected double mutationRate;

    public abstract Solution<iProblem, iObjective, iCodification, Solution> runMutation(Solution<iProblem, iObjective, iCodification, Solution> s1);

    public double getMutationRate() {
	return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
	this.mutationRate = mutationRate;
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	problemNode = link.need(Problem.class, problemNode);
	mutationList = link.needs(oMutation.class, new oMutation[1]);
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {
	mutationRate = link.Dbl("Mutatin Rate", GlobalConstants.mutationRate, 0, 1);
    }

    @Override
    public void load() throws Exception {
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public boolean validation(LinkerValidations link) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void results(LinkerResults link) throws Exception {
    }
}
