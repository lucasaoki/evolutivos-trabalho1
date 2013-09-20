/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl;

import ProOF.apl.methods.Cod;
import ProOF.apl.methods.Prob;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.com.LinkerResults;
import ProOF.com.LinkerValidations;
import ProOF.com.language.Node;

/**
 *
 * @author ito
 */
public abstract class aFunction extends Node {

    protected double[] _max;
    protected double[] _min;
    protected int _size = 10;

    @Override
    public String name() {
	return "Função objetivo";
    }

    @Override
    public String description() {
	return "Função objetivo generica a ser otimizada (nao modificada!!! favor modificar)";
    }

    public abstract void initialize();

    public double getMax(int index) {
	return _max[index];
    }

    public void setMax(double[] _max) {
	this._max = _max;
    }

    public double getMin(int index) {
	return _min[index];
    }

    public void setMin(double[] _min) {
	this._min = _min;
    }

    public int getSize() {
	return _size;
    }

    public void setSize(int size) {
	this._size = size;
    }

    public abstract void Evaluate(Prob prob, Cod codif) throws Exception;

    @Override
    public void services(LinkerNodes link) throws Exception {
    }

    @Override
    public void parameters(LinkerParameters link) throws Exception {
    }

    @Override
    public void load() throws Exception {
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public boolean validation(LinkerValidations link) throws Exception {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void results(LinkerResults link) throws Exception {
    }
}
