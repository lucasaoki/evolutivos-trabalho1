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

        double radius = 0.2;
        double limitup = 1 + radius;
        double limitdown = 1 - radius;

        for (int i = 0; i < ind.getSize(); i++) {
            double rand = Math.random();
            if (rand < 0.8) {
                if ((1 - radius) * ind.getIndVal(i) < mem.getIFunc().getMin(i)) {
                    radius = Math.abs(ind.getIndVal(i) - mem.getIFunc().getMin(i)) / ind.getIndVal(i);
                    limitdown = 1 - radius;
                }
                if ((1 + radius) * ind.getIndVal(i) > mem.getIFunc().getMax(i)) {
                    radius = Math.abs(-ind.getIndVal(i) + mem.getIFunc().getMax(i)) / ind.getIndVal(i);
                    limitup = 1 + radius;
                }
                ind.setIndVal(ind.getIndVal(i) * limitdown + (Math.random() * (ind.getIndVal(i) * limitup - ind.getIndVal(i) * limitdown)), i);
            }
        }

    }

    @Override
    public String name() {
        return "Mut Large Range";
    }
}
