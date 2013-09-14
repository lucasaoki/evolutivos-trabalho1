/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;

import ProOF.apl.problems.ACK;
import ProOF.apl.problems.B2;
import ProOF.com.language.Factory;
import ProOF.gen.codification.RealSingle.aRealSingle;

/**
 *
 * @author marcio
 */
public final class fRealSingle extends Factory<aRealSingle>{
    public static final fRealSingle obj = new fRealSingle(); 
    @Override
    public String name() {
        return "fRealSingle";
    }
    @Override
    public aRealSingle NewNode(int index) {
        switch(index){
            case 0: return new B2();
            case 1: return new ACK();
        }
        return null;
    }
}
