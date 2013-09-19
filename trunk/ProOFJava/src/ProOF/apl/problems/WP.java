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
public class WP extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max = 10;
    private double _min = -10;

    public WP() throws Exception {
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new WP();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        eval = 100 * Math.sqrt(x[1] - Math.sqrt(x[0])) + Math.sqrt(1 - x[0]) + 90 * Math.sqrt(x[3] - Math.sqrt(x[2])) + Math.sqrt(1 - x[2]);
        eval += 10.1 * Math.sqrt(x[1] - 1) + Math.sqrt(x[3] - 1) + 19.8 * (x[1] - 1) * (x[3] - 1);
        ((Cod) codif).setFitness(eval);
    }
}
