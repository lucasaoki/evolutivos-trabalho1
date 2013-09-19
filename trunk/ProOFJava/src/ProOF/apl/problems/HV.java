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
public class HV extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max = 10;
    private double _min = -10;

    public HV() throws Exception {
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new HV();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval;
        double teta;
        if (x[0] < 0) {
            teta = 1 / (Math.PI * 2) * Math.pow(Math.tan(x[1] / x[0]) + 1 / 2, -1);
        } else {
            teta = 1 / (Math.PI * 2) * Math.pow(Math.tan(x[1] / x[0]), -1);
        }


        eval = 100 * (Math.sqrt(x[1] - 10 * teta) + (Math.pow(Math.sqrt(x[0]) + Math.sqrt(x[1]) - 1, 1 / 2))) + Math.sqrt(x[2]);
        ((Cod) codif).setFitness(eval);
    }
}
