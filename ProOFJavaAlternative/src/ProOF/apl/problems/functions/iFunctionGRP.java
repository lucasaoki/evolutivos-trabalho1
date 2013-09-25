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
public class iFunctionGRP extends aFunction {

    @Override
    public String name() {
        return "GRP Function";
    }

    @Override
    public String description() {
        return "To be done (GRP Function)";
    }

    public iFunctionGRP() {
        //IMPORTANT!!! SUPER(SIZE)
        super(3);
        limitList.get(0).setLimits(0.1, 100);
        limitList.get(1).setLimits(0, 25.6);
        limitList.get(2).setLimits(0, 5);
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double eval = 0;
        double ui;

        for (int i = 1; i <= 99; i++) {
            ui = 25 + Math.pow(-50 * Math.log(0.01 * (i)), (1 / 1.5));
            eval += Math.pow(Math.exp(-Math.pow(ui - x[1], x[2]) / x[0]) - 0.01 * (i), 2);
        }
        return eval;
    }
}
