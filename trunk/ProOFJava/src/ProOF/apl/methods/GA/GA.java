package ProOF.apl.methods.GA;

import ProOF.apl.problems.operators.Init;
import ProOF.apl.problems.ObjectFunction;
import ProOF.apl.factorys.fProblem;
import ProOF.apl.problems.operators.fRealOperator;
import ProOF.apl.factorys.fStop;
import ProOF.apl.methods.Cod;
import ProOF.apl.methods.Cross;
import ProOF.apl.methods.Mutat;
import ProOF.apl.methods.Prob;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.gen.stopping.aStop;
import ProOF.opt.abst.metaheuristic.MetaHeuristic;
import ProOF.opt.abst.problem.meta.Solution;
import ProOF.opt.abst.problem.meta.objective.SingleObjective;
import sun.misc.Compare;
import sun.misc.Sort;

public class GA extends MetaHeuristic {

    private Init init;   
    private Prob prob;
    private int pop_size;
    private int ind_size;
    private aStop stp;
    private fRealOperator rop;
    
     private Mutat mut;
    private Cross cross;

    @Override
    public void parameters(LinkerParameters link) throws Exception {
	pop_size = link.Int("Population Size", 1000);
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	prob = link.get(fProblem.obj, prob);
	stp = link.get(fStop.obj, stp);
//        rop = link.get(fRealOperator.obj, rop);
	init = link.need(Init.class, init);
//        mut = link.need(Mutat.class, mut);
//        cross = link.need(Cross.class, cross);
    }

    @Override
    public void execute() throws Exception {
	ind_size = prob.getIfunction().getSize();
	Solution<Prob, ObjectFunction, Cod, Solution>[] pop = new Solution[pop_size];
	int stop = 0;

	cross = new Cross();
	mut = new Mutat();


	System.out.println("pop_size : " + pop_size);
	System.out.println("ind_size : " + ind_size);
	System.out.println("---------- Starting ----------");

	//((SingleObjective)a.obj()).abs_value();

	double step = 0.0;
	for (int i = 0; i < pop_size; i++) {
	    pop[i] = prob.NewSolution(new Cod(ind_size));
	    for (int j = 0; j < ind_size; j++) {
		step = (prob.getIfunction().getMax(j) - prob.getIfunction().getMin(j)) / ((double) pop_size);
		pop[i].codif().setIndVal(prob.getIfunction().getMin(j) + (i * step) + (pop[i].codif().getIndVal(j) * step), j);
	    }
	}

	while (stop < 10000) {
	    stop++;


	    for (int i = 0; i < pop_size; i++) {
		prob.evaluate(pop[i]);
	    }
	    System.out.println("ITERATION No." + stop);

	    Sort.quicksort(pop, 0, pop_size - 1, new Comp());

//	    if (pop[0].getFitness() < best.getFitness()) {
//		best.Copy(prob, pop[0]);
//	    }
//	    System.out.println("Best Fitness: " + best.getFitness());

	    for (int i = (int) (0.4 * pop_size); i < (int) (0.5 * pop_size); i++) {
		init.initialize(prob, pop[i]);
		prob.getIfunction().Evaluate(prob, pop[i]);
	    }
	    for (int i = 0; i < (int) (0.5 * pop_size); i += 2) {
		pop[((int) (0.5 * pop_size)) + i / 2] = (Cod) cross.crossover(prob, pop[i], pop[i + 1]);
	    }

	    for (int i = (int) (0.75 * pop_size); i < pop_size; i++) {
		init.initialize(prob, pop[i]);
		prob.getIfunction().Evaluate(prob, pop[i]);
	    }

	    for (int i = 0; i < pop_size; i++) {
		double rand = Math.random();
		if (rand < 0.99) {
		    mut.mutation(prob, pop[i]);
		    prob.getIfunction().Evaluate(prob, pop[i]);
		}
	    }

	}

    }

    @Override
    public String name() {
	return "GA(mbiarra)";
    }
}

class Comp implements Compare {

    @Override
    public int doCompare(Object o, Object o1) {
	if (o instanceof Solution && o1 instanceof Solution) {
	    Solution s = (Solution) o;
	    Solution s1 = (Solution) o1;
	    if (((SingleObjective) s.obj()).abs_value() > ((SingleObjective) s1.obj()).abs_value()) {
		return 1;
	    } else {
		return -1;
	    }
	} else {
	    return 0;
	}
    }
}
