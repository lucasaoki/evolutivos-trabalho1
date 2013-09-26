/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.init;

import ProOF.apl.problems.functions.aFunction;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.gen.operator.oInitializer;
import ProOF.utils.GenerationInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author ito
 */
public class iInitializerDistributed extends oInitializer<iProblem, iCodification> {

    int aligned;
    long currGen;
    //relativepopSize and popinfo
    Map<Integer, _PopInfo> baseValues;

    @Override
    public void initialize(iProblem mem, iCodification ind) throws Exception {
	if (ind.getGenInfo().getCurrGeneration() != currGen) {
	    currGen = ind.getGenInfo().getCurrGeneration();
	    _initialize(mem, ind.getGenInfo());
	}

	_PopInfo pinfo = baseValues.get(ind.getGenInfo().getRelativePopSize());


	//System.out.print("Gen: " + Double.toString(currGen) + " Ind: " + Double.toString(ind.getGenInfo().getRelativePositionInPop()) + "::  ");

	for (int c = 0; c < ind.X.length; c++) {

	    double incr = (new Random().nextInt(2) == 0 ? 1 : -1) * pinfo.stepList.get(c) * Math.random();
	    incr += pinfo.list.get(c).get(ind.getGenInfo().getRelativePositionInPop());

	    if (incr > mem.getIFunc().getMax(c)) {
		incr = mem.getIFunc().getMax(c);
	    } else if (incr < mem.getIFunc().getMin(c)) {
		incr = mem.getIFunc().getMin(c);
	    }

	    ind.X[c] = incr;

	    //System.out.print("[" + String.format("%f", incr) + "] ");
	}

	//System.out.println();


	//ind.setInd(ind);


    }

    @Override
    public String name() {
	return "Init Distributed";
    }

    @Override
    public void start() throws Exception {
	currGen = GenerationInfo.getGlobalGeneration() - 1;
	baseValues = new HashMap<>();
    }

    @Override
    public void services(LinkerNodes com) throws Exception {
    }

    @Override
    public void parameters(LinkerParameters win) throws Exception {
	aligned = win.Int("Init Aligned", 1, 0, 1, "aligned -> 1, not aligned -> 0");
    }

    private void _initialize(iProblem mem, GenerationInfo genInfo) {
	_PopInfo pList = baseValues.get(genInfo.getRelativePopSize());

	if (pList == null) {
	    pList = new _PopInfo(genInfo.getRelativePopSize());
	    aFunction ifu = mem.getIFunc();

	    //faz para cada gene
	    for (int c = 0; c < ifu.getSize(); c++) {
		List<Double> queue = pList.newListForPopulation();
		double preStep = ifu.getMax(c) - ifu.getMin(c);
		preStep /= genInfo.getRelativePopSize();

		//adiciona o total de população de um gene
		for (int d = 0; d < genInfo.getRelativePopSize(); d++) {
		    queue.add(ifu.getMin(c) + d * preStep);
		}

		pList.addGeneInfo(queue, preStep);
	    }

	    baseValues.put(pList.popSize, pList);
	}

	if (aligned == 0) {
	    for (List<Double> aq : pList.list) {
		Collections.shuffle(aq, new Random(currGen));
	    }
	}

    }

    private class _PopInfo {

	List<Double> stepList;
	List<List<Double>> list;
	int popSize;

	public _PopInfo(int popSize) {
	    list = new LinkedList<>();
	    stepList = new LinkedList<>();
	    this.popSize = popSize;
	}

	public void addGeneInfo(List<Double> aq, double stepSize) {
	    stepList.add(stepSize);
	    list.add(aq);
	}

	public List<Double> newListForPopulation() {
	    return new ArrayList<>(popSize);
	}
    }
}
