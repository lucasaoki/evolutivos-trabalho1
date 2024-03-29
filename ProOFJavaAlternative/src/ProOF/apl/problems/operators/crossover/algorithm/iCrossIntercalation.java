/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.gen.operator.oCrossover;

/**
 *
 * @author Lucas
 */
public class iCrossIntercalation extends oCrossover<iProblem, iCodification> {

    /**
     * Intercalação
     *
     * @param mem
     * @param ind1
     * @param ind2
     * @return
     * @throws Exception
     */
    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {
        iCodification child = ind1.New(mem);

        for (int i = 0; i < child.getSize(); i++) {
            /* Intercalando */
            if (i % 2 == 0) {
                child.setIndVal(ind1.getIndVal(i), i);
            } else {
                child.setIndVal(ind2.getIndVal(i), i);
            }
        }

        return child;
    }

    @Override
    public String name() {
        return "CrossIntercalation";
    }
}
