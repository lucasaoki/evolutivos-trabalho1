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
 * @author ito
 */
public class iCrossAvg extends oCrossover<iProblem, iCodification> {

    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {
        iCodification child = ind1.New(mem);

        for (int i = 0; i < mem.getIFunc().getSize(); i++) {
            child.setIndVal((ind1.getIndVal(i) + ind2.getIndVal(i)) / 2, i);
        }
        return child;
    }

    @Override
    public String name() {
        return "CrossAVG";
    }
}
