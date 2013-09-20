/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.gen.operator.oCrossover;
import java.util.Random;

/**
 *
 * @author Aoki
 */
public class Cross extends oCrossover<Prob, Cod> {

    private int size;
    private double fitness;
    private Cod newInd;

    @Override
    public Cod crossover(Prob mem, Cod ind1, Cod ind2) throws Exception {

        size = ind1.getSize();
        newInd = new Cod(size);
        Random rnd = new Random(System.currentTimeMillis());
        /* Escolhe um metodo aleatorio */
        switch (rnd.nextInt(4)) {
            case 0:
                method1(ind1, ind2);
                break;
            case 1:
                method2(ind1, ind2);
                break;
            case 2:
                method3(ind1, ind2);
                break;
            case 3:
                method4(ind1, ind2);
                break;
        }
        /* Calculo do Fitness */
        ((Prob) mem).getIfunction().Evaluate(mem, newInd);

        return newInd;
    }

    @Override
    public String name() {
        return "Cross";
    }

    /**
     * 50% do ind1 e 50% do ind2
     *
     * @param ind1
     * @param ind2
     */
    private void method1(Cod ind1, Cod ind2) {

        for (int i = 0; i < size; i++) {
            /* Metade de cada */
            if (i < size / 2) {
                newInd.setIndVal(ind1.getIndVal(i), i);
            } else {
                newInd.setIndVal(ind2.getIndVal(i), i);
            }
        }
    }

    /**
     * Intercalação
     *
     * @param ind1
     * @param ind2
     */
    private void method2(Cod ind1, Cod ind2) {

        for (int i = 0; i < size; i++) {
            /* Intercalando */
            if (i % 2 == 0) {
                newInd.setIndVal(ind1.getIndVal(i), i);
            } else {
                newInd.setIndVal(ind2.getIndVal(i), i);
            }
        }
    }

    /**
     * Ponderada dos melhores valores (está implementada para minimização
     *
     * @param ind1
     * @param ind2
     */
    private void method3(Cod ind1, Cod ind2) {

        Cod bestTmp, worstTmp;
        double fitTmp;

        /* Pegando menor valor */
        if (ind1.getFitness() < ind2.getFitness()) {
            bestTmp = ind1;
            worstTmp = ind2;
        } else {
            bestTmp = ind2;
            worstTmp = ind1;
        }
        fitTmp = bestTmp.getFitness() / (ind1.getFitness() + ind2.getFitness());

        if (Math.random() > fitTmp) {
            /* Melhor individuo */
            for (int i = 0; i < bestTmp.getSize(); i++) {
                newInd.setIndVal(bestTmp.getIndVal(i), i);
            }
        } else {
            /* Pior individuo */
            for (int i = 0; i < worstTmp.getSize(); i++) {
                newInd.setIndVal(worstTmp.getIndVal(i), i);
            }
        }
    }

    /**
     * Método de escolha de gene aleatório.
     *
     * @param ind1
     * @param ind2
     */
    private void method4(Cod ind1, Cod ind2) {

        double tmp;
        for (int i = 0; i < size; i++) {
            /* Aleatório */
            tmp = Math.random();
            if (tmp < 0.5) {
                newInd.setIndVal(ind1.getIndVal(i), i);
            } else {
                newInd.setIndVal(ind2.getIndVal(i), i);
            }
        }
    }
}
