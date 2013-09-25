/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.gen.operator.oMutation;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author ito
 */
public class iMutationInv extends oMutation<iProblem, iCodification> {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
	System.out.print("\nBEFORE:\n");
	for (double d : ind.getInd()) {
	    System.out.print(Double.toString(d) + " ");
	}

	ArrayUtils.reverse(ind.getInd());
	System.out.print("\nAFTER:\n");
	for (double d : ind.getInd()) {
	    System.out.print(Double.toString(d) + " ");
	}
    }

    @Override
    public String name() {
	return "Mut Inv";
    }
}
