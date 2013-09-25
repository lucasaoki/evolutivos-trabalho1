/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.crossover.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.gen.operator.oCrossover;

/**
 *
 * @author Lucas
 */
public class iCrossRandomChoice extends oCrossover<iProblem, iCodification> {

    /**
     * Método de escolha de gene aleatório
     * 
     * @param mem
     * @param ind1
     * @param ind2
     * @return
     * @throws Exception 
     */
    @Override
    public iCodification crossover(iProblem mem, iCodification ind1, iCodification ind2) throws Exception {
	iCodification codNew = ind1.New(mem);

        double tmp;
	for (int i = 0; i < codNew.getSize(); i++) {
            /* Aleatório */
            tmp = Math.random();
            if (tmp < 0.5) {
                codNew.setIndVal(ind1.getIndVal(i), i);
            } else {
                codNew.setIndVal(ind2.getIndVal(i), i);
            }
        }
        
	return codNew;
    }

    @Override
    public String name() {
	return "CrossRandomChoice";
    }
}
