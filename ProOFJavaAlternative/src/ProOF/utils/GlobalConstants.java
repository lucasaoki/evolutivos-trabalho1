/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.utils;

/**
 *
 * @author ito
 */
public class GlobalConstants {

    //aGA
    public final static int population_size = 2000;
    public final static double selectionRate = 0.4f;
    public final static double newPopForCrossover = 0.1;
    //aCrossoverProvider
    public final static double crossoverRate = 0.5;
    //aMutationProvider
    public final static double mutationRate = 1;
    //iStopEvalConvTime
    //eval
    public final static long max_evaluations = 1000000;
    //time
    public final static double time = 1 * 30f;
    //iterations
    public final static long max_iterations = 1000;
    //vary
    public final static long max_IterWOVary = 500;
    //best sol vary
    public final static double max_RangeVary = 1e-6;
    public final static long max_RangeVaryEval = 10;
}
