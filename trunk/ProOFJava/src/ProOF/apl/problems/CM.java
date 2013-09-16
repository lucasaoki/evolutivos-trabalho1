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
public class CM extends SingleObjective<Problem, Codification, SingleObjective>{
    private double _max[];
    private double _min[];
    
    public CM()throws Exception{
        //this._max = 1;
        //this._min = -1;
    }
 
    public double getMax(){
        return _max[0];
    }
    
    public double getMin(){
        return _min[0];
    }
    
    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new CM();
    }
    
    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] tmp = ((Cod) codif).getInd();
        double sum1 = 0;
        double sum2 = 0;
        double eval = 0;
        int i = 0;
        int size = ((Cod) codif).getSize();

        for(i = 0 ; i < size ; i++){
            sum1 += Math.cos(5*Math.PI*tmp[i]);
            sum2 += Math.sqrt(tmp[i]);
        }
        eval = 0.1*sum1 - sum2;
        ((Cod) codif).setFitness(eval);
    } 
}
