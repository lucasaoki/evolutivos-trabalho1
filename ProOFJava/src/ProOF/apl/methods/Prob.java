/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.methods;

import ProOF.com.LinkerNodes;
import ProOF.opt.abst.problem.meta.Best;
import ProOF.opt.abst.problem.meta.Objective;
import ProOF.opt.abst.problem.meta.Problem;
import ProOF.opt.abst.problem.meta.codification.Codification;

/**
 *
 * @author Luke
 */
public class Prob extends Problem {

    public Obj  ob;
    
    public Prob() throws Exception {
        ob = new Obj();
    }
    
    @Override
    public Best best() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
    }
    
}
