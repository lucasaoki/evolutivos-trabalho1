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

        int idx = 0 + (int) (Math.random() * (2 + 1));

        switch (idx) {
            //Cada elemento do vetor tem chance de alterar seu valor
            case 0: {
                for (int i = 0; i < 10; i++) {
                    double rand = Math.random();
                    if (rand < 0.99) {
                        ((Cod) ind).setIndVal(((Prob) mem).ob.getMin(i) + (Math.random() * ((((Prob) mem).ob.getMax(i)) - ((Prob) mem).ob.getMin(i))), i);
                    }
                }
            }
            //  mudar de posicao de algum elemento do vetor
            case 1: {
                int p1 = 0 + (int) (Math.random() * (((Cod) ind).getSize() + 0));
                int p2 = 0 + (int) (Math.random() * (((Cod) ind).getSize() + 0));

                double tmp = ((Cod) ind).getIndVal(p1);
                ((Cod) ind).setIndVal(((Cod) ind).getIndVal(p2), p1);
                ((Cod) ind).setIndVal(tmp, p2);
            }
            //inverter o vetor
            case 2: {
                int p1 = 0;
                int p2 = ((Cod) ind).getSize() - 1;

                double tmp;

                for (int i = 0; i < ((Cod) ind).getSize() / 2; i++) {
                    tmp = ((Cod) ind).getIndVal(p1);
                    ((Cod) ind).setIndVal(((Cod) ind).getIndVal(p2), p1);
                    ((Cod) ind).setIndVal(tmp, p2);
                    p1++;
                    p2--;
                }

            }
        }



    }

    @Override
    public String name() {
        return "Mut";
    }
}
