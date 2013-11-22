/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze.generator;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author lucasaoki
 */
public class MazeGen extends JFrame {

    private int width;
    private int height;
    private int cell_w = 8;
    private int cell_h = 6;
    private int border = 12;

    private int min_tm = 3;
    private int max_tm = 600;
    private int def_tm = 150;

    WindowManager canvas;
    JPanel scr;

    private class size {

        public int w, h;
        public String str;

        size(int w, int h, String str) {
            this.w = w;
            this.h = h;
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    private class size_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            size p = (size) cb.getSelectedItem();
            re_size(p.w, p.h);
        }
    }

    private class button_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            re_size(cell_w, cell_h);
        }
    }

    private class slider_listener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            var.sleep = max_tm - ((JSlider) e.getSource()).getValue() + min_tm;
        }
    }

    private class thr implements Runnable {

        WindowManager t;
        grafo<par<Integer, Integer>, par<HashSet<par<Integer, Integer>>, HashSet<Integer>>> g;

        thr(WindowManager t,
                grafo<par<Integer, Integer>, par<HashSet<par<Integer, Integer>>, HashSet<Integer>>> g) {
            this.t = t;
            this.g = g;
        }

        @Override
        public void run() {
            g.profundidade(t);
        }
    }

    private void re_size(int w, int h) {
        cell_w = w;
        cell_h = h;

        if (canvas != null) {
            scr.remove(canvas);
        }

        grafo<par<Integer, Integer>, par<HashSet<par<Integer, Integer>>, HashSet<Integer>>> g
                = new grafo<par<Integer, Integer>, par<HashSet<par<Integer, Integer>>, HashSet<Integer>>>(cell_w, cell_h);

        g.kruskal();

        canvas = new WindowManager(border, width, height, cell_w, cell_h,
                g.linhas_horizontais(), g.linhas_verticais());

        scr.add(canvas);
        scr.validate();

        //new Thread(new thr(canvas, g)).start();
    }

    public MazeGen(int w, int h) {
        width = w;
        height = h;

        scr = new JPanel();

        JPanel q = new JPanel();

        q.setLayout(new GridLayout(3, 1, 5, 10));

        JComboBox j = new JComboBox();
        j.addItem(new size(8, 6, "pequeno"));
        j.addItem(new size(20, 15, "medio"));
        j.addItem(new size(40, 30, "grande"));
        j.addActionListener(new size_listener());

        JButton b = new JButton("Reiniciar");

        JSlider slider = new JSlider(min_tm, max_tm, max_tm - def_tm);
        var.sleep = def_tm;

        slider.addChangeListener(new slider_listener());

        b.setMinimumSize(new Dimension(500, 500));

        b.addActionListener(new button_listener());

//        q.add(slider);
//        q.add(j);
//        q.add(b);
        scr.add(q);

//        re_size(cell_w, cell_h);
        re_size(25, 25);
        scr.add(canvas);

        add(scr);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Maze");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        MazeGen maze = new MazeGen(2500, 25000);
    }
}
