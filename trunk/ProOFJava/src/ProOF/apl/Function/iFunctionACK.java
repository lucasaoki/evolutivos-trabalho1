/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.Function;

import ProOF.apl.aFunction;
import ProOF.apl.methods.Cod;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author ito
 */
public final class iFunctionACK extends aFunction {

    @Override
    public String name() {
	return "ACK Function";
    }

    @Override
    public String description() {
	return "To be done (ACK Function ";
    }

    public iFunctionACK() {
	
	_size = 10;
	initialize();
	
    }

    @Override
    public void initialize() {
	_max = new double[_size];
	_min = new double[_size];
	int i;

	for (i = 0; i < _size; i++) {
	    _max[i] = 30;
	    _min[i] = -30;
	}
    }

    @Override
    public void Evaluate(Codification codif) throws Exception {
	double[] x = ((Cod) codif).getInd();
	double sum1 = 0;
	double sum2 = 0;
	double eval = 0;
	int i = 0;

	for (i = 0; i < _size; i++) {
	    sum1 += Math.pow(x[i], 2);
	    sum2 += Math.cos(2.0 * Math.PI * x[i]);
	}
	eval = -20.0 * Math.exp(-0.02 * Math.sqrt(sum1 / _size)) - Math.exp(sum2 / _size) + 20.0 + Math.E;

	((Cod) codif).setFitness(eval);
    }
}
