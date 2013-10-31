/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods.GA.algorithm;

import ProOF.com.language.Factory;

/**
 *
 * @author ito
 */
public class fGA extends Factory<aGA> {

    public static final fGA obj = new fGA();

    @Override
    public String name() {
	return "GAAlgorithm Factory";
    }

    @Override
    public aGA NewNode(int index) {
	switch (index) {
	    case 0:
		return new iGADefault();
	}
	return null;
    }
}
