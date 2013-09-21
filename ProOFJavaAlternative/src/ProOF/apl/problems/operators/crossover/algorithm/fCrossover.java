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
	}
	return null;
    }
}
