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
public class iFunctionWP extends aFunction {

    public iFunctionWP() {
        super(4);
        limitList.get(0).setLimits(-10.0, 10.0);
        limitList.get(1).setLimits(-10.0, 10.0);
        limitList.get(2).setLimits(-10.0, 10.0);
        limitList.get(3).setLimits(-10.0, 10.0);
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double eval;
        eval = 100 * Math.pow(x[1] - Math.pow(x[0], 2), 2) + Math.pow(1 - x[0], 2) + 90 * Math.pow(x[3] - Math.pow(x[2], 2), 2) + Math.pow(1 - x[2], 2);
        eval += 10.1 * (Math.pow(x[1] - 1, 2) + Math.pow(x[3] - 1, 2)) + 19.8 * (x[1] - 1) * (x[3] - 1);

        return eval;
    }

    @Override
    public String name() {
        return "WP Function";
    }

    @Override
    public String description() {
        return "To be done (WP Function)";
    }

    @Override
    public double getDefinedMinGlobal() throws Exception {
        return 0;
    }

    @Override
    public double[] getDefinedBestSol() throws Exception {
        return new double[]{1, 1, 1, 1};
    }
}
