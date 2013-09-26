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
                return new iMutationInv();
            case 1:
                return new iMutationRange();
            case 2:
                return new iMutationChangePosition();
            case 3:
                return new iMutationSwapChance();
        }
        return null;
    }
}
