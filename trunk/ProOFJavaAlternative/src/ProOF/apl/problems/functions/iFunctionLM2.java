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
public class iFunctionLM2 extends aFunction {

    @Override
    public String name() {
        return "LM2 Function";
    }

    @Override
    public String description() {
        return "To be done (LM2 Function)";
    }

    public iFunctionLM2() {
        //IMPORTANT!!! SUPER(SIZE)
        super(10); /* Variável!! */
        for (int i = 0; i < limitList.size(); i++) {
            limitList.get(i).setLimits(-5, 5);
        }
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();
        double sum = 0;
        double eval = 0;

        for (int i = 0; i < getSize() - 1; i++) {
            sum += (Math.pow(x[i] - 1, 2) * (1 + Math.pow(Math.sin(3 * Math.PI * x[i + 1]), 2)));
        }
        eval = 0.1 * (Math.pow(Math.sin(3 * Math.PI * x[0]), 2) + sum + Math.pow(x[getSize() - 1] - 1, 2) * (1 + Math.pow(Math.sin(2 * Math.PI * x[getSize() - 1]), 2)));

        return eval;
    }
}
