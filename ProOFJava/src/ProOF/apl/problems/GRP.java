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
public class GRP extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;
    private int size = 99;

    public void initialize() {
        _max[0] = 100;
        _max[1] = 25.6;
        _max[2] = 5;
        _min[0] = 0.1;
        _min[1] = 0;
        _min[2] = 0;
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

    public GRP() throws Exception {
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new GRP();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        double eval = 0;
        double ui;
        int i;
        for (i = 0; i < size; i++) {
            ui = 25 + Math.pow(-50 * Math.log(0.01 * (i + 1)), 2 / 3);
            eval += Math.sqrt(Math.exp(-Math.pow(ui - x[1], x[2]) / x[0]) - 0.01 * (i + 1));
        }
        ((Cod) codif).setFitness(eval);
    }
}
