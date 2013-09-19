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
public class EXP extends SingleObjective<Problem, Codification, SingleObjective>{
    private double _max;
    private double _min;
    
    public EXP()throws Exception{
        //this._max = 1;
        //this._min = -1;
    }
 
    public double getMax(){
        return _max;
    }
    
    public double getMin(){
        return _min;
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
        int size = ((Cod) codif).getSize();

        for(i = 0 ; i < size ; i++){
            sum += Math.sqrt(x[i]);
        }
        eval = Math.exp(-0.5*sum);
        ((Cod) codif).setFitness(eval);
    } 
}
