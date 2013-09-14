/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.gen.codification.RealSingle.aRealSingle;

/**
 * function Ackley's
 * name   : ACK(x[10])
 * domine : [-30, +30]
 * optimal: ACK(0...0) = 0
 * @author marcio
 */
public class ACK extends aRealSingle{
    @Override
    public String name() {
        return "ACK";
    }
    @Override
    public int size() throws Exception {
        return 10;
    }
    @Override
    public double F(double[] X) throws Exception {
        double sum1 = 0;
        double sum2 = 0;
        for(double x : X){
            double xi = decode(x, -30, +30);
            sum1 += xi * xi;
            sum2 += Math.cos(2*Math.PI*xi);
        }
        return -20.0*Math.exp(-0.02*Math.sqrt(sum1/X.length)) - Math.exp(sum2/X.length) + 20 + Math.E;
    }
}
