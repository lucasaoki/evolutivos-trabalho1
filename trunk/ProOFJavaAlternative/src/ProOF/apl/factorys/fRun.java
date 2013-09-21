/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;

import ProOF.apl.methods.GA.rGA;
import ProOF.com.language.Factory;
import ProOF.com.language.Run;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcio
 */
public class fRun extends Factory<Run> {

    public static final fRun obj = new fRun();

    private fRun() {
    }

    @Override
    public String name() {
	return "Run Factory";
    }

    @Override
    public Run NewNode(int index) {
	switch (index) {
	    case 0:
		try {
		    return new rGA();
		} catch (Exception ex) {
		    Logger.getLogger(fRun.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	return null;
    }
}
