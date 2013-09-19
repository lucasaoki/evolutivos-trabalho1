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
public class HSK extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max = {5, 6};
    private double[] _min = {0, 0};

    public HSK() throws Exception {
    }

    public double[] getMax() {
        return _max;
    }

    public double[] getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new HSK();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval;

        eval = (1 - 8 * x[0] + 7 * Math.sqrt(x[0]) - 7 / (3 * Math.pow(x[0], 3)) + 1 / (4 * Math.pow(x[0], 4))) * Math.sqrt(x[1]) * Math.exp(-x[1]);
        ((Cod) codif).setFitness(eval);
    }
}
