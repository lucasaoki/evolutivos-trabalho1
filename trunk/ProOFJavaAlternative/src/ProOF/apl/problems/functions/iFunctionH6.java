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
public class iFunctionH6 extends aFunction {

    @Override
    public String name() {
        return "H6 Function";
    }

    @Override
    public String description() {
        return "To be done (H6 Function)";
    }

    public iFunctionH6() {
        //IMPORTANT!!! SUPER(SIZE)
        super(6);
        for (int i = 0; i < limitList.size(); i++) {
            limitList.get(i).setLimits(0, 1);
        }
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double sum = 0;
        double eval = 0;
        double[] ci = {1, 1.2, 3, 3.2};
        double[][] aij = {
            {10, 3, 17, 3.5, 1.7, 8},
            {0.05, 10, 17, 0.1, 8, 14},
            {3, 3.5, 1.7, 10, 17, 8},
            {17, 8, 0.05, 10, 0.1, 14}
        };
        double[][] pij = {
            {0.1312, 0.1696, 0.5569, 0.0124, 0.8283, 0.5886},
            {0.2329, 0.4135, 0.8307, 0.3736, 0.1004, 0.9991},
            {0.2348, 0.1451, 0.3522, 0.2883, 0.3047, 0.665},
            {0.4047, 0.8828, 0.8732, 0.5743, 0.1091, 0.0381}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                sum += aij[i][j] * Math.pow(x[j] - pij[i][j], 2);
            }
            eval += ci[i] * Math.exp(-sum);
        }
        return -eval;
    }
}
