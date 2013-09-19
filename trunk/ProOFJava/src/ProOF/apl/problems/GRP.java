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

    private double[] _max = {100, 25.6, 5};
    private double[] _min = {0.1, 0, 0};

    public GRP() throws Exception {
        //this._max = 100;
        //this._min = 0.1;
        //this._max = 0;
        //this._min = 25.6;
    }

//    public double getMax() {
//        return _max;
//    }
//
//    public double getMin() {
//        return _min;
//    }
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
        for (i = 0; i < 99; i++) {
            ui = 25 + Math.pow(-50 * Math.log(0.01 * (i + 1)), 2 / 3);
            eval += Math.sqrt(Math.exp(-Math.pow(ui - x[1], x[2]) / x[0]) - 0.01 * (i + 1));
        }
        ((Cod) codif).setFitness(eval);
    }
}
