package ProOF.apl.methods;

import ProOF.apl.factorys.fProblem;
import ProOF.apl.factorys.fRealOperator;
import ProOF.apl.factorys.fStop;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.gen.stopping.aStop;
import ProOF.opt.abst.metaheuristic.MetaHeuristic;
import sun.misc.Compare;
import sun.misc.Sort;

public class GA extends MetaHeuristic {

    private Init init;
    private Mutat mut;
    private Cross cross;
    private Prob prob;
    private int pop_size;
    private int ind_size;
    private aStop stp;
    private fRealOperator rop;

    @Override
    public void parameters(LinkerParameters link) throws Exception {
        pop_size = link.Int("Population Size", 1000);
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
        prob = link.get(fProblem.obj, prob);
        stp = link.get(fStop.obj, stp);
//        rop = link.get(fRealOperator.obj, rop);
//        init = link.need(Init.class, init);
//        mut = link.need(Mutat.class, mut);
//        cross = link.need(Cross.class, cross);
    }

    @Override
    public void execute() throws Exception {
        ind_size = prob.ob.getSize();

        Cod[] pop = new Cod[pop_size];
        Cod best = new Cod(ind_size);
        int p1;
        int stop = 0;

        init = new Init();
        cross = new Cross();
        mut = new Mutat();


        System.out.println("pop_size : " + pop_size);
        System.out.println("ind_size : " + ind_size);
        System.out.println("---------- Starting ----------");

        double step = 0.0;
        for (int i = 0; i < pop_size; i++) {
            pop[i] = new Cod(ind_size);
            init.initialize(prob, pop[i]);
            for (int j = 0; j < ind_size; j++) {
                step = (prob.ob.getMax(j) - prob.ob.getMin(j)) / ((double) pop_size);
                pop[i].setIndVal(prob.ob.getMin(j) + (i * step) + (pop[i].getIndVal(j) * step), j);
            }
        }

        while (stop < 10000) {
            stop++;


            for (int i = 0; i < pop_size; i++) {
                prob.ob.Evaluate(prob, pop[i]);
            }
            System.out.println("ITERATION No." + stop);

            pop = tour(pop);

            if (pop[0].getFitness() < best.getFitness()) {
                best.Copy(prob, pop[0]);
            }
            System.out.println("Best Fitness: " + best.getFitness());

            for (int i = ((int) 0.4 * pop_size); i < (int) (0.5 * pop_size); i++) {
                init.initialize(prob, pop[i]);
            }
            for (int i = 0; i < (int) (0.5 * pop_size); i += 2) {
                pop[((int) (0.5 * pop_size)) + i / 2] = (Cod) cross.crossover(prob, pop[i], pop[i + 1]);
            }

            for (int i = (int) (0.75 * pop_size); i < pop_size; i++) {
                init.initialize(prob, pop[i]);
            }

            for (int i = 0; i < pop_size; i++) {
                double rand = Math.random();
                if (rand < 0.99) {
                    mut.mutation(prob, pop[i]);
                }
            }

        }

    }

    private Cod[] tour(Cod[] pop) {
        Comp cp = new Comp();
        Sort.quicksort(pop, 0, pop_size - 1, cp);
        return pop;
    }

    @Override
    public String name() {
        return "GA(mbiarra)";
    }
}

class Comp implements Compare {

    @Override
    public int doCompare(Object o, Object o1) {
        if (((Cod) o).getFitness() > ((Cod) o1).getFitness()) {
            return 1;
        } else {
            return -1;
        }
    }
}
