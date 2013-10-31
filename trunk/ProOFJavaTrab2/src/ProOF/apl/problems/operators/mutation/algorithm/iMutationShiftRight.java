/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.apl.problems.functions.aMaze;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.gen.operator.oMutation;

/**
 *
 * @author Seiji
 */
public class iMutationShiftRight extends oMutation<iProblem, iCodification> {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
        aMaze ifunction = mem.getIFunc();
        for (int i = 0; i < ind.getSize(); i++) {
            double value = ind.getIndVal(i);
            double max = ifunction.getMax(i);
            double min = ifunction.getMin(i);
            double per = 0.01;
            if (value - min < max - value) {
                if (value - min < (max - min) / 8) {
                    per += 0.99;
                }
                if (Math.random() < 0.4) {
                    ind.setIndVal(value - (value - min) * Math.random() * per, i);
                } else {
                    ind.setIndVal(value + (value - min) * Math.random() * per, i);
                }
            } else {
                if (max - value < (max - min) / 8) {
                    per += 0.99;
                }
                if (Math.random() < 0.4) {
                    ind.setIndVal(value + (max - value) * Math.random() * per, i);
                } else {
                    ind.setIndVal(value - (max - value) * Math.random() * per, i);
                }

            }
        }
    }

    @Override
    public String name() {
        return "Mut Shift Left";
    }
}