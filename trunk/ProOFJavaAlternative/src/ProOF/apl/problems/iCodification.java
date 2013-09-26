/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.gen.codification.Real.cReal;
import ProOF.utils.GenerationInfo;

/**
 *
 * @author ito
 */
public class iCodification extends cReal<iProblem> {

    GenerationInfo gen;

    public iCodification(int size) throws Exception {
	super(size);
	gen = new GenerationInfo(0, 0);
	for (int c = 0; c < size; c++) {
	    X[c] = 1;
	}
    }

    public double[] getInd() {
	return X;
    }

    public void setInd(double[] ind) {
	if (ind.length != X.length) {
	    System.err.println("invalid Codification size!\n");
	} else {
	    System.arraycopy(ind, 0, this.X, 0, this.X.length);
	}
    }

    public void setIndVal(double val, int p) {
	X[p] = val;
    }

    public double getIndVal(int p) {
	return X[p];
    }

    public int getSize() {
	return X.length;
    }

    @Override
    public iCodification New(iProblem prob) throws Exception {
	return new iCodification(X.length);
    }

    public GenerationInfo getGenInfo() {
	return gen;
    }
}
