/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.gen.operator.oMutation;

/**
 *
 * @author Lucas
 */
public class iMutationChangePosition extends oMutation<iProblem, iCodification> {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
        int p1 = 0 + (int) (Math.random() * (ind.getSize() + 0));
        int p2 = 0 + (int) (Math.random() * (ind.getSize() + 0));

        double tmp = ind.getIndVal(p1);
        ind.setIndVal(ind.getIndVal(p2), p1);
        ind.setIndVal(tmp, p2);
    }

    @Override
    public String name() {
        return "Mut ChangePosition";
    }
}
