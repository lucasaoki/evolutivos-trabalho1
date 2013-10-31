/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.functions;

import ProOF.com.language.Factory;

/**
 *
 * @author ito
 */
public class fFunction extends Factory<aMaze> {

    public static final fFunction obj = new fFunction();

    @Override
    public String name() {
        return "Objective Function Factory";
    }

    @Override
    public aMaze NewNode(int index) {
        switch (index) {
            case 0:
                return new iFunctionMaze1();
            case 1:
                return new iFunctionCM();
            case 2:
                return new iFunctionEXP();
            case 3:
                return new iFunctionGP();
            case 4:
                return new iFunctionGRP();
            case 5:
                return new iFunctionH6();
            case 6:
                return new iFunctionHSK();
            case 7:
                return new iFunctionHV();
            case 8:
                return new iFunctionKL();
            case 9:
                return new iFunctionLM2();
            case 10:
                return new iFunctionMCP();
            case 11:
                return new iFunctionMR();
            case 12:
                return new iFunctionBR();
            case 13:
                return new iFunctionSIN();
            case 14:
                return new iFunctionWP();
        }
        return null;
    }
}
