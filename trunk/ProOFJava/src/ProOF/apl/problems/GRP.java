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
public class GRP extends SingleObjective<Problem, Codification, SingleObjective>{
    private double _max;
    private double _min;
    
    public GRP()throws Exception{
        //this._max = 100;
        //this._min = 0.1;
        //this._max = 0;
        //this._min = 25.6;

    }
 
    public double getMax(){
        return _max;
    }
    
    public double getMin(){
        return _min;
    }
    
    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new GRP();
    }
    
    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] tmp = ((Cod) codif).getInd();
        double eval = 0;
        double u;
        int i;
        for(i=0;i<99;i++){
            u = 25+Math.pow(-50*Math.log(0.01*(i+1)),2/3);
            eval += Math.sqrt(Math.exp(-Math.pow(u-tmp[2],tmp[3])/tmp[1])-0.01*(i+1));
        }
        ((Cod) codif).setFitness(eval);
    } 
}
