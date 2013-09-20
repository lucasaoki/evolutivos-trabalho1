/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author Luke
 */
public class Cod extends Codification {

    private double[] ind;
    private int _size;
    private double fitness;
    private Hist histN;

    public Cod(int size) throws Exception {
        histN = new Hist(size);
        ind = new double[size];
        _size = size;
        fitness = 999999;
    }

    public double getHistE(int i) {
        return histN.getHistE(i);
    }

    public void setHistE(double fitness, int i) {
        histN.setHistE(fitness, i);
    }

    public double getHistF() {
        return histN.getHistF();
    }

    public void setHistF(double fitness) {
        histN.setHistF(fitness);
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double[] getInd() {
        return ind;
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
    public void Copy(Problem prob, Codification source) throws Exception {
        for (int i = 0; i < _size; i++) {
            ind[i] = ((Cod) source).getIndVal(i);
        }
        this.setFitness(((Cod) source).getFitness());
    }

    @Override
    public Codification New(Problem prob) throws Exception {
        return new Cod(_size);
    }
}
