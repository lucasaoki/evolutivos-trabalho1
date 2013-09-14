/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;
import ProOF.opt.abst.problem.meta.objective.SingleObjective;


/**
 *
 * @author Luke
 */
public class Obj extends SingleObjective<Problem, Codification, SingleObjective> {

    private double eval;
    
    public Obj() throws Exception {
    }
    
    @Override
    public SingleObjective New(Problem prob) throws Exception {
        return new Obj();
    }

    @Override
    public void Evaluate(Problem prob, Codification codif) throws Exception {
        double[] tmp = ((Cod)codif).getInd();
        eval = Math.pow( tmp[0], 2);
        ((Cod)codif).setFitness(eval);
    }

    
}
