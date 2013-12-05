/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods.GA.algorithm;

import PrintImage.Windows;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.com.LinkerResults;
import ProOF.opt.abst.problem.meta.Solution;
import java.util.List;

/**
 *
 * @author ito
 */
public class iGADefault extends aGA {
    
    Windows[] w;
    int resetcount;

    @Override
    public String name() {
	return "GAAlgorithm Default";
    }

    @Override
    public String description() {
	return "GAAlgorithm Base description";
    }

    @Override
    public void initialize() throws Exception {
	populationList.addAll(generate(population_size));
        
        resetcount = 0;
        
        w = new Windows[population_size+1];
        
        for (int c = 0; c< w.length - 1; c++)
            w[c] = new Windows( "ind " + Integer.toString(c), 640, 480, populationList.get(0).codif().getMaze().getMaze(), "../../../media/mapa.png");

         w[w.length - 1] = new Windows( "crossover ", 640, 480, populationList.get(0).codif().getMaze().getMaze(), "../../../media/mapa.png");
	System.out.printf("INITIALIZATED\n");
    }

    @Override
    public void iterate() throws Exception {
	//System.out.printf("ITERATING\n");

	evaluate();
	if (stopNode.end()) {
	    return;
	}
        
        
        resetcount++;
        if (resetcount > 15)
        {
       populationList.clear();
       populationList.addAll(generate(population_size));
       
        for (int c=  0; c < populationList.size(); c++)
        {
            w[c].setSolution(populationList.get(c).codif().getMazeSol());
        }  
        resetcount = 0;
        }
//        
//        Thread.sleep(2000);
//         if (true)
//            return;
         
         System.out.println("running mutation: ");
        for (int c=  0; c < populationList.size(); c++)
        {
            mutation.runMutation(populationList.get(c));
            w[c].setSolution(populationList.get(c).codif().getMazeSol());
        }        
 
        Thread.sleep(1000);
//          if (true)
//            return;
          
         System.out.println("running crossover: ");
        Solution<iProblem, iObjective, iCodification, Solution> runCross = cross.runCross(populationList.get(0), populationList.get(1));
         
        w[w.length-1].setSolution(runCross.codif().getMazeSol());
        Thread.sleep(2000);
        
        if (true)
            return;
        
	List lold = sublistClone(populationList, 0, (int) Math.round(population_size * selectionRate));
//	List lnew = generate((int) Math.round(population_size * newPopForCrossover));
        
	populationList.clear();

	populationList.addAll(lold);

        System.out.println("AfterCrossover  Pop size: " + Integer.toString(populationList.size()));
        
//	populationList.addAll(lnew);


	double limitCount = populationList.size() / 2f;

	for (int c = 0; c < limitCount; c++) {
	    Solution<iProblem, iObjective, iCodification, Solution> child = cross.runCross(populationList.get(c * 2), populationList.get(c * 2 + 1));

	    if (child != null) {
		populationList.add(child);
	    }

//	    System.out.print(Integer.toString(c) + " ");
	}
	System.out.println("AfterCrossover  Pop size: " + Integer.toString(populationList.size()));

	for (int c = 0; c < populationList.size(); c++) {
	    mutation.runMutation(populationList.get(c));
	}

	//selection();

	populationList.addAll(generate(population_size - populationList.size()));

    }

    @Override
    public void results(LinkerResults link) throws Exception {
	System.out.printf("iGA results\n");
    }
}
