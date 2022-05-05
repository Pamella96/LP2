import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Panels.*;
import listeners.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*;

class GraphicsEditor {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    String figuraSelecionada;
    Point prevPt = null;
    Point currentPt = null;

    ListFrame() {
        RectPanel panel = new RectPanel();
        EllipsePanel ePanel = new EllipsePanel();

        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {

                    }
                });
        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {

                        if (evt.getKeyChar() == 'r') {
                            figuraSelecionada = "rect";
                        }

                        if (evt.getKeyChar() == 'e') {
                            figuraSelecionada = "ellipse";
                        }

                        if (figuraSelecionada == "rect") {

                            setContentPane(panel);
                            panel.setSize(350, 350);
                            panel.addMouseListener(new ReleaseListener(panel));
                        }

                        if (figuraSelecionada == "ellipse") {

                            setContentPane(ePanel);
                            ePanel.setSize(350, 350);
                            ePanel.addMouseListener(new ReleaseListenerEllipse(ePanel));
                        }
                    }
                });

        this.setTitle("Graphics");
        this.setSize(350, 350);

        this.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent evt) {
                        prevPt = e.getPoint();

                    }
                });

        this.addMouseMotionListener(
                new MouseMotionAdapter() {
                    public void mouseDragged(MouseEvent evt) {

                    };

                });

    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Figure fig : this.figs) {
            fig.paint(g);
        }
    }
}