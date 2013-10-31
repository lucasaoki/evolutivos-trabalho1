/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover;

import ProOF.com.language.Factory;

/**
 *
 * @author ito
 */
public class fCrossoverProvider extends Factory<aCrossoverProvider> {

    public static final fCrossoverProvider obj = new fCrossoverProvider();

    @Override
    public String name() {
	return "CrossoverProvider Factory";
    }

    @Override
    public aCrossoverProvider NewNode(int index) {
	switch (index) {
	    case 0:
		return new iCrossoverProviderDefault();
	}
	return null;
    }
}
