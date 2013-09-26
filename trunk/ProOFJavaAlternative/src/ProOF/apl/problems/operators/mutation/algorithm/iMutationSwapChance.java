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
public class iMutationSwapChance extends oMutation<iProblem, iCodification> {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
        for (int i = 0; i < ind.getSize(); i++) {
            double rand = Math.random();
            if (rand < 0.6) {
                int p1 = i;
                int p2 = 0 + (int) (Math.random() * (ind.getSize() + 0));
                if (!(ind.getIndVal(p1) < mem.getIFunc().getMin(p2) || ind.getIndVal(p1) > mem.getIFunc().getMax(p2))
                        && !(ind.getIndVal(p2) < mem.getIFunc().getMin(p1) || ind.getIndVal(p2) > mem.getIFunc().getMax(p1))) {

                    double tmp = ind.getIndVal(p1);
                    ind.setIndVal(ind.getIndVal(p2), p1);
                    ind.setIndVal(tmp, p2);
                }
            }
        }
    }

    @Override
    public String name() {
        return "Mut Swap Chance";
    }
}
