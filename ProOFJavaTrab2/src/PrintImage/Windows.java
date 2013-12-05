/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintImage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.MazeSolution;
import javax.swing.JFrame;

/**
 *
 * @author Seiji
 */
public class Windows extends JFrame {

    private int width;
    private int height;
    private Screen graph;
    private String imageFail;
    Maze maze;

    public class thr implements Runnable {
        Screen t;
        thr(Screen t) {
            this.t = t;
        }

        @Override
        public void run() {
        }
    }

    public void Resize(int w, int h) {

        if (graph != null) {
            remove(graph);
        }
        graph = new Screen(width, height,this.maze, imageFail);

        new Thread(new thr(graph)).start();
    }

    public Windows(int w, int h, Maze maze, String imageFail) {
        width = w;
        height = h;
        this.imageFail = imageFail;
        this.maze = maze;
        
        Resize(width, height);
        add(graph);
        pack();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Labirinto");
        setResizable(false);
        setVisible(true);
    }
    
    public void setSolution(MazeSolution mazeS){
        graph.drawMazeSolution(mazeS);
    }
    
    public static void main(String[] args) {
        if (args.length >= 1 && args[0].equals("lap")) {
            Windows a = new Windows(664, 504,new Maze("media/Graph.txt"), "media/mapa.png");
            Windows b = new Windows(664, 504,new Maze("media/Graph.txt"), "media/mapa.png");
        } else if (args.length >= 1 && args[0].equals("mini")) {
            Windows a = new Windows(664, 504,new Maze("media/Graph.txt"), "media/mapa.png");
            Windows b = new Windows(664, 504,new Maze("media/Graph.txt"), "media/mapa.png");
        } else {
            Windows a = new Windows(664, 504,new Maze("media/Graph.txt"), "media/mapa.png");
            Windows b = new Windows(664, 504,new Maze("media/Graph.txt"), "media/mapa.png");
        }
    }
}
