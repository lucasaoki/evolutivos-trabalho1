/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.gen.operator.oMutation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ito
 */
public class iMutationInv extends oMutation<iProblem, iCodification> {

    @Override
    public void mutation(iProblem mem, iCodification ind) throws Exception {
	List<Double> tmp = Arrays.asList(ind.getInd());
	Collections.reverse(tmp);
	ind.setInd((Double[]) tmp.toArray());
    }

    @Override
    public String name() {
	return "Mut Inv";
    }
}
