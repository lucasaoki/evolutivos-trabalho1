/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import ProOF.apl.problems.iCodification;

/**
 *
 * @author ito
 */
public final class iFunctionMaze1 extends aMaze {

    @Override
    public String name() {
	return "Maze function1";
    }

    @Override
    public String description() {
	return "Analise maze";
    }

    public iFunctionMaze1() {
	//IMPORTANT!!! SUPER(SIZE)
	super(10);
	for (int i = 0; i < limitList.size(); i++) {
	    limitList.get(i).setLimits(-30, 30);
	}
    }

    @Override
    public double Evaluate(iCodification codif) throws Exception {
	
        
        //calculate dist from codif.ind
    }

    @Override
    public double getDefinedMinGlobal() throws Exception {
	return 0;
    }

    @Override
    public double[] getDefinedBestSol() throws Exception {
	return new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
