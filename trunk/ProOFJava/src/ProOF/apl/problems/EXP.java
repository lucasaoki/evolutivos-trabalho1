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
public class EXP extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;
    private int size = 10;

    public void initialize() {
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

    public EXP() throws Exception {
        //this._max = 1;
        //this._min = -1;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new EXP();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double sum = 0;
        double eval;
        int i;

        for (i = 0; i < size; i++) {
            sum += Math.sqrt(x[i]);
        }
        eval = -Math.exp(-0.5 * sum);
        ((Cod) codif).setFitness(eval);
    }
}
