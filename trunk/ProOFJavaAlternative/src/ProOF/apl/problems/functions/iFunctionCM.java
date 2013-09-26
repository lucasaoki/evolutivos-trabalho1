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
public class iFunctionCM extends aFunction {

    @Override
    public String name() {
        return "CM Function";
    }

    @Override
    public String description() {
        return "To be done (CM Function)";
    }

    public iFunctionCM() {
        //IMPORTANT!!! SUPER(SIZE)
        super(4);
        for (int i = 0; i < limitList.size(); i++) {
            limitList.get(i).setLimits(-1, 1);
        }
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < getSize(); i++) {
            sum1 += Math.cos(5 * Math.PI * x[i]);
            sum2 += Math.pow(x[i], 2);
        }
        return (-1 * (0.1 * sum1 - sum2));
    }

    @Override
    public double getDefinedMinGlobal() throws Exception {
        return -0.4;
    }

    @Override
    public double[] getDefinedBestSol() throws Exception {
        return new double[]{0, 0, 0, 0};
    }
}
