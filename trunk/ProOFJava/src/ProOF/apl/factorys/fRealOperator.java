/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.factorys;


import ProOF.apl.methods.Cross;
import ProOF.apl.methods.Init;
import ProOF.apl.methods.Mutat;
import ProOF.com.language.Factory;
import ProOF.gen.codification.Real.iRealCrossAvg;
import ProOF.gen.codification.Real.iRealCrossBLX;
import ProOF.gen.codification.Real.iRealCrossHeur;
import ProOF.gen.codification.Real.iRealCrossOX;
import ProOF.gen.codification.Real.iRealInitRandom;
import ProOF.gen.codification.Real.iRealMovInvert;
import ProOF.gen.codification.Real.iRealMovLimit;
import ProOF.gen.codification.Real.iRealMovReplace;
import ProOF.gen.codification.Real.iRealMutInvert;
import ProOF.gen.codification.Real.iRealMutLimit;
import ProOF.gen.codification.Real.iRealMutReplace;
import ProOF.opt.abst.problem.meta.codification.Operator;


/**
 *
 * @author marcio
 */
public class fRealOperator extends Factory<Operator>{
    public static final fRealOperator obj = new fRealOperator();

    @Override
    public String name() {
        return "Codif-Real Operators";
    }
    
    @Override
    public Operator NewNode(int index) {
        switch(index){
            case  0: return new iRealCrossAvg();
            case  1: return new iRealCrossOX();
            case  2: return new iRealCrossBLX();
            case  3: return new iRealCrossHeur();
                 
            case  4: return new iRealMutReplace();
            case  5: return new iRealMutLimit();
            case  6: return new iRealMutInvert();
                
            case  7: return new iRealMovReplace();
            case  8: return new iRealMovLimit();
            case  9: return new iRealMovInvert();
                
            case 10: return new iRealInitRandom();
                
                //
            case 11: return new Cross();
            case 12: return new Mutat();
            case 13: return new Init();
        }
        return null;
    }
}
