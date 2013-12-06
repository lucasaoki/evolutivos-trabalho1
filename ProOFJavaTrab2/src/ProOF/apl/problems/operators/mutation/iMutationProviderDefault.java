/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.opt.abst.problem.meta.Solution;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ito
 */
public class iMutationProviderDefault extends aMutationProvider {

    @Override
    public Solution<iProblem, iObjective, iCodification, Solution> runMutation(Solution<iProblem, iObjective, iCodification, Solution> s1) {
	try {
	    Random rnd = new Random(System.currentTimeMillis());
	    if (mutationList.length != 0) {
		if (Math.random() <= mutationRate) {
                    int index = rnd.nextInt(mutationList.length);
                    
                    for (int c = 0; c < 10; c++)
                    mutationList[0].mutation(problemNode, s1.codif());
                    
                    index = 1;
		    mutationList[index].mutation(problemNode, s1.codif());
		}
	    } else {
		System.out.println("Critical Error: Empty Mutation List.");
		return s1;
	    }
	} catch (Exception ex) {
	    Logger.getLogger(iMutationProviderDefault.class.getName()).log(Level.SEVERE, null, ex);
	}
	return s1;
    }

    @Override
    public String name() {
	return "MutationProvider Default";
    }

    @Override
    public String description() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
