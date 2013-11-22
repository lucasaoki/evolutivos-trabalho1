/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.mutation;

import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iObjective;
import ProOF.apl.problems.iProblem;
import ProOF.opt.abst.problem.meta.Solution;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luke
 */
public class iMutationProviderAdaptative extends aMutationProvider{

    @Override
    public Solution<iProblem, iObjective, iCodification, Solution> runMutation(Solution<iProblem, iObjective, iCodification, Solution> s1) {
        double best_it = problemNode.best().getBestInfo().getIteration();
        double act_it =problemNode.best().getCont_iter().value();
        
        double range_chance = 0.5;
        
        if(act_it - best_it > 10){
            range_chance = 0.2;
        }
        
        double rand = Math.random();
        if(rand < range_chance){
            try {
                mutationList[0].mutation(problemNode, s1.codif());
            } catch (Exception ex) {
                Logger.getLogger(iMutationProviderAdaptative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         return s1;
    }

    @Override
    public String name() {
        return "MutationProvider Adaptative";
    }

    @Override
    public String description() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
