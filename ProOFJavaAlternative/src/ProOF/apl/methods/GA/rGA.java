/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods.GA;

import ProOF.apl.factorys.fProblem;
import ProOF.apl.factorys.fStop;
import ProOF.apl.methods.GA.algorithm.aGA;
import ProOF.apl.methods.GA.algorithm.fGA;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.gen.stopping.aStop;
import ProOF.gen.stopping.pIteration;
import ProOF.opt.abst.metaheuristic.MetaHeuristic;
import ProOF.opt.abst.problem.meta.Problem;

/**
 *
 * @author ito
 */
public class rGA extends MetaHeuristic {

    private Problem _prob;
    private aGA _algorithm;
    private aStop _stop;
    private pIteration _iteration;

    @Override
    public String name() {
	return "GA Base Metaheuristic";
    }

    @Override
    public String description() {
	return "GA Base Metaheuristic description";

    }

    @Override
    public void parameters(LinkerParameters win) throws Exception {
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	_prob = link.get(fProblem.obj, _prob);
	_algorithm = link.get(fGA.obj, _algorithm);
	_stop = link.get(fStop.obj, _stop);
	_iteration = pIteration.object();
	link.add(_iteration);
    }

    @Override
    public void execute() throws Exception {

	_algorithm.initialize();

	while (!_stop.end()) {
	    _algorithm.iterate();
	    _iteration.iteration();
	}
    }

    @Override
    public boolean validation(LinkerValidations win) throws Exception {
	return super.validation(win); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() throws Exception {
	super.load(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() throws Exception {
	super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void results(LinkerResults win) throws Exception {
	System.out.printf("rGA results\n");
    }

    @Override
    public void finish() throws Exception {
	System.out.printf("rGA finish\n");
    }
}
