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
public class iFunctionMCP extends aFunction {

    @Override
    public String name() {
        return "MCP Function";
    }

    @Override
    public String description() {
        return "To be done (MCP Function)";
    }

    public iFunctionMCP() {
        //IMPORTANT!!! SUPER(SIZE)
        super(4);
        for (int i = 0; i < limitList.size(); i++) {
            limitList.get(i).setLimits(-1, 1);
        }
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
        double[] x = codif.getInd();

        return Math.pow(Math.exp(x[0]) - x[1], 4) + 100 * Math.pow(x[1] - x[2], 6) + Math.pow(Math.tan(x[2] - x[3]), 4) + Math.pow(x[0], 8);
    }
}
