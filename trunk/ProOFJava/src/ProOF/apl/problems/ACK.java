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

    private double max;
    private double min;

    public ACK() throws Exception {
        this.max = 30;
        this.min = -30;
    }

    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new ACK();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] tmp = ((Cod) codif).getInd();
        double sum1 = 0;
        double sum2 = 0;
        double eval = 0;
        int x = 0;
        int size = ((Cod) codif).getSize();
        
        for(x = 0 ; x < size ; x++){
            sum1 += Math.sqrt(tmp[x]);
            sum2 += Math.cos(2*Math.PI*tmp[x]);
        }
        eval = -20.0*Math.exp(-0.02*Math.sqrt(sum1/size)) - Math.exp(sum2/size) + 20 + Math.E;
        ((Cod) codif).setFitness(eval);
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}



