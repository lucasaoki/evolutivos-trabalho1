/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;

import ProOF.apl.Function.iFunctionACK;
import ProOF.apl.aFunction;
import ProOF.com.language.Factory;

/**
 *
 * @author ito
 */
public class fFunction extends Factory<aFunction> {
 public static final fFunction obj = new fFunction();
    
    @Override
    public String name() {
        return "Objective";
    }
    
    @Override
    public aFunction NewNode(int index) {
        switch(index){
            case 0: return new iFunctionACK();
        }
        return null;
    }
}
