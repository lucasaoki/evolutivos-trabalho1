/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.apl.problems.functions.aFunction;
import ProOF.apl.problems.functions.fFunction;
import ProOF.apl.problems.operators.crossover.algorithm.fCrossover;
import ProOF.apl.problems.operators.fRealOperator;
import ProOF.apl.problems.operators.init.fOperatorInitializer;
import ProOF.apl.problems.operators.mutation.algorithm.fMutation;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerResults;
import ProOF.gen.best.BestSol;
import ProOF.opt.abst.problem.meta.Objective;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author ito
 */
public class iProblem extends Problem<iBestSol> {

    private iBestSol bestSol;
    private aFunction ifunction;

    public iProblem() {
	bestSol = iBestSol.object();
	BestSol.force_finish(false);
    }

    public aFunction getIFunc() {
	return ifunction;
    }

    @Override
    public String name() {
	return "iProblem implementation";
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	super.services(link);
	ifunction = link.get(fFunction.obj, ifunction);
	link.add(fOperatorInitializer.obj);
	link.add(fCrossover.obj);
	link.add(fMutation.obj);
    }

    @Override
    public iBestSol best() {
	return bestSol;
    }

    //important because problemNode.NewSolution() calls newCodification and newObjective
    @Override
    public Codification NewCodification() throws Exception {
	return new iCodification(ifunction.getSize());
    }

    @Override
    public Objective NewObjective() throws Exception {
	return new iObjective();
    }

    @Override
    public void results(LinkerResults com) throws Exception {
	super.results(com);
	System.out.printf("iproblem results\n");
    }
}
