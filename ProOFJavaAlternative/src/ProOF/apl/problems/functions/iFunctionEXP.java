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
public class iFunctionEXP extends aFunction {

    @Override
    public String name() {
	return "CM Function";
    }

    @Override
    public String description() {
	return "To be done (CM Function)";
    }

    public iFunctionEXP() {
	//IMPORTANT!!! SUPER(SIZE)
	super(10);
	for (int i = 0; i < limitList.size(); i++) {
	    limitList.get(i).setLimits(-1, 1);
	}
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
	double[] x = codif.getInd();
	double sum = 0;

	for (int i = 0; i < codif.getSize(); i++) {
            sum += Math.pow(x[i],2);
        }
	return (-Math.exp(-0.5 * sum));
    }
}
