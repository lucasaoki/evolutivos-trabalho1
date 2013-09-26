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
 * @author Luke
 */
public class iMutationLargeRange extends oMutation<iProblem, iCodification> {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {

        for (int i = 0; i < ind.getSize(); i++) {
            double rand = Math.random();
            if (rand < 0.8) {
                ind.setIndVal(ind.getIndVal(i) * 0.9 + (Math.random() * (ind.getIndVal(i) * 1.1 - ind.getIndVal(i) * 0.9)), i);
            }
        }

    }

    @Override
    public String name() {
        return "Mut Large Range";
    }
}
