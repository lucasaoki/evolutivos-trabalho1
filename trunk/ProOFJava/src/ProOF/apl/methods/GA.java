package ProOF.apl.methods;

import ProOF.apl.factorys.fProblem;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.opt.abst.metaheuristic.MetaHeuristic;

public class GA extends MetaHeuristic {

    private Init init;
    private Mutat mut;
    private Cross cross;
    private Prob prob;
    private int pop_size;
    private int ind_size;

    @Override
    public void parameters(LinkerParameters link) throws Exception {
        pop_size = link.Int("Tamanho da populacao", 10);
        ind_size = link.Int("Tammanho do individuo", 10);
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
        prob = link.get(fProblem.obj, prob);
//        init = link.need(Init.class, init);
//        mut = link.need(Mutat.class, mut);
//        cross = link.need(Cross.class, cross);
    }

    @Override
    public void execute() throws Exception {
        Cod[] pop = new Cod[10];
        int p1;
        int stop = 0;

        for (int i = 0; i < pop_size; i++) {
            pop[i] = new Cod(ind_size);
            init.initialize(prob, pop[i]);
        }

        while (stop < 100) {

            for (int i = 0; i < pop_size; i++) {
                prob.ob.Evaluate(prob, pop[i]);
            }

            p1 = tour(pop);

            pop[p1].setIndVal(pop[p1].getIndVal(0) - 0.1, 0);
        }

    }

    private int tour(Cod[] pop) {
        int p = 0;

        for (int i = 0; i < pop_size; i++) {
            if (pop[i].getFitness() > pop[p].getFitness()) {
                p = i;
            }
        }

        return p;
    }

    @Override
    public String name() {
        return "GA";
    }
}