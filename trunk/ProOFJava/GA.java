package ProOF.apl.methods;

import java.util.Random;

import ProOF.apl.factorys.fProblem;



import ProOF.com.LinkerParameters;
import ProOF.com.LinkerNodes;

import ProOF.gen.operator.oCrossover;
import ProOF.gen.operator.oMutation;
import ProOF.gen.operator.oInitializer;
import ProOF.opt.abst.metaheuristic.MetaHeuristic;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.Solution;

public class GA extends MetaHeuristic{

	public Problem problem;
	public oInitializer init;
	public oCrossover cross;
	public oMutation mut;
	
	private int pop_size;
	private int max_eval;
	private Random rand;
        private int count_eval;
	
	public String name(){
		return "GA"; 
	}
	
	public String descripition(){
		return null;
	}
	
        @Override
	public void parameters(LinkerParameters link) throws Exception {
		pop_size = link.Int("numero de individuos", 10);
		max_eval = link.Int("numero de avaliacoes", 100, 10, 1000000);
	}
	
        @Override
	public void services(LinkerNodes link) throws Exception {
		problem = link.get(fProblem.obj, problem);
		init = link.need(init);
		cross = link.need(cross);
		mut = link.need(mut);
	}2
	
        @Override
	public void execute() throws Exception {
		count_eval=0;
	
		Solution[] pop = new Solution[pop_size];
		for(int i=0;i<pop_size;i++){
			pop[i] = problem.NewSolution();
		}
		
		for(int i=0;i<pop_size;i++){
			init.initialize(problem,pop[i]);
		}
		
		for(int i=0;i<pop_size;i++){
			evaluate(pop[i]);
		}
		
		do{
			int p1 = tour(pop);
			int p2 = tour(pop);
			
			Solution child;
                        child = cross.crossover(problem, pop[p1], pop[p2]);
			mut.mutation(problem, child);
			
			evaluate(child);
			int worse;
                        worse = evaluate(pop[p1]) > evaluate(pop[p2]) ? p1 : p2;
			pop[worse] = child;
		}while(count_eval<max_eval);
	}
	
	public int tour(Solution[] pop){
	
		rand = new Random(System.currentTimeMillis());
		
		int i;
            i = rand.nextInt()%pop_size;
		int j;
            j = rand.nextInt()%pop_size;
		
		if( pop[i] < pop[j]){
                    return i;
            } else{
                return j;
        }
	}
	
	
	public void evaluate(Solution sol) throws Exception{
		problem.evaluate(sol);
		count_eval++;
	}
	
}