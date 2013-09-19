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
public class ACK extends SingleObjective<Problem, Codification, SingleObjective> {

    private double[] _max;
    private double[] _min;

    public void initialize() {
        _max[0] = 30;
        _min[0] = -30;
    }

    public double[] getMin() {
        return _min;
    }

    public double[] getMax() {
        return _max;
    }

    public ACK() throws Exception {
        initialize();
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new ACK();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] x = ((Cod) codif).getInd();
        int size = ((Cod) codif).getSize();
        double sum1 = 0;
        double sum2 = 0;
        double eval = 0;
        int i = 0;

        for (i = 0; i < size; i++) {
            sum1 += Math.sqrt(x[i]);
            sum2 += Math.cos(2 * Math.PI * x[i]);
        }
        eval = -20.0 * Math.exp(-0.02 * Math.sqrt(sum1 / size)) - Math.exp(sum2 / size) + 20 + Math.E;
        ((Cod) codif).setFitness(eval);
    }
}
