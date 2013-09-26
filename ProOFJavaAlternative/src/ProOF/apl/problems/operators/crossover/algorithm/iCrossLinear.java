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
public class iCrossLinear extends oCrossover<iProblem, iCodification> {

    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {
        iCodification child = ind1.New(mem);

        switch (mem.rmd.nextInt(3)) {
            case 0:
                for (int i = 0; i < mem.getIFunc().getSize(); i++) {
                    child.setIndVal((ind1.getIndVal(i) + ind2.getIndVal(i)) / 2, i);
                }
                break;
            case 1:
                for (int i = 0; i < mem.getIFunc().getSize(); i++) {
                    child.setIndVal(1.5 * ind1.getIndVal(i) - 0.5 * ind2.getIndVal(i), i);
                }
                break;
            case 2:
                for (int i = 0; i < mem.getIFunc().getSize(); i++) {
                    child.setIndVal(-0.5 * ind1.getIndVal(i) + 1.5 * ind2.getIndVal(i), i);
                }
                break;
        }
        return child;
    }

    @Override
    public String name() {
        return "CrossLinear";
    }
}
