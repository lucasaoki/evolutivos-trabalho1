/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.init;

import ProOF.MaD.maze.MazeSolution;
import ProOF.MaD.maze.components.MazeVertex;
import ProOF.apl.problems.iCodification;
import ProOF.apl.problems.iProblem;
import ProOF.apl.problems.maze.aMaze;
import ProOF.com.LinkerNodes;
import ProOF.com.LinkerParameters;
import ProOF.gen.operator.oInitializer;
import ProOF.utils.GlobalConstants;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ito
 */
public class iInitializerDefault extends oInitializer<iProblem, iCodification> {

    
    private int initializeSize;

    public iInitializerDefault() {
        initializeSize = GlobalConstants.startIndividualSize;
    }
    
     
    
    
    @Override
    public void services(LinkerNodes com) throws Exception {
        //super.services(com);
    }

    @Override
    public void parameters(LinkerParameters win) throws Exception {
        initializeSize =  win.Int("InializeLimitSize", GlobalConstants.startIndividualSize, 1, GlobalConstants.limitIndividualSize);
    }

    @Override
    public void initialize(iProblem prob, iCodification codif) throws Exception {
        
        MazeSolution mazeSol = codif.getMazeSol();
        aMaze maze = codif.getMaze();
        
        if (prob.isUsingVertex()){           
            MazeVertex vinit=  maze.getVertexFromIndex(maze.getStartVertexIndex());
            
            List<MazeVertex> conectedVertexs =  vinit.getConnectedVertex();
            do
            {
                Collections.shuffle(conectedVertexs);
                mazeSol.addVertex(conectedVertexs.get(0));
                conectedVertexs = conectedVertexs.get(0).getConnectedVertex();
            
            }while (mazeSol.getSize() < initializeSize && mazeSol.getVertexAt(mazeSol.getSize() -1).getId() != codif.getMaze().getEndVertexIndex())
           
            
        }
        else
        {
            
        }
    
    }

    @Override
    public String name() {
        return "Init Default";
    }
}
