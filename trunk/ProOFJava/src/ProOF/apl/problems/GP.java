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
public class GP extends SingleObjective<Problem, Codification, SingleObjective>{
    private double _max;
    private double _min;
    
    public GP()throws Exception{
        //this._max = 2;
        //this._min = -2;
    }
 
    public double getMax(){
        return _max;
    }
    
    public double getMin(){
        return _min;
    }
    
    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new GP();
    }
    
    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] tmp = ((Cod) codif).getInd();
        double x1 = tmp[0];
        double x2 = tmp[1];
        double eval = 0;
        int size = ((Cod) codif).getSize();
        
        eval = 1 + Math.sqrt(x1+x2+1)*(19-14*x1+3*Math.sqrt(x1)-14*x2+6*x1*x2+3*Math.sqrt(x2));
        eval *= 30 + Math.sqrt(2*x1-3*x2)*(18-32*x1+12*Math.sqrt(x1)+48*x2-36*x1*x2+27*Math.sqrt(x2));
     
        ((Cod) codif).setFitness(eval);
    } 
}
