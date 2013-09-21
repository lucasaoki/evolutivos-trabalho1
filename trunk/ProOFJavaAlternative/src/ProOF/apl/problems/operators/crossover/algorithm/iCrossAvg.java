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
	iCodification codNew = ind1.New(mem);

	for (int c = 0; c < mem.getIFunc().getSize(); c++) {
	    codNew.setIndVal((ind1.getIndVal(c) + ind2.getIndVal(c)) / 2, c);
	}
	return codNew;
    }

    @Override
    public String name() {
	return "CrossAVG";
    }
}
