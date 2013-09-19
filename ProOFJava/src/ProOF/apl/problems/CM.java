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
public class CM extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;
    private int size = 4;

    public void initialize() {
        _max = new double[size];
        _min = new double[size];
        int i;
        for (i = 0; i < size; i++) {
            _max[i] = 1;
            _min[i] = -1;
        }
    }

    public double getMin(int n) {
        return _min[n];
    }

    public double getMax(int n) {
        return _max[n];
    }

    public int getSize() {
        return size;
    }

    public CM() throws Exception {
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new CM();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double sum1 = 0;
        double sum2 = 0;
        double eval = 0;
        int i = 0;

        for (i = 0; i < size; i++) {
            sum1 += Math.cos(5 * Math.PI * x[i]);
            sum2 += Math.sqrt(x[i]);
        }
        eval = -1 * (0.1 * sum1 - sum2);
        ((Cod) codif).setFitness(eval);
    }
}
