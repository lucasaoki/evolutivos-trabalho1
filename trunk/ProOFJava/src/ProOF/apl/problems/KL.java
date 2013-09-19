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
public class KL extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max = 0.42;
    private double _min = 0;
    private double[] ai = {0.1957, 0.1947, 0.1735, 0.16, 0.0844, 0.0627, 0.0456, 0.0342, 0.0323, 0.0235, 0.0246};
    private double[] bi = {0.25, 0.50, 1.0, 2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0};

    public KL() throws Exception {
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new KL();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        int i;
        for (i = 0; i < 11; i++) {
            eval += Math.sqrt(ai[i] - x[0] * (1 + x[1] * bi[i]) / (1 + x[2] * bi[i] + x[3] * Math.sqrt(bi[i])));
        }
        ((Cod) codif).setFitness(eval);
    }
}
