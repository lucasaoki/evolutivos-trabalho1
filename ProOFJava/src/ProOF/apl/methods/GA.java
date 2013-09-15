package ProOF.apl.methods;

import ProOF.apl.factorys.fProblem;
import ProOF.apl.factorys.fRealOperator;
import ProOF.apl.factorys.fStop;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.gen.stopping.aStop;
import ProOF.opt.abst.metaheuristic.MetaHeuristic;

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
        pop_size = link.Int("Tamanho da populacao", 10);
        ind_size = link.Int("Tammanho do individuo", 1);
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
        Cod[] pop = new Cod[pop_size];
        int p1;
        int stop = 0;
        
        init = new Init();
        cross = new Cross();
        mut = new Mutat();
        
        
        System.out.println(pop_size);
        System.out.println(ind_size);
        System.out.println("Iniciando ----------");
        
        for (int i = 0; i < pop_size; i++) {
            pop[i] = new Cod(ind_size);
            init.initialize(prob, pop[i]);
        }

        while (stop < 100000) {
            stop++;
            
            for (int i = 0; i < pop_size; i++) {
                System.out.println(pop[i].getIndVal(0));
            }
           
            for (int i = 0; i < pop_size; i++) {
                prob.ob.Evaluate(prob, pop[i]);
            }

            p1 = tour(pop);
            
            System.out.println("Best: " + pop[p1].getIndVal(0) + ", " + stop);
            
            //Mutation PORCO!!!
            p1 = 0 + (int)(Math.random() * (10 + 0));
            pop[p1].setIndVal(Math.random(), 0);
            
        }

    }

    private int tour(Cod[] pop) {
        int p1 = 0 + (int)(Math.random() * (10 + 0));
        int p2 = 0 + (int)(Math.random() * (10 + 0));

            //Crossover PORCO!!!
            if (pop[p1].getFitness() > pop[p2].getFitness()) {
                pop[p2].setIndVal((pop[p1].getIndVal(0)+pop[p2].getIndVal(0))/2, 0);
                return p1;
            } else {
                pop[p1].setIndVal((pop[p1].getIndVal(0)+pop[p2].getIndVal(0))/2, 0);
                return p2;
            }

    }

    @Override
    public String name() {
        return "GA";
    }
}
