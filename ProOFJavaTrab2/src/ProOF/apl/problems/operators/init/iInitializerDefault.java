/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.apl.problems.operators.init;

import ProOF.MaD.maze.Maze;
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
        aMaze amaze = codif.getMaze();
        
        if (prob.isUsingVertex()){    
            MazeVertex last = null;
            Maze maze = amaze.getMaze();
            MazeVertex vinit=  maze.getVertexFromIndex(amaze.getStartVertexIndex());
            
            List<MazeVertex> conectedVertexs =  maze.getConnectedVertices(vinit);
            do
            {
                Collections.shuffle(conectedVertexs);
                mazeSol.addVertex(conectedVertexs.get(0));
                last  =conectedVertexs.get(0);
                conectedVertexs = maze.getConnectedVertices( conectedVertexs.get(0));
                
                if (conectedVertexs.size() > 1)
                {
                    conectedVertexs.remove(last);
                }
            
            }while (mazeSol.getSize() < initializeSize && mazeSol.getVertexAt(mazeSol.getSize() -1).getIndex() != codif.getMaze().getEndVertexIndex());
           //condicao de parada na inicializacao eh de encher o limite ou achar o nó desejado
            
        }
        else
        {
            System.out.println("ïnitializr usando direction nao implementada");
        }
    
    }

    @Override
    public String name() {
        return "Init Default";
    }
}
