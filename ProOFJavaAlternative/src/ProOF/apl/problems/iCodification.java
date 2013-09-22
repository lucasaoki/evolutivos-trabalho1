/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author ito
 */
public class iCodification extends Codification<iProblem, iCodification> {

    private Double[] ind;
    private int _size;

    public iCodification(int size) throws Exception {
	ind = new Double[size];
	for (int c = 0; c < size; c++) {
	    ind[c] = new Double(1);
	}
	_size = size;
    }

    public Double[] getInd() {
	return ind;
    }

    public void setInd(Double[] ind) {
	this.ind = ind;
    }

    public void setIndVal(double val, int p) {
	ind[p] = val;
    }

    public double getIndVal(int p) {
	return ind[p];
    }

    public int getSize() {
	return _size;
    }

    @Override
    public void Copy(iProblem prob, iCodification source) throws Exception {
	for (int i = 0; i < _size; i++) {
	    ind[i] = source.getIndVal(i);
	}
    }

    @Override
    public iCodification New(iProblem prob) throws Exception {
	return new iCodification(_size);
    }
}
