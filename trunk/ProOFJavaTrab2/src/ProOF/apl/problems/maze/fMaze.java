/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.maze;

import ProOF.com.language.Factory;

/**
 *
 * @author ito
 */
public class fMaze extends Factory<aMaze> {

    public static final fMaze obj = new fMaze();

    @Override
    public String name() {
        return "Objective Function Factory";
    }

    @Override
    public aMaze NewNode(int index) {
        switch (index) {
            case 0:
                return new iMaze1();
        }
        return null;
    }
}
