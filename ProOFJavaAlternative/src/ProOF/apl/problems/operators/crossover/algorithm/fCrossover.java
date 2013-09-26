/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover.algorithm;

import ProOF.com.language.Factory;
import ProOF.gen.operator.oCrossover;

/**
 *
 * @author ito
 */
public class fCrossover extends Factory<oCrossover> {

    public static final fCrossover obj = new fCrossover();

    @Override
    public String name() {
        return "Crossover Operator Factory";
    }

    @Override
    public oCrossover NewNode(int index) {
        switch (index) {
            case 0:
                return new iCrossAvg();
            case 1:
                return new iCrossHalf();
            case 2:
                return new iCrossIntercalation();
            case 3:
                return new iCrossRandomChoice();
            case 4:
                return new iCrossArithmetic();
            case 5:
                return new iCrossGeometric();
            case 6:
                return new iCrossLinear();
        }
        return null;
    }
}
