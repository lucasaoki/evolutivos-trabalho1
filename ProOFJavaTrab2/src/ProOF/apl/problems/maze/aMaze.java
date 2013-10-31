/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import MaD.maze.MazeSolution;
import ProOF.apl.problems.iCodification;
import ProOF.com.Communication;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.StreamPrinter;
import ProOF.com.language.Node;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author ito
 */
public abstract class aMaze extends Node {

    private StreamPrinter com;

    public aMaze() {
	com = null;
    }

    public abstract double Evaluate(iCodification codif) throws Exception;

    public MazeSolution getDefinedMinGlobal() throws Exception {
	printLine("Warning: MinGlobal not defined");
	return -1;
    }

    public double[] getDefinedBestSol() throws Exception {
	printLine("Warning: Bestsol not defined");
	return new double[]{0, 0, 0, 0};
    }

    public double getMinLimitVar() {
	return minLimitVar;
    }

    public double getMaxLimitVar() {
	return maxLimitVar;
    }

    protected void printInfo() throws Exception {
	printLine("Nome Funcao: " + name());
	printLine(String.format("Min var: %f\tMax var: %f", minLimitVar, maxLimitVar));
	printLine("Melhor solucao: " + getDefinedMinGlobal());
	if (com != null) {
	    double[] definedBestSol = getDefinedBestSol();
	    for (int c = 0; c < definedBestSol.length; c++) {
		printLine(String.format("\tX[%d]: %8f", c, definedBestSol[c]));
	    }
	}
    }

    protected void printLine(String str) throws Exception {
	com.printString("Info", str);
    }

    @Override
    public void services(LinkerNodes link) throws Exception {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() throws Exception {
	com = Communication.mkPrinter("Function Info");
    }

    @Override
    public void start() throws Exception {
	double minAVG = 0, minVar = 0;
	double maxAVG = 0, maxVar = 0;

	for (int c = 0; c < getSize(); c++) {
	    minAVG += getMin(c);
	    maxAVG += getMax(c);
	}
	minAVG /= getSize();
	maxAVG /= getSize();

	for (int c = 0; c < getSize(); c++) {
	    minVar += Math.pow(minAVG - getMin(c), 2);
	    maxVar += Math.pow(maxAVG - getMax(c), 2);
	}

	minVar /= getSize();
	maxVar /= getSize();
	minLimitVar = Math.sqrt(minVar);
	maxLimitVar = Math.sqrt(maxVar);

	printInfo();
    }

    @Override
    public boolean validation(LinkerValidations link) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void results(LinkerResults link) throws Exception {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class Limits {

	public double max;
	public double min;

	public Limits(double min, double max) {
	    this.max = max;
	    this.min = min;
	}

	public void setLimits(double min, double max) {
	    this.max = max;
	    this.min = min;
	}

	public double getMax() {
	    return max;
	}

	public void setMax(double max) {
	    this.max = max;
	}

	public double getMin() {
	    return min;
	}

	public void setMin(double min) {
	    this.min = min;
	}
    }
}
