/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.functions;

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
public abstract class aFunction extends Node {

    private StreamPrinter com;

    protected class Limits {

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
    }
    protected HashMap<Integer, Limits> limitList;

    public aFunction(int size) {
	com = null;
	limitList = new LinkedHashMap<>(size, size);
	for (int c = 0; c < size; c++) {
	    limitList.put(c, new Limits(0, 0));
	}
    }

    public double getMax(int index) {
	return limitList.get(index).max;
    }

    public void setMax(int index, int max) {
	limitList.get(index).max = max;
    }

    public double getMin(int index) {
	return limitList.get(index).min;
    }

    public void setMin(int index, int min) {
	limitList.get(index).min = min;
    }

    public int getSize() {
	return limitList.size();
    }

    public abstract double Evaluate(iCodification codif) throws Exception;

    public double getDefinedMinGlobal() throws Exception {
	return -1;
    }

    public double[] getDefinedBestSol() throws Exception {
	return new double[]{0, 0, 0, 0};
    }

    protected void printInfo() throws Exception {
	printLine(name(), getDefinedMinGlobal(), 9999999d);

	if (com != null) {
	    double[] definedBestSol = getDefinedBestSol();
	    for (double i : definedBestSol) {
		printLine(name(), getDefinedMinGlobal(), i);
	    }
	}
    }

    protected void printLine(String s1, Double d1, Double d2) throws Exception {
	com.printString("F. Name", s1);
	com.printDbl("Min Global", d1);
	com.printDbl("Best Sol", d2);
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
}
