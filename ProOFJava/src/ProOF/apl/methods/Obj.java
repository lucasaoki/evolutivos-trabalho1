/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.opt.abst.problem.meta.objective.SingleObjective;

/**
 *
 * @author Luke
 */
public class Obj extends SingleObjective<Prob, Cod, Obj> {

    private double eval;

    public Obj() throws Exception {
    }

    @Override
    public Obj New(Prob prob) throws Exception {
	return new Obj();
    }

    @Override
    public void Evaluate(Prob prob, Cod codif) throws Exception {
	double[] tmp = codif.getInd();
	eval = Math.pow(tmp[0], 2);
	codif.setFitness(eval);
    }
}
