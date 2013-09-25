/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators;

import ProOF.apl.problems.operators.crossover.algorithm.iCrossAvg;
import ProOF.apl.problems.operators.init.iInitializerDefault;
import ProOF.apl.problems.operators.mutation.algorithm.iMutationInv;
import ProOF.com.language.Factory;
import ProOF.opt.abst.problem.meta.codification.Operator;

/**
 *
 * @author marcio
 */
public class fRealOperator extends Factory<Operator> {

    public static final fRealOperator obj = new fRealOperator();

    @Override
    public String name() {
	return "Operator Factory";
    }

    @Override
    public Operator NewNode(int index) {
	switch (index) {
	    /*DO NOT USE HERE!!!*/
//	    case 0:
//		return new iInitializerDefault();
//	    case 1:
//		return new iCrossAvg();
//	    case 2:
//		return new iMutationInv();
//           case  0: return new iRealCrossAvg();
//            case  1: return new iRealCrossOX();
//            case  2: return new iRealCrossBLX();
//            case  3: return new iRealCrossHeur();
//
//            case  4: return new iRealMutReplace();
//            case  5: return new iRealMutLimit();
//            case  6: return new iRealMutInvert();
//
//            case  7: return new iRealMovReplace();
//            case  8: return new iRealMovLimit();
//            case  9: return new iRealMovInvert();
//
//            case 10: return new iRealInitRandom();
	}
	return null;
    }
}
