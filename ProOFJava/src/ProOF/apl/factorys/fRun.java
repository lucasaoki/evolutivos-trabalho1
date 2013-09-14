/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;

import ProOF.apl.methods.GA;
import ProOF.com.language.Factory;
import ProOF.com.language.Run;

/**
 *
 * @author marcio
 */
public class fRun extends Factory<Run>{
    public static final fRun obj = new fRun();
    private fRun(){}
    
    @Override
    public String name() {
        return "Run";
    }
    @Override
    public Run NewNode(int index) {
        switch(index){
            case 0: return new GA();
        }
        return null;
    }

    
}
