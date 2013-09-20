/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.gen.operator.oMutation;

/**
 *
 * @author Luke
 */
public class Mutat extends oMutation<Prob, Cod> {

    @Override
    public void mutation(Prob mem, Cod ind) throws Exception {

        int idx = 0 + (int) (Math.random() * (2 + 0));

        switch (1) {
            //Cada elemento do vetor tem chance de alterar seu valor
            case 0: {
                for (int i = 0; i < ((Cod) ind).getSize(); i++) {
                    double rand = Math.random();
                    if (rand < 0.99) {
                        ((Cod) ind).setIndVal(((Prob) mem).getIfunction().getMin(i) + (Math.random() * ((((Prob) mem).getIfunction().getMax(i)) - ((Prob) mem).getIfunction().getMin(i))), i);
                    }
                }
            }
            case 1: {
                for (int i = 0; i < ((Cod) ind).getSize(); i++) {
                    double random = Math.random();
                    if (((Cod) ind).getHistE(i) == 0) {
                        if ((random + 0.5) > 1) {
                            ((Cod) ind).setIndVal(((Cod) ind).getIndVal(i) + (((Prob) mem).getIfunction().getMax(i) - ((Cod) ind).getIndVal(i)) * Math.random(), i);
                            ((Cod) ind).setHistE(((Cod) ind).getHistE(i) + 1, i);
                        } else {
                            ((Cod) ind).setIndVal(((Cod) ind).getIndVal(i) - (((Cod) ind).getIndVal(i) - ((Prob) mem).getIfunction().getMin(i)) * Math.random(), i);
                            ((Cod) ind).setHistE(((Cod) ind).getHistE(i) - 1, i);
                        }
                    } else {
                        if (((Cod) ind).getHistE(i) < 0 && ((Cod) ind).getHistF() < ((Cod) ind).getFitness()) {
                            ((Cod) ind).setIndVal(((Cod) ind).getIndVal(i) - (((Cod) ind).getIndVal(i) - ((Prob) mem).getIfunction().getMin(i)) * Math.random(), i);
                            ((Cod) ind).setHistE(((Cod) ind).getHistE(i) - 1, i);
                        } else {
                            if (((Cod) ind).getHistE(i) > 0 && ((Cod) ind).getHistF() < ((Cod) ind).getFitness()) {
                                ((Cod) ind).setIndVal(((Cod) ind).getIndVal(i) + (((Prob) mem).getIfunction().getMax(i) - ((Cod) ind).getIndVal(i)) * Math.random(), i);
                                ((Cod) ind).setHistE(((Cod) ind).getHistE(i) + 1, i);
                            } else {
                                if ((random + 0.5) > 1) {
                                    ((Cod) ind).setIndVal(((Cod) ind).getIndVal(i) + (((Prob) mem).getIfunction().getMax(i) - ((Cod) ind).getIndVal(i)) * Math.random(), i);

                                } else {
                                    ((Cod) ind).setIndVal(((Cod) ind).getIndVal(i) - (((Cod) ind).getIndVal(i) - ((Prob) mem).getIfunction().getMin(i)) * Math.random(), i);

                                }
                                if (((Cod) ind).getHistE(i) > 0) {
                                    ((Cod) ind).setHistE(-1, i);
                                } else {
                                    ((Cod) ind).setHistE(1, i);
                                }
                            }
                        }
                    }

                }
            }
            //  mudar de posicao de algum elemento do vetor
//            case 2: {
//                int p1 = 0 + (int) (Math.random() * (((Cod) ind).getSize() + 0));
//                int p2 = 0 + (int) (Math.random() * (((Cod) ind).getSize() + 0));
//
//                double tmp = ((Cod) ind).getIndVal(p1);
//                ((Cod) ind).setIndVal(((Cod) ind).getIndVal(p2), p1);
//                ((Cod) ind).setIndVal(tmp, p2);
//            }
            //inverter o vetor
//            case 3: {
//                int p1 = 0;
//                int p2 = ((Cod) ind).getSize() - 1;
//
//                double tmp;
//
//                for (int i = 0; i < ((Cod) ind).getSize() / 2; i++) {
//                    tmp = ((Cod) ind).getIndVal(p1);
//                    ((Cod) ind).setIndVal(((Cod) ind).getIndVal(p2), p1);
//                    ((Cod) ind).setIndVal(tmp, p2);
//                    p1++;
//                    p2--;
//                }
//            }
        }
    }

    @Override
    public String name() {
        return "Mut";
    }
}
