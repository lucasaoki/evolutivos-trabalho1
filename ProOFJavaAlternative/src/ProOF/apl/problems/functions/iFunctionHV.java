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
public class iFunctionHV extends aFunction {

    @Override
    public String name() {
        return "HV Function";
    }

    @Override
    public String description() {
        return "To be done (HV Function)";
    }

    public iFunctionHV() {
        //IMPORTANT!!! SUPER(SIZE)
        super(3);
        for (int i = 0; i < limitList.size(); i++) {
            limitList.get(i).setLimits(-10, 10);
        }
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();

        double theta;
        if (x[0] < 0) { /* Verificar se 1/2 está mesmo no tan-1 */
            theta = (1.0 / (Math.PI * 2)) * Math.pow(Math.tan(x[1] / x[0]) + 1.0 / 2, -1);
        } else {
            theta = (1.0 / (Math.PI * 2)) * Math.pow(Math.tan(x[1] / x[0]), -1);
        }
        return 100 * (Math.pow(x[1] - 10 * theta, 2) + (Math.pow(Math.sqrt(Math.pow(x[0], 2) + Math.pow(x[1], 2)) - 1, 2))) + Math.pow(x[2], 2);
    }
}
