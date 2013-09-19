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
public class MR extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max = 10;
    private double _min = -10;
    private double[] ti = {1.0, 2.0, 1.0, 2.0, 0.1};
    private double[] vi = {1.0, 1.0, 2.0, 2.0, 0.0};
    private double[] yi = {0.126, 0.219, 0.076, 0.126, 0.186};

    public MR() throws Exception {
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new MR();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        int i;

        for (i = 0; i < 5; i++) {
            eval += Math.sqrt((x[0] * x[2] * ti[i]) / (1 + x[0] * ti[i] + x[1] * vi[i]) - yi[i]);
        }
        ((Cod) codif).setFitness(eval);
    }
}
