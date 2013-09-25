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
public class iFunctionKL extends aFunction {

    @Override
    public String name() {
        return "KL Function";
    }

    @Override
    public String description() {
        return "To be done (KL Function)";
    }

    public iFunctionKL() {
        //IMPORTANT!!! SUPER(SIZE)
        super(4);
        for (int i = 0; i < limitList.size(); i++) {
            limitList.get(i).setLimits(0, 0.42);
        }
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double[] ai = {0.1957, 0.1947, 0.1735, 0.16, 0.0844, 0.0627, 0.0456, 0.0342, 0.0323, 0.0235, 0.0246};
        double[] bi = {0.25, 0.50, 1.0, 2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0};

        double eval = 0;
        for (int i = 0; i < 11; i++) {
            eval += Math.pow(ai[i] - x[0] * (1.0 + x[1] * bi[i]) / (1.0 + x[2] * bi[i] + x[3] * Math.pow(bi[i], 2)), 2);
        }

        return eval;
    }

    @Override
    public double getDefinedMinGlobal() throws Exception {
        return 3.0748e-4;
    }

    @Override
    public double[] getDefinedBestSol() throws Exception {
        return new double[]{0.192, 0.190, 0.123, 0.135};
    }
}
