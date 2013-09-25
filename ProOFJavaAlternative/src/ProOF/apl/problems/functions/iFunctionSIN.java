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
public class iFunctionSIN extends aFunction {

    private double A = 2.5;
    private double B = 5;
    private double z = Math.PI / 6;

    public iFunctionSIN() {
        super(20);
        for (int i = 0; i < 20; i++) {
            limitList.get(i).setLimits(0.0, Math.PI);
        }

    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double eval;

        double prod1 = 1.0;
        double prod2 = 1.0;
        int i;
        for (i = 0; i < 20; i++) {
            prod1 *= Math.sin(x[i] - z);
            prod2 *= Math.sin(B * (x[i] - z));
        }

        eval = -(A * prod1 + prod2);
        return eval;
    }

    @Override
    public String name() {
        return "SIN Function";
    }

    @Override
    public String description() {
        return "To be done (SIN Function)";
    }

    @Override
    public double getDefinedMinGlobal() throws Exception {
        return -(A + 1);
    }

    @Override
    public double[] getDefinedBestSol() throws Exception {
        return new double[]{90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z, 90 + z};
    }
}
