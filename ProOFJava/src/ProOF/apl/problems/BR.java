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

    private double[] _max;
    private double[] _min;
    private int size = 10;

    public void initialize() {
        int i;
        for (i = 0; i < size; i++) {
            _max[i] = 30;
            _min[i] = -30;
        }
    }

    public double getMin(int n) {
        return _min[n];
    }

    public double getMax(int n) {
        return _max[n];
    }

    public BR() throws Exception {
        //this._max = 30;
        //this._min = -30;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new BR();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        int i;
        for (i = 0; i < size - 1; i++) {
            eval += 100 * Math.sqrt(x[i + 1] - Math.sqrt(x[i]) + Math.sqrt(x[i] - 1));
        }
        ((Cod) codif).setFitness(eval);
    }
}
