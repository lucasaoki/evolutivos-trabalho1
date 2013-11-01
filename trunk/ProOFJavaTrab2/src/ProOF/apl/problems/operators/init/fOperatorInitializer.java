/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.init;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.com.language.Factory;
import ProOF.gen.operator.oInitializer;

/**
 *
 * @author ito
 */
public class fOperatorInitializer extends Factory<oInitializer<iProblem, iCodification>> {

    public static final fOperatorInitializer obj = new fOperatorInitializer();

    @Override
    public String name() {
	return "Initializer Operator Factory";
    }

    @Override
    public oInitializer NewNode(int index) {
	switch (index) {
	    case 0:
		return new iInitializerDefault();
	}
	return null;
    }
}
