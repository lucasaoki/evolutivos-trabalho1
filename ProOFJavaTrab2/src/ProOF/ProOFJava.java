/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF;

import ProOF.apl.factorys.fRun;
import ProOF.com.model.Model;
import ProOF.com.runner.Runner;
import ProOF.opt.abst.problem.meta.Best;
import java.io.File;

/**
 *
 * @author marcio
 */
public class ProOFJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        args = new String[]{"run", "D:\\dev\\ec\\evtrab2\\work_space\\job\\finished\\mbkh", "D:\\dev\\ec\\evtrab2\\work_space\\input"};
        if (args == null || args.length < 1) {
            throw new Exception("don't have arguments");
        } else if (args[0].equals("model")) {
            Model.PRINT = true;
            Model model = new Model();
            model.create(fRun.obj);
            model.savePof("model.pof");
            model.saveSgl("model.sgl");
        } else if (args[0].equals("run")) {
            Runner.PRINT = true;
            Best.force_finish(true);
            Runner runner = new Runner(new File(args[1]), new File(args[2]), fRun.obj);
            runner.run();
        } else {
            throw new Exception(String.format("arg[0]='%s' is not recognized.", args[0]));
        }
    }
}
