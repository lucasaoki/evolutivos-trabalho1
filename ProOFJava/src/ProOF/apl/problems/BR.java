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
        _max = new double[size];
        _min = new double[size];
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

    public int getSize() {
        return size;
    }

    public BR() throws Exception {
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
            eval += 100 * Math.pow(x[i + 1] - Math.pow(x[i], 2), 2) + Math.pow(x[i] - 1, 2);
        }
        ((Cod) codif).setHistF(((Cod) codif).getFitness());
        ((Cod) codif).setFitness(eval);
    }
}
