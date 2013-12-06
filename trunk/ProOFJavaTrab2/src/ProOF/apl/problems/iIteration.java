/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.com.language.NodeSingle;
import ProOF.utils.GlobalConstants;

/**
 *
 * @author ito
 */
public class iIteration extends NodeSingle {

    private static iIteration obj = null;
    private double bestResultRef;

    public static iIteration object() {
	if (obj == null) {
	    obj = new iIteration();
	}
	return obj;
    }

    private iIteration() {
    }
    private long iterations;
    private long iterationsWithoutVary;

    public void iteration() {
	iterations++;
    }

    public void iterationWithoutVary(double value) {
	if (Math.abs(value - bestResultRef) <= GlobalConstants.max_IterWOVaryGAP) {
	    iterationsWithoutVary++;
//	    System.out.format("akiii add value: %f  best value:%f  %n", value, bestResultRef);
	} else {
	    resetIterationWithoutVary();
	    setBestResultRef(value);
//	    System.out.format("akiii ressssssest add value: %f  best value:%f  %n", value, bestResultRef);
	}
    }

    public void resetIterationWithoutVary() {
	iterationsWithoutVary = 0;
    }

    public long value() {
	return iterations;
    }

    public long valueWithouVary() {
	return iterationsWithoutVary;
    }

    public void setBestResultRef(double bestResultRef) {
	this.bestResultRef = bestResultRef;
    }

    @Override
    public String name() {
	return "iIterations";
    }

    @Override
    public String description() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void start() throws Exception {
	iterations = 0;
	resetIterationWithoutVary();

    }
}
