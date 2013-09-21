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
import ProOF.gen.operator.oMutation;
import ProOF.gen.stopping.aStop;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.Solution;
import java.util.ArrayList;

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
    protected ArrayList<Solution<iProblem, iObjective, iCodification, Solution>> populationList;

    @Override
    public void services(LinkerNodes link) throws Exception {
	problemNode = link.need(Problem.class, problemNode);
	stopNode = link.need(aStop.class, stopNode);
	evalNodeSingle = link.need(nEvaluations.class, evalNodeSingle);	//added by bestsol
	//initializerOperatorNode = link.get(fOperatorInitializer.obj, initializerOperatorNode);
	initializerOperatorNode = link.need(oInitializer.class, initializerOperatorNode);
	cross = link.get(fCrossoverProvider.obj, cross);
	mutation = link.get(fMutationProvider.obj, mutation);
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {
	population_size = link.Int("Population size", 100, 1, 1000);
    }

    @Override
    public void load() throws Exception {
	//???
    }

    @Override
    public void start() throws Exception {
	populationList = new ArrayList<>(population_size);
    }

    public abstract void initialize() throws Exception;

    public abstract void iterate() throws Exception;

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
}
