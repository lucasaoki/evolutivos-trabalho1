/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.apl.stop.iStopEvalConvTime;
import ProOF.com.Communication;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerResults;
import ProOF.com.StreamPrinter;
import ProOF.com.runner.ExceptionForceFinish;
import ProOF.gen.stopping.aStop;
import ProOF.gen.stopping.pIteration;
import ProOF.opt.abst.problem.meta.Best;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.Solution;
import ProOF.utilities.uTime;
import ProOF.utilities.uTimeMilli;

/**
 *
 * @author ito
 */
public class iBestSol extends Best {

    private static iBestSol obj = null;
    protected iProblem problemNode;

    public static iBestSol object() {
	if (obj == null) {
	    obj = new iBestSol();
	}
	return obj;
    }

    private class Sol {

	private Solution sol;
	private long eval;
	private long iteration;
	private double time;

	public Sol(Solution sol, long eval, long iteration, double time) {
	    this.sol = sol;
	    this.eval = eval;
	    this.iteration = iteration;
	    this.time = time;
	}
    }
    /*private pMetaSolution best;
     private long eval_best;
     private double time_best;
     private double time_tot;
     */
    private Sol best;
    private final uTime time = new uTimeMilli();
    private final iEvaluations cont_eval = iEvaluations.object();
    private pIteration cont_iter;
    private aStop stop;
    private StreamPrinter com;

    @Override
    public String name() {
	return "iBestSol";
    }

    @Override
    public String description() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Solution ind() throws Exception {
	return best.sol;
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	link.add(cont_eval);
	stop = link.need(aStop.class, stop);
	cont_iter = link.need(pIteration.class, cont_iter);
	problemNode = link.need(Problem.class, problemNode);
    }

    @Override
    public void load() throws Exception {
	com = Communication.mkPrinter("bests");
    }

    @Override
    public void start() throws Exception {
	best = new Sol(null, 0, 0, 0);
	time.start();

	printComGeneral("Eval\t\tIter\tTime\tSolution");
    }

    @Override
    public void better(Problem prob, Solution sol) throws Exception {
	//best = best==null ? sol : stop.evaluate() ? best : best.minimum(sol);
	cont_eval.update();

	iObjective iobj = (iObjective) sol.obj();
	iCodification icod = (iCodification) sol.codif();

	if (!stop.end()) {
	    if (best.sol == null || sol.LT(best.sol)) {

		if (stop instanceof iStopEvalConvTime && best.sol != null) {
		    iStopEvalConvTime sp = (iStopEvalConvTime) stop;
		    iObjective iobjBest = (iObjective) best.sol.obj();
		    if (Math.abs(iobj.abs_value() - iobjBest.abs_value()) < sp.getMax_RangeVary()) {
			cont_eval.updateWithoutVary();
		    } else {
			cont_eval.resetWithoutVary();
		    }
		}


		best.sol = sol.Clone(prob);
		best.eval = cont_eval.value();
		best.iteration = cont_iter.value();
		best.time = time_now();
		printComGeneral(String.format("%9d\t%6d\t%8f\t%.6f", best.eval, best.iteration, time_best(), iobj.abs_value()));
//		com.printLong("eval", best.eval);
//		com.printLong("iter", best.iteration);
//		com.printDbl("time", time_best());
		//best.sol.obj().printer(prob, com);

		System.out.print("Best Sol: " + String.format("%f", iobj.abs_value()) + " Values: ");

		for (double d : icod.X) {
		    System.out.format("[%.3f] ", d);
		}

		System.out.println();
	    }
	} else if (force_finish) {
	    throw new ExceptionForceFinish();
	}
    }

    @Override
    public void finish() throws Exception {
	if (best.sol.obj() != null) {
	    iObjective iobj = (iObjective) best.sol.obj();
	    iCodification icod = (iCodification) best.sol.codif();
	    System.out.println("=================================================");
	    System.out.println("Best Sol: " + String.format("%f", iobj.abs_value()));
	    for (int c = 0; c < icod.X.length; c++) {
		System.out.format("\tX[%d]: %f\t->Check: %s\t[%f < X < %f%n", c, icod.X[c], (icod.X[c] >= problemNode.getIFunc().getMin(c)) && (icod.X[c] <= problemNode.getIFunc().getMax(c)), problemNode.getIFunc().getMin(c), problemNode.getIFunc().getMax(c));
	    }

	    double dist = Math.abs(problemNode.getIFunc().getDefinedMinGlobal() - iobj.abs_value());
	    System.out.println("Distance from optimal Solution: " + Double.toString(dist) + " " + (dist < 0.01 ? ":-)" : ":-("));
	    System.out.println("=================================================");
	}
    }

    @Override
    public void results(Problem prob, LinkerResults link) throws Exception {
	link.writeLong("eval tot", cont_eval.value());
	link.writeLong("eval best", best.eval);
	link.writeLong("iter tot", cont_iter.value());
	link.writeLong("iter best", best.iteration);
	link.writeDbl("time tot", time_now());
	link.writeDbl("time best", time_best());
	link.writeDbl("time after", time_after());


	if (best.sol != null) {
	    iObjective iobj = (iObjective) best.sol.obj();
	    link.writeString("BestSol", Double.toString(iobj.abs_value()));
	    double dist = Math.abs(problemNode.getIFunc().getDefinedMinGlobal() - iobj.abs_value());
	    link.writeDbl("DiffBest", Math.abs(problemNode.getIFunc().getDefinedMinGlobal() - iobj.abs_value()));
	    link.writeString("DiffBest1", (dist < 0.01 ? ":-)" : ":-("));

//	    best.sol.obj().results(prob, link);
//	    best.sol.codif().resulter(prob, link);
	}
    }

    private void printComGeneral(String str) throws Exception {
	com.printString("Info", str);
	com.flush();
    }

    @Override
    public double time_now() {
	return time.time();
    }

    @Override
    public double time_best() {
	return best.time;
    }

    @Override
    public double time_after() {
	return time_now() - time_best();
    }

    public double iter_best() {
	return best.iteration;
    }
}
