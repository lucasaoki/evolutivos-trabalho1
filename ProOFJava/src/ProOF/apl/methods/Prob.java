/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.apl.aFunction;
import ProOF.apl.factorys.fFunction;
import ProOF.com.LinkerNodes;
import ProOF.gen.best.BestSol;
import ProOF.opt.abst.problem.meta.Objective;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author Luke
 */
public class Prob extends Problem<BestSol> {

    private aFunction ifunction;
    private BestSol b;
    
    public Prob() throws Exception {
        this.b = new BestSol();
    }

    public aFunction getIfunction() {
	return ifunction;
    }
    
    
    
     @Override
    public BestSol best() {
	return b;
    }

    @Override
    public Codification NewCodification() throws Exception {
        return new Cod(10);
    }

    @Override
    public Objective NewObjective() throws Exception {
        return new Obj();
    }

    @Override
    public String name() {
        return "Prob";
    }
    
    @Override
    public void services(LinkerNodes link) throws Exception{
        super.services(link);	
	ifunction = link.get(fFunction.obj, ifunction);
        
    }

   
    
}
