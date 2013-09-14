/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.gen.operator.oCrossover;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author Luke
 */
public class Cross extends oCrossover {

    @Override
    public Codification crossover(Problem mem, Codification ind1, Codification ind2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String name() {
        return "Cross";
    }
    
}
