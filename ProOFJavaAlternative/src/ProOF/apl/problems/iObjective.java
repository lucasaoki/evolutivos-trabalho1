/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.opt.abst.problem.meta.objective.SingleObjective;

/**
 *
 * @author ito
 */
public class iObjective extends SingleObjective<iProblem, iCodification, iObjective> {

    public iObjective() throws Exception {
	//TODO: verificar limites aqui
	//super(new BoundDbl(-1e9, 1e9, 1e-9));
    }

    @Override
    public void Evaluate(iProblem prob, iCodification codif) throws Exception {
	set(prob.getIFunc().Evaluate(codif));
    }

    @Override
    public iObjective New(iProblem prob) throws Exception {
	return new iObjective();
    }
}
