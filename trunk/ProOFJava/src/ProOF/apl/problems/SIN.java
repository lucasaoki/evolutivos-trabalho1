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
public class SIN extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;
    private int size = 20;

    public void initialize() {
        _max = new double[size];
        _min = new double[size];
        int i;
        for (i = 0; i < size; i++) {
            _max[i] = 0;
            _min[i] = 180;
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

    public SIN() throws Exception {
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new SIN();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        double A = 2.5;
        double B = 5;
        double z = 30;
        double prod1 = 0;
        double prod2 = 0;
        int i;
        for (i = 0; i < size; i++) {
            prod1 *= Math.sin(x[i] - z);
            prod2 *= Math.sin(B * (x[i] - z));
        }
        eval = -(A * prod1 + prod2);
    }
}
