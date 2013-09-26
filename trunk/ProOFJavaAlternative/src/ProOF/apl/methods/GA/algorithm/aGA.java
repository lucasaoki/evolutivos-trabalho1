/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods.GA.algorithm;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.apl.problems.operators.crossover.aCrossoverProvider;
import ProOF.apl.problems.operators.crossover.fCrossoverProvider;
import ProOF.apl.problems.operators.mutation.aMutationProvider;
import ProOF.apl.problems.operators.mutation.fMutationProvider;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.language.Node;
import ProOF.gen.best.nEvaluations;
import ProOF.gen.operator.oInitializer;
import ProOF.gen.stopping.aStop;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.Solution;
import ProOF.utils.GenerationInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ito
 */
public abstract class aGA extends Node {

    //general nodes
    protected iProblem problemNode;
    protected oInitializer<iProblem, iCodification> initializerOperatorNode;
    protected nEvaluations evalNodeSingle;
    protected aStop stopNode;
    //CROSSOVER
    protected aCrossoverProvider cross;
    //MUTATION
    protected aMutationProvider mutation;
    //POPULATION
    protected int population_size;
    protected List<Solution<iProblem, iObjective, iCodification, Solution>> populationList;

    @Override
    public void services(LinkerNodes link) throws Exception {
	problemNode = link.need(Problem.class, problemNode);
	stopNode = link.need(aStop.class, stopNode);
	evalNodeSingle = link.need(nEvaluations.class, evalNodeSingle);	//added by bestsol
	initializerOperatorNode = link.need(oInitializer.class, initializerOperatorNode);
	cross = link.get(fCrossoverProvider.obj, cross);
	mutation = link.get(fMutationProvider.obj, mutation);
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {
	population_size = link.Int("Population size", 1000, 1, 10000000);
    }

    @Override
    public void load() throws Exception {
	//???
    }

    @Override
    public void start() throws Exception {
	populationList = generate(0);
    }

    public abstract void initialize() throws Exception;

    public abstract void iterate() throws Exception;

    public List<Solution<iProblem, iObjective, iCodification, Solution>> generate(int size) throws Exception {
	List<Solution<iProblem, iObjective, iCodification, Solution>> tpop = new ArrayList<>();
	Solution<iProblem, iObjective, iCodification, Solution> s;


	if (size > 0) {
	    GenerationInfo.newGeneration();

	    //System.out.println("Generating " + Integer.toString(size) + "individuals");

	    for (int c = 0; c < size; c++) {
		s = problemNode.NewSolution();
		s.codif().getGenInfo().setInfo(c, size);
		initializerOperatorNode.initialize(problemNode, s.codif());
		tpop.add(s);
	    }
	}
	return tpop;
    }

    protected void evaluate() throws Exception {
	for (Solution s : populationList) {
	    problemNode.evaluate(s);
	}
	try {
	    Collections.sort(populationList, new IComp());
	} catch (Exception e) {
	    System.err.println("Sort Error");
	}
    }

    protected List<Solution<iProblem, iObjective, iCodification, Solution>> sublistClone(List<Solution<iProblem, iObjective, iCodification, Solution>> list, int start, int end) throws Exception {
	List sublist = list.subList(start, end);
	List newsublist = generate(0);

	for (int c = 0; c < sublist.size(); c++) {
	    newsublist.add(sublist.get(c));
	}

	return newsublist;
    }

    //NOT USED
    //NOT USED
    //NOT USED
    //NOT USED
    @Override
    public void results(LinkerResults link) throws Exception {
    }

    @Override
    public boolean validation(LinkerValidations link) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected class IComp implements Comparator<Solution<iProblem, iObjective, iCodification, Solution>> {

	@Override
	public int compare(Solution<iProblem, iObjective, iCodification, Solution> t, Solution<iProblem, iObjective, iCodification, Solution> t1) {
	    if (t.obj().abs_value() == t1.obj().abs_value()) {
		return 0;
	    }

	    if (t.obj().abs_value() > t1.obj().abs_value()) {
		return 1;
	    } else {
		return -1;
	    }

	}
    }
}
