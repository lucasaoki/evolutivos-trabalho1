/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintImage;

import MaD.maze.Maze;
import javax.swing.JFrame;

/**
 *
 * @author Seiji
 */
public class Windows extends JFrame {

    private int width;
    private int height;
    private Screen graph;
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

    public void re_size(int w, int h) {

        if (graph != null) {
            remove(graph);
        }
        graph = new Screen(width, height,this.maze);

        new Thread(new thr(graph)).start();
    }

    public Windows(int w, int h, Maze maze) {
        width = w;
        height = h;
        this.maze = maze;
        
        re_size(width, height);
        add(graph);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Labirinto");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length >= 1 && args[0].equals("lap")) {
            new Windows(664, 504,new Maze("media/Graph.txt"));
        } else if (args.length >= 1 && args[0].equals("mini")) {
            new Windows(224, 174,new Maze("media/Graph.txt"));
        } else {
            new Windows(824, 624,new Maze("media/Graph.txt"));
        }
    }
}
