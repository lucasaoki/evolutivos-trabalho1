/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation.algorithm;

import ProOF.com.language.Factory;
import ProOF.gen.operator.oMutation;

/**
 *
 * @author ito
 */
public class fMutation extends Factory<oMutation> {

    public static final fMutation obj = new fMutation();

    @Override
    public String name() {
        return "Mutation Operator Factory";
    }

    @Override
    public oMutation NewNode(int index) {
        switch (index) {
            case 0:
                return null;
//            case 1:
//                return new iMutationSwapChance();
//            case 2:
//                return new iMutationShiftRight();
//            case 4:
//                return new iMutationChangePosition();
//            case 5:
//                return new iMutationInv();
        }
        return null;
    }
}
