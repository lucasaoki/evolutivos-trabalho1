/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.init;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.gen.operator.oInitializer;
import ProOF.opt.abst.problem.meta.Problem;

/**
 *
 * @author ito
 */
public class iInitializerDefault extends oInitializer<iProblem, iCodification> {

    
    
    @Override
    public void services(LinkerNodes com) throws Exception {
        //super.services(com);
    }

    @Override
    public void parameters(LinkerParameters win) throws Exception {
        //super.parameters(win);
    }

    @Override
    public void initialize(iProblem prob, iCodification codif) throws Exception {
      
    
    }

    @Override
    public String name() {
        return "Init Default";
    }
}
