/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.gen.operator.oInitializer;

/**
 *
 * @author Luke
 */
public class Init extends oInitializer<Prob, Cod> {

    @Override
    public void initialize(Prob mem, Cod ind) throws Exception {
        for (int i = 0; i < ((Cod) ind).getSize(); i++) {
            ((Cod) ind).setIndVal(((Prob) mem).getIfunction().getMin(i) + (Math.random() * ((((Prob) mem).getIfunction().getMax(i)) - ((Prob) mem).getIfunction().getMin(i))), i);
        }
    }

    @Override
    public String name() {
        return "Init";
    }
}
