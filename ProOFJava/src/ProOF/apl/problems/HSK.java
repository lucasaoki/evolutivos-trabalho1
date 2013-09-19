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

    private double[] _max;
    private double[] _min;
    private int size = 2;

    public void initialize() {
        _max[0] = 5;
        _max[1] = 6;
        _min[0] = 0;
        _min[1] = 0;
    }

    public double getMin(int n) {
        return _min[n];
    }

    public double getMax(int n) {
        return _max[n];
    }

    public HSK() throws Exception {
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new HSK();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval;

        eval = (1 - 8 * x[0] + 7 * Math.sqrt(x[0]) - 7.0 / (3 * Math.pow(x[0], 3)) + 1.0 / (4 * Math.pow(x[0], 4))) * Math.sqrt(x[1]) * Math.exp(-x[1]);
        ((Cod) codif).setFitness(eval);
    }
}
