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
public class iFunctionHSK extends aFunction {

    @Override
    public String name() {
        return "HSK Function";
    }

    @Override
    public String description() {
        return "To be done (HSK Function)";
    }

    public iFunctionHSK() {
        //IMPORTANT!!! SUPER(SIZE)
        super(2);
        limitList.get(0).setLimits(0, 5);
        limitList.get(1).setLimits(0, 6);
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();

        return (1 - 8 * x[0] + 7 * Math.pow(x[0], 2) - 7.0 / (3 * Math.pow(x[0], 3)) + 1.0 / (4 * Math.pow(x[0], 4))) * Math.pow(x[1], 2) * Math.exp(-x[1]);
    }
}
