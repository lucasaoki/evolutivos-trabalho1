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
public class iFunctionMR extends aFunction {

    private double[] ti = {1.0, 2.0, 1.0, 2.0, 0.1};
    private double[] vi = {1.0, 1.0, 2.0, 2.0, 0.0};
    private double[] yi = {0.126, 0.219, 0.076, 0.126, 0.186};

    public iFunctionMR() {
        super(3);
        limitList.get(0).setLimits(-10.0, 10.0);
        limitList.get(1).setLimits(-10.0, 10.0);
        limitList.get(2).setLimits(-10.0, 10.0);
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double eval = 0;
        int i;

        for (i = 0; i < 5; i++) {
            eval += Math.pow((x[0] * x[2] * ti[i]) / (1 + x[0] * ti[i] + x[1] * vi[i]) - yi[i], 2);
        }

        return eval;
    }

    @Override
    public String name() {
        return "MR Function";
    }

    @Override
    public String description() {
        return "To be done (MR Function)";
    }
}
