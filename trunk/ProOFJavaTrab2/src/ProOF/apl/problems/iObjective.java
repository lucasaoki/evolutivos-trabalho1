/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.com.StreamPrinter;
import ProOF.gen.operator.oCrossover;
import ProOF.gen.operator.oMutation;
import ProOF.opt.abst.problem.meta.objective.BoundDbl;
import ProOF.opt.abst.problem.meta.objective.SingleObjective;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ito
 */
public class iObjective extends SingleObjective<iProblem, iCodification, iObjective> {

    protected double eval_count;
    protected List<oCrossover> cross_hist;
    protected List<oMutation> mut_hist;

    public iObjective() throws Exception {
	super(new BoundDbl(-1e9, 1e9, 1e-9));

	eval_count = 0;
	cross_hist = new ArrayList<>();
	mut_hist = new ArrayList<>();
    }

    @Override
    public void Evaluate(iProblem prob, iCodification codif) throws Exception {
	set(prob.getIMaze().Evaluate(codif));
	eval_count++;
    }

    @Override
    public iObjective New(iProblem prob) throws Exception {
	return new iObjective();
    }

    @Override
    public void printer(iProblem prob, StreamPrinter com) throws Exception {
	//super.printer(prob, com); //To change body of generated methods, choose Tools | Templates.
    }
}
