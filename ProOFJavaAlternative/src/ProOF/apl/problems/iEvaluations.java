/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems;

import ProOF.com.language.NodeSingle;

/**
 *
 * @author ito
 */
public class iEvaluations extends NodeSingle {

    private static iEvaluations obj = null;
//    private long nEvalWihoutVary;
//    private long bestSolGap;

    public static iEvaluations object() {
	if (obj == null) {
	    obj = new iEvaluations();
	}
	return obj;
    }

    private iEvaluations() {
    }
    private long evaluations;
    private long evalWOVary;

    public void update() {
	evaluations++;
    }

    public void updateWithoutVary() {
	evalWOVary++;
    }

    public long value() {
	return evaluations;
    }

    public long valueWithoutVary() {
	return evalWOVary;
    }

    public void resetWithoutVary() {
	evalWOVary = 0;
    }

    @Override
    public void start() throws Exception {
	evaluations = 0;
	evalWOVary = 0;
    }

    @Override
    public String name() {
	return "iEvaluations";
    }

    @Override
    public String description() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    /*@Override
     public void print(PrintStream out) throws Exception {
     out.printf("evaluations = %d\n", evaluations);
     }*/
}
