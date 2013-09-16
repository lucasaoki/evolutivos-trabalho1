/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;

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
        }
        return null;
    }
}
