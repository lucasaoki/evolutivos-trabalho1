/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.apl.methods.Cod;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;
import ProOF.opt.abst.problem.meta.objective.SingleObjective;

/**
 *
 * @author Seiji
 */
public class MCP extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max = 1 ;
    private double _min = -1;

    public MCP() throws Exception {
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new MCP();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        eval = Math.pow(Math.exp(x[0] - x[1]), 4) + 100 * Math.pow(x[1] - x[2], 6) + Math.pow(x[2] - x[3], 4) + Math.pow(x[0], 8);
        ((Cod) codif).setFitness(eval);
    }
}
