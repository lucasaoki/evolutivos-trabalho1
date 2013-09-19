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
public class GP extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max;
    private double _min;

    public GP() throws Exception {
        //this._max = 2;
        //this._min = -2;
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new GP();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;

        eval = 1 + Math.sqrt(x[0] + x[1] + 1) * (19 - 14 * x[0] + 3 * Math.sqrt(x[0]) - 14 * x[1] + 6 * x[0] * x[1] + 3 * Math.sqrt(x[1]));
        eval *= 30 + Math.sqrt(2 * x[0] - 3 * x[1]) * (18 - 32 * x[0] + 12 * Math.sqrt(x[0]) + 48 * x[1] - 36 * x[0] * x[1] + 27 * Math.sqrt(x[1]));

        ((Cod) codif).setFitness(eval);
    }
}
