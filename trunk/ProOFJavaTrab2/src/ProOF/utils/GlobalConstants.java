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
    
    public final static boolean use_vertex = true;
    
    public final static int limitIndividualSize = 10000;
    public final static int startIndividualSize = 5000;
    
    public final static int vertexDefaultStartIndex = 0;
    public final static int vertexDefaultEndIndex = 0;
    

    
    

    //aGA
    public final static int population_size = 300;
    public final static double selectionRate = 0.4f;
    public final static double newPopForCrossover = 0.1;
    //aCrossoverProvider
    public final static double crossoverRate = 0;
    //aMutationProvider
    public final static double mutationRate = 0.9;
    //iStopEvalConvTime
    //eval
    public final static long max_evaluations = 1000000;
    //time
    public final static double time = 1 * 5f;
    //iterations
    public final static long max_iterations = 10000;
    //vary
    public final static long max_IterWOVary = 270;
    public final static double max_IterWOVaryGAP = 0.01;
    //best sol vary
    public final static double max_RangeVary = 1e-5;
    public final static long max_RangeVaryEval = 3;
    //initialize
    public final static int aligned = 1;
}
