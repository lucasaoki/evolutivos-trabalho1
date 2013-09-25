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
        limitList.get(0).setLimits(-5, 10);
        limitList.get(1).setLimits(0, 15);
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double a = 1.0;
        double b = 5.1 / (4 * Math.pow(Math.PI, 2));
        double c = 5.0 / Math.PI;
        double d = 6.0;
        double g = 10.0;
        double h = 1.0 / (8 * Math.PI);

        return a * Math.pow(x[1] - b * Math.pow(x[0], 2) + c * x[0] - d, 2) + g * (1 - h) * Math.cos(x[0]) + g;
    }
}
