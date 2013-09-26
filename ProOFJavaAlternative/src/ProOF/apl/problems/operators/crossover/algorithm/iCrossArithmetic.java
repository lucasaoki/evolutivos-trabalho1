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
public class iCrossArithmetic extends oCrossover<iProblem, iCodification> {

    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {
        iCodification child = ind1.New(mem);

        for (int i = 0; i < mem.getIFunc().getSize(); i++) {
            double tmp = mem.rmd.nextDouble();
            child.setIndVal(tmp * ind1.getIndVal(i) + (1 - tmp) * ind2.getIndVal(i), i);
        }
        return child;
    }

    @Override
    public String name() {
        return "CrossArithmetic";
    }
}
