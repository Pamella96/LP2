import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rect = new ArrayList<Rect>();
    ArrayList<Ellipse> ellip = new ArrayList<Ellipse>();
    Random rand = new Random();

    ListFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });

        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {
                        if (evt.getKeyChar() == 'r') {
                            int x = rand.nextInt(350);
                            int y = rand.nextInt(350);
                            int w = rand.nextInt(50);
                            int h = rand.nextInt(50);

                            rect.add(new Rect(x, y, w, h)); // outer.rs.add();
                            repaint(); // outer.repaint()
                        }

                        if (evt.getKeyChar() == 'e') {
                            int x = rand.nextInt(350);
                            int y = rand.nextInt(350);
                            int w = rand.nextInt(50);
                            int h = rand.nextInt(50);

                            ellip.add(new Ellipse(x, y, w, h)); // outer.el.add();
                            repaint(); // outer.repaint()
                        }
                    }
                });

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Figure rect : this.rect) {
            rect.paint(g);
        }

        for (Figure ellip : this.ellip) {
            ellip.paint(g);
        }
    }
}