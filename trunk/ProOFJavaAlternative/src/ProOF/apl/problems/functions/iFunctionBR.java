/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.functions;

import ProOF.apl.problems.iCodification;

/**
 *
 * @author Lucas
 */
public class iFunctionBR extends aFunction {

    @Override
    public String name() {
	return "BR Function";
    }

    @Override
    public String description() {
	return "To be done (BR Function)";
    }

    public iFunctionBR() {
	//IMPORTANT!!! SUPER(SIZE)
	super(2);
	for (int i = 0; i < limitList.size(); i++) {
	    limitList.get(i).setLimits(-50, 50);
	}
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
	double[] x = codif.getInd();
	double sum1 = 0;
	double sum2 = 0;

	for (int i = 0; i < getSize(); i++) {
	    sum1 += Math.pow(x[i], 2);
	    sum2 += Math.cos(2.0 * Math.PI * x[i]);
	}
	return -20.0 * Math.exp(-0.02 * Math.sqrt(sum1 / getSize())) - Math.exp(sum2 / getSize()) + 20.0 + Math.E;
    }
}
