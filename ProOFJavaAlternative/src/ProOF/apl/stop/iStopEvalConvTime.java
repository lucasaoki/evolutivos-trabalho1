/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.stop;

import ProOF.com.Communication;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerValidations;
import ProOF.com.StreamProgress;
import ProOF.gen.best.nEvaluations;
import ProOF.gen.stopping.aStop;
import ProOF.gen.stopping.pIteration;

/**
 *
 * @author ito
 */
public class iStopEvalConvTime extends aStop {

    public static final iStopEvalConvTime obj = new iStopEvalConvTime();
    //eval
    private nEvaluations eval;
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

    @Override
    public String name() {
	return "Custom Stop";
    }

    @Override
    public String description() {
	return "Stop for evaluations/time/convergion iterations";
    }

    @Override
    public void services(LinkerNodes win) throws Exception {
	eval = (nEvaluations) win.need(nEvaluations.class);
	iter = (pIteration) win.need(pIteration.class);
    }

    @Override
    public void load() throws Exception {
	comEval = Communication.mkProgress("evaluation progress");
	comIter = Communication.mkProgress("iteration progress");
	comTime = Communication.mkProgress("Time progress");

    }

    @Override
    public void start() throws Exception {
	initial_time = System.currentTimeMillis();
    }

    @Override
    public void parameters(LinkerParameters win) throws Exception {
	max_evaluations = win.Long("Evaluations", 1000, 0, 1000000000, "the maximum evaluations (0 disable)");
	_max_eval_enable = max_evaluations != 0;

	time = win.Dbl("seconds", 2 * 60, 0, 1000000000, "the maximum time in seconds (0 disable)");
	_max_sec_enable = time != 0;

	max_iterations = win.Long("iterations w/o change", 10, 0, 1000000000, "the maximum iteration w/o vary (0 disable) ");
	_max_iter_enable = max_iterations != 0;
    }

    @Override
    public boolean validation(LinkerValidations win) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double progress() throws Exception {
	double p = 0, pEval, pTime, pIter;

	if (_max_eval_enable) {
	    pEval = eval.value() * 1.0 / max_evaluations;
	    comEval.progress(pEval);
	    p = pEval;
	}

	if (_max_sec_enable) {
	    pTime = time() / time;
	    comTime.progress(pTime);
	    if (p < pTime) {
		p = pTime;
	    }
	}

	if (_max_iter_enable) {
	    pIter = iter.value() * 1.0 / max_iterations;
	    comIter.progress(pIter);
	    if (p < pIter) {
		p = pIter;
	    }
	}


	return p;
    }

    @Override
    public boolean end() throws Exception {
	progress();

	boolean result = false;

	if (_max_eval_enable && !result) {
	    result = eval.value() > max_evaluations;
	}
	if (_max_sec_enable && !result) {
	    result =  time() / time > 1.0;
	}
	if (_max_iter_enable && !result) {
	    result = iter.value() > max_iterations;
	}


	return result;
    }

    public double time() {
	return (System.currentTimeMillis() - initial_time) / 1000.0;
    }
}
