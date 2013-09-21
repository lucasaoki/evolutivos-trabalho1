package ProOF.apl.factorys;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import ProOF.apl.problems.iProblem;
import ProOF.com.language.Factory;
import ProOF.opt.abst.problem.meta.Problem;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcio
 */
public final class fProblem extends Factory<Problem> {

    public static final fProblem obj = new fProblem();

    @Override
    public String name() {
	return "Problem Factory";
    }

    @Override
    public Problem NewNode(int index) {
	switch (index) {
	    case 0:
		try {
		    return new iProblem();
		} catch (Exception ex) {
		    Logger.getLogger(fProblem.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	return null;
    }
}
