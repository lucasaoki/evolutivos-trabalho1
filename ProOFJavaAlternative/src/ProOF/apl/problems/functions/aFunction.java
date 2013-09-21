/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.functions;

import ProOF.apl.problems.iCodification;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.language.Node;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author ito
 */
public abstract class aFunction extends Node {

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
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() throws Exception {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
