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
public class LM2 extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;
    private int size = 10;

    public void initialize() {
        _max = new double[size];
        _min = new double[size];
        int i;
        for (i = 0; i < size; i++) {
            _max[i] = 5;
            _min[i] = -5;
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

    public LM2() throws Exception {
        initialize();
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new LM2();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double sum = 0;
        double eval = 0;
        int i;
        for (i = 0; i < size - 1; i++) {
            sum += (Math.pow(x[i] - 1, 2) * (1 + Math.pow(Math.sin(3 * Math.PI * x[i + 1]), 2)));
        }
        eval = 0.1 * (Math.pow(Math.sin(3 * Math.PI * x[0]), 2) + sum + Math.pow(x[size - 1] - 1, 2) * (Math.pow(Math.sin(2 * Math.PI * x[size - 1]), 2)));

        ((Cod) codif).setHistF(((Cod) codif).getFitness());
        ((Cod) codif).setFitness(eval);
    }
}
