/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.gen.operator.oInitializer;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;
import java.util.Random;

/**
 *
 * @author Luke
 */
public class Init extends oInitializer {

    @Override
    public void initialize(Problem mem, Codification ind) throws Exception {
        for (int i = 0; i < ((Cod) ind).getSize(); i++) {
            ((Cod) ind).setIndVal(Math.random(), i);
        }
    }

    @Override
    public String name() {
        return "Init";
    }
}
