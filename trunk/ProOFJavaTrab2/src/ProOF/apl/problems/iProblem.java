/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.apl.problems.maze.aMaze;
import ProOF.apl.problems.maze.fMaze;
import ProOF.apl.problems.operators.crossover.algorithm.fCrossover;
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
    private aMaze imaze;

    public iProblem() {
	bestSol = iBestSol.object();
	BestSol.force_finish(false);
    }

    public aMaze getIMaze() {
	return imaze;
    }

    @Override
    public String name() {
	return "iProblem implementation";
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	super.services(link);
	imaze = link.get(fMaze.obj, imaze);
	link.add(fOperatorInitializer.obj);
	link.add(fCrossover.obj);
	link.add(fMutation.obj);
    }

    @Override
    public iBestSol best() {
	return bestSol;
    }

    @Override
    public Codification NewCodification() throws Exception {
	return new iCodification(imaze.getMaze());
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
