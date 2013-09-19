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
public class BR extends SingleObjective<Problem, Codification, SingleObjective> {

    private double _max;
    private double _min;

    public BR() throws Exception {
        //this._max = 30;
        //this._min = -30;
    }

    public double getMax() {
        return _max;
    }

    public double getMin() {
        return _min;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new BR();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        int size = ((Cod) codif).getSize();
        double eval = 0;
        int i;
        for (i = 0; i < size - 1; i++) {
            eval += 100 * Math.sqrt(x[i + 1] - Math.sqrt(x[i]) + Math.sqrt(x[i] - 1));
        }
        ((Cod) codif).setFitness(eval);
    }
}
