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
        //Cada elemento do vetor tem chance de alterar seu valor
        int idx = 0 + (int) (Math.random() * (10 + 0));

        switch (idx) {
            case 0: {
                for (int i = 0; i < 10; i++) {
                    int rand = 0 + (int) (Math.random() * (1 + 1));

                }
            }
        }

        //  mudar de posicao de algum elemento do vetor
        //inverter o vetor
    }

    @Override
    public String name() {
        return "Mut";
    }
}
