/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.stop;

import ProOF.apl.problems.iEvaluations;
import ProOF.apl.problems.iProblem;
import ProOF.com.Communication;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerValidations;
import ProOF.com.StreamProgress;
import ProOF.gen.stopping.aStop;
import ProOF.gen.stopping.pIteration;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.utils.GlobalConstants;

/**
 *
 * @author ito
 */
public class iStopEvalConvTime extends aStop {

    public static final iStopEvalConvTime obj = new iStopEvalConvTime();
    //eval
    private iEvaluations eval;
    private StreamProgress comEval;
    private long max_evaluations;
    private boolean _max_eval_enable = true;
    //time
    private long initial_time;
    private StreamProgress comTime;
    private double time;
    private boolean _max_sec_enable = true;
    //iterations
    private pIteration iter;
    private StreamProgress comIter;
    private long max_iterations;
    private boolean _max_iter_enable = true;
    //vary
    private iProblem problem;
    private StreamProgress comIterWOVary;
    private long max_IterWOVary;
    private double lastIter;
    private boolean _max_iter_wo_Vary = true;
    //best sol vary
    private double max_RangeVary;
    private long max_RangeVaryEval;
    private StreamProgress comEvaWOVary;
    private boolean _max_eval_wo_Vary = true;
    private String StopResult;

    @Override
    public String name() {
	return "Custom Stop";
    }

    @Override
    public String description() {
	return "Stop for evaluations/time/iteration/convergion iterations";
    }

    @Override
    public void services(LinkerNodes win) throws Exception {
	problem = (iProblem) win.need(Problem.class, problem);
	eval = (iEvaluations) win.need(iEvaluations.class);
	iter = (pIteration) win.need(pIteration.class);
    }

    @Override
    public void parameters(LinkerParameters win) throws Exception {
	max_evaluations = win.Long("Evaluations", GlobalConstants.max_evaluations, 0, 1000000000, "the maximum evaluations (0 disable)");
	_max_eval_enable = max_evaluations != 0;

	time = win.Dbl("seconds", GlobalConstants.time, 0, 1000000000, "the maximum time in seconds (0 disable)");
	_max_sec_enable = time != 0;

	max_iterations = win.Long("iterations", GlobalConstants.max_iterations, 0, 1000000000, "the maximum iteration w/o vary (0 disable) ");
	_max_iter_enable = max_iterations != 0;

	max_RangeVary = win.Dbl("BestSol evaluates w/o vary GAP", GlobalConstants.max_RangeVary, 0, 1, "the maximum evaluate w/o vary (0 disable) gap ");
	max_RangeVaryEval = win.Long("BestSol number of evaluates w/o vary", GlobalConstants.max_RangeVaryEval, 0, 1000000000, "the maximum evaluate w/o vary (0 disable) gap ");
	_max_eval_wo_Vary = max_RangeVary != 0 && max_RangeVaryEval != 0;

	max_IterWOVary = win.Long("iterations w/o vary", GlobalConstants.max_IterWOVary, 0, 1000000000, "the maximum iteration w/o vary (0 disable) ");
	_max_iter_wo_Vary = max_IterWOVary != 0;
    }

    public double getMax_RangeVary() {
	return max_RangeVary;
    }

    public double getMax_RangeVaryEval() {
	return max_RangeVaryEval;
    }

    @Override
    public void load() throws Exception {
	if (_max_eval_enable) {
	    comEval = Communication.mkProgress("evaluation progress");
	}
	if (_max_iter_enable) {
	    comIter = Communication.mkProgress("iteration progress");
	}
	if (_max_sec_enable) {
	    comTime = Communication.mkProgress("Time progress");
	}
	if (_max_iter_wo_Vary) {
	    comIterWOVary = Communication.mkProgress("Iteration w/o vary progress");
	}
	if (_max_eval_wo_Vary) {
	    comEvaWOVary = Communication.mkProgress("Evaluations w/o bestValue vary progress");
	}
    }

    @Override
    public void start() throws Exception {
	initial_time = System.currentTimeMillis();
	StopResult = "";
    }

    @Override
    public boolean validation(LinkerValidations win) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double progress() throws Exception {
	double p = 0, pEval, pTime, pIter, pIterWOVary, pEvalWOVary;

	if (_max_eval_enable) {
	    pEval = eval.value() * 1.0 / max_evaluations;
	    if (pEval > 1) {
		pEval = 1;
	    } else if (pEval < 0) {
		pEval = 0;
	    }
	    comEval.progress(pEval);
	}

	if (_max_sec_enable) {
	    pTime = time() / time;
	    comTime.progress(pTime);
	}

	if (_max_iter_enable) {
	    pIter = iter.value() * 1.0 / max_iterations;
	    comIter.progress(pIter);
	}

	if (_max_iter_wo_Vary) {
	    pIterWOVary = (iter.value() - problem.best().iter_best()) / max_IterWOVary;
	    comIterWOVary.progress(pIterWOVary);
	}

	if (_max_eval_wo_Vary) {
	    pEvalWOVary = eval.valueWithoutVary() / max_RangeVaryEval;
	    comEvaWOVary.progress(pEvalWOVary);
	}
	return p;
    }

    @Override
    public boolean end() throws Exception {
	progress();

	boolean result = false;

	if (_max_eval_enable && !result) {
	    result = eval.value() >= max_evaluations;
	    if (result) {
		StopResult = ("Stop by Max Eval");
	    }
	}
	if (_max_sec_enable && !result) {
	    result = time() / time >= 1.0;
	    if (result) {
		StopResult = ("Stop by time elapsed");
	    }
	}
	if (_max_iter_enable && !result) {
	    result = iter.value() >= max_iterations;
	    if (result) {
		StopResult = ("Stop by Max Iterationss");
	    }
	}
	if (_max_iter_wo_Vary && !result) {
	    result = (iter.value() - problem.best().iter_best()) >= max_IterWOVary;
	    if (result) {
		StopResult = ("Stop by Max iteration Best Sol vary");
	    }
	}

	if (_max_eval_wo_Vary && !result) {
	    result = eval.valueWithoutVary() > max_RangeVaryEval;
	    if (result) {
		StopResult = ("Stop by Max Eval Best Sol vary with band");
	    }
	}


	return result;
    }

    @Override
    public void finish() throws Exception {
	System.out.println(StopResult);
    }

    public double time() {
	return (System.currentTimeMillis() - initial_time) / 1000.0;
    }
}
