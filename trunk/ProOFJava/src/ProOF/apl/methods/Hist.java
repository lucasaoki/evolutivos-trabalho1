/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

/**
 *
 * @author Seiji
 */
public class Hist {

    private double histFitness;
    private double[] histElem;

    public Hist(int size) throws Exception {
        histFitness = 999999;
        histElem = new double[size];
    }

    public double getHistF() {
        return histFitness;
    }

    public void setHistF(double fitness) {
        this.histFitness = fitness;
    }

    public double getHistE(int i) {
        return histElem[i];
    }

    public void setHistE(double value, int i) {
        this.histElem[i] = value;
    }
}
