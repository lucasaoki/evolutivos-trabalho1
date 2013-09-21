/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;

import ProOF.apl.stop.iStopEvalConvTime;
import ProOF.com.language.Factory;
import ProOF.gen.stopping.aStop;
import ProOF.gen.stopping.iStopEvals;
import ProOF.gen.stopping.iStopIters;
import ProOF.gen.stopping.iStopTime;

/**
 *
 * @author marcio
 */
public final class fStop extends Factory<aStop> {

    public static final fStop obj = new fStop();

    @Override
    public String name() {
	return "Stop Factory";
    }

    @Override
    public aStop NewNode(int index) {
	switch (index) {
	    case 0:
		return new iStopEvals();
	    case 1:
		return new iStopEvalConvTime();
	    case 2:
		return new iStopTime();
	    case 3:
		return new iStopIters();
	}
	return null;
    }
}
