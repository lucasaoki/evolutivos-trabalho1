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
public class iFunctionGP extends aFunction {

    @Override
    public String name() {
	return "GP Function";
    }

    @Override
    public String description() {
	return "To be done (GP Function)";
    }

    public iFunctionGP() {
	//IMPORTANT!!! SUPER(SIZE)
	super(2);
	for (int i = 0; i < limitList.size(); i++) {
	    limitList.get(i).setLimits(-2, 2);
	}
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
	double[] x = codif.getInd();
	
        double eval = 0;

        eval = 1 + Math.pow(x[0] + x[1] + 1, 2) * (19 - 14 * x[0] + 3 * Math.pow(x[0], 2) - 14 * x[1] + 6 * x[0] * x[1] + 3 * Math.pow(x[1], 2));
        eval *= (30 + Math.pow(2 * x[0] - 3 * x[1], 2) * (18 - 32 * x[0] + 12 * Math.pow(x[0], 2) + 48 * x[1] - 36 * x[0] * x[1] + 27 * Math.pow(x[1], 2)));

	return eval;
    }
}
