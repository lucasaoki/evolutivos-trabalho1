/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation;

import ProOF.com.language.Factory;

/**
 *
 * @author ito
 */
public class fMutationProvider extends Factory<aMutationProvider> {

    public static final fMutationProvider obj = new fMutationProvider();

    @Override
    public String name() {
	return "MutationProvider Factory";
    }

    @Override
    public aMutationProvider NewNode(int index) {
	switch (index) {
//	    case 0:
//		return new iMutationProviderDefault();
            case 0:
                return new iMutationProviderAdaptative();
	}
	return null;
    }
}
