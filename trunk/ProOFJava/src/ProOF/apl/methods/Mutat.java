/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.gen.operator.oMutation;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author Luke
 */
public class Mutat extends oMutation {

    @Override
    public void mutation(Problem mem, Codification ind) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String name() {
        return "Mut";
    }
    
}
