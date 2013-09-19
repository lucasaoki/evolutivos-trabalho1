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
public class H6 extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;
    private int size = 6;
    private double[] ci = {1, 1.2, 3, 3.2};
    private double[][] aij = {
        {10, 3, 17, 3.5, 1.7, 8},
        {0.05, 10, 17, 0.1, 8, 14},
        {3, 3.5, 1.7, 10, 17, 8},
        {17, 8, 0.05, 10, 0.1, 14}
    };
    private double[][] pij = {
        {0.1312, 0.1696, 0.5569, 0.0124, 0.8283, 0.5886},
        {0.2329, 0.4135, 0.8307, 0.3736, 0.1004, 0.9991},
        {0.2348, 0.1451, 0.3522, 0.2883, 0.3047, 0.665},
        {0.4047, 0.8828, 0.8732, 0.5743, 0.1091, 0.0381}
    };

    public void initialize() {
        int i;
        for (i = 0; i < size; i++) {
            _max[i] = 1;
            _min[i] = 0;
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

    public H6() throws Exception {
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new H6();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        double sum = 0;
        int i;
        int j;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 6; j++) {
                sum += aij[i][j] * Math.sqrt(x[j] - pij[i][j]);
            }
            eval += -ci[i] * Math.exp(-sum);
        }
        ((Cod) codif).setFitness(eval);
    }
}