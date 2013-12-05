/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze.generator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author lucasaoki
 */
public class WindowManager extends JPanel implements gancho {

    int border;
    int windowWidth, windowHeight;
    int linestroke;

    int passo_x, passo_y;

    boolean[][] horizLines;
    boolean[][] vertLines;

    String[][] state;

    public WindowManager(int border, int win_w, int win_h, int spaces_w, int spaces_h,
            boolean[][] hLines, boolean[][] vLines) {
        windowWidth = win_w;
        windowHeight = win_h;

        this.horizLines = hLines;
        this.vertLines = vLines;

        this.border = border;

        linestroke = spaces_h + spaces_w;

        passo_x = (windowWidth - 2 * border) / spaces_w;
        passo_y = (windowHeight - 2 * border) / spaces_h;

        setPreferredSize(new Dimension(win_w, win_h));
        setBackground(Color.white);
        setDoubleBuffered(true);
    }

    public void drawLine(Graphics2D g, int x0, int y0, int x1, int y1) {
        g.setStroke(new BasicStroke(linestroke));
        g.drawLine(border + x0 * passo_x,
                border + y0 * passo_y,
                border + x1 * passo_x,
                border + y1 * passo_y);
    }

    public void drawLines(Graphics2D g, boolean horizontal, boolean[][] m) {
        g.setColor(Color.black);

        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                if (horizontal && m[x][y]) {
                    drawLine(g, x, y, x + 1, y);
                } else if (!horizontal && m[x][y]) {
                    drawLine(g, x, y, x, y + 1);
                }
            }
        }
    }

    private void des_round(Graphics2D g, Color c, int i, int j, int s, int r) {
        g.setColor(c);

        int p_x = passo_x < s ? 1 : passo_x / s;
        int p_y = passo_y < s ? 1 : passo_y / s;

        g.fillRoundRect(border + p_x + i * passo_x,
                border + p_y + j * passo_y,
                passo_x - 2 * p_x,
                passo_y - 2 * p_y,
                r, r);
    }

    private void des_rect(Graphics2D g, Color c, int i, int j, int s) {
        g.setColor(c);

        int p_x = passo_x < s ? 1 : passo_x / s;
        int p_y = passo_y < s ? 1 : passo_y / s;

        g.fillRect(border + p_x + i * passo_x,
                border + p_y + j * passo_y,
                passo_x - 2 * p_x,
                passo_y - 2 * p_y);
    }

    public void drawState(Graphics2D g) {
        if (state == null) {
            return;
        }

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == null) {
                    g.setColor(Color.white);
                } else if (state[i][j].equals("topo")) {
                    des_round(g, Color.red, i, j, 12, 5);
                } else if (state[i][j].equals("caminho")) {
                    des_round(g, Color.magenta, i, j, 6, 10);
                } else if (state[i][j].equals("lixo")) {
                    des_rect(g, new Color(230, 230, 230), i, j, 4);
                } else if (state[i][j].equals("fim")) {
                    des_round(g, Color.cyan, i, j, 12, 5);
                }
            }
        }
    }

    public void draw(Graphics2D g) {

        drawLines(g, true, horizLines);
        drawLines(g, false, vertLines);
        drawState(g);

    }

    @Override
    public void paint(Graphics tela) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
//        tela = bi.createGraphics();
        Graphics g = bi.createGraphics();
        super.paint(g);
        draw((Graphics2D) g);

        super.paint(tela);
        draw((Graphics2D) tela);
        Toolkit.getDefaultToolkit().sync();
        try {
            ImageIO.write(bi, "PNG", new File("media/mapa.png"));
        } catch (IOException ex) {
            Logger.getLogger(WindowManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        tela.dispose();
        g.dispose();
    }

    static private String[][] array_copy(String[][] a) {
        String[][] r = new String[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                r[i][j] = a[i][j];
            }
        }

        return r;
    }

    @Override
    public void callback(String[][] m) {
        state = array_copy(m);
        repaint();
        try {
            Thread.sleep(var.sleep);
        } catch (InterruptedException ie) {
            System.out.println("Ahn?\n");
        }
    }
}
