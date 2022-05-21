import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.lang.String;
import java.io.*;

import figures.*;

class ListApp {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
        frame.setFocusTraversalKeysEnabled(false);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();

    Random rand = new Random();
    Point mouse = null;
    Point PositionMouse = null;
    Figure focused = null;
    Button focus_but = null;
    int cont = 0;
    int i;

    ListFrame() {

        buts.add(new Button(0, new Rect(0, 0, 0, 0, 0, 0)));
        buts.add(new Button(1, new Ellipse(50, 50, 0, 0, 0, 0)));
        buts.add(new Button(2, new Linha(50, 50, 0, 0, 0, 0)));
        buts.add(new Button(3, new Text("T", 0, 0, 0, 0, 0, 0)));

        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            figs = (ArrayList<Figure>) o.readObject();
            o.close();
        }

        catch (Exception x) {
            System.out.println("ERRO");
        }

        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        try {
                            FileOutputStream f = new FileOutputStream("proj.bin");
                            ObjectOutputStream o = new ObjectOutputStream(f);
                            o.writeObject(figs);
                            o.flush();
                            o.close();
                        } catch (Exception x) {
                            System.out.println("ERRO");
                        }

                        System.exit(0);
                    }
                });

        this.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent evt) {
                        mouse = getMousePosition();
                        focused = null;

                        for (int i = 0; i < figs.size(); i++) {
                            if (figs.get(i).clicked(mouse.x, mouse.y)) {
                                focused = figs.get(i);
                                cont = i + 1;

                            } else {
                                if (focused != null) {
                                    int dx = evt.getX() - mouse.x;
                                    int dy = evt.getY() - mouse.y;
                                    focused.drag(dx, dy);
                                }

                            }
                        }

                        repaint();

                    }
                });

        this.addMouseMotionListener(
                new MouseAdapter() {
                    public void mouseDragged(MouseEvent evt) {
                        if (focused != null) {
                            int dx = evt.getX() - mouse.x;
                            int dy = evt.getY() - mouse.y;
                            focused.drag(dx, dy);

                        }
                        mouse = evt.getPoint();
                        repaint();

                    }
                });

        this.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {

                        PositionMouse = getMousePosition();
                        int x = PositionMouse.x;
                        int y = PositionMouse.y;
                        int w = rand.nextInt(180);
                        int h = rand.nextInt(180);

                        int corDeBorda = rand.nextInt(250);
                        int corDePreenchimento = rand.nextInt(150);

                        if (evt.getKeyChar() == 'r') {
                            focused = new Rect(x, y, w, h, corDeBorda, corDePreenchimento);
                            figs.add(focused);
                        } else if (evt.getKeyChar() == 'e') {
                            focused = new Ellipse(x, y, w, h, corDeBorda, corDePreenchimento);
                            figs.add(focused);
                        } else if (evt.getKeyChar() == 'l') {
                            focused = new Linha(x, y, w, h, corDeBorda, corDePreenchimento);
                            figs.add(focused);
                        } else if (evt.getKeyChar() == 't') {
                            focused = new Text("projeto", x, y, w, h, corDeBorda, corDePreenchimento);
                            figs.add(focused);
                        } else if (focused != null) {
                            if (evt.getKeyCode() == KeyEvent.VK_UP) {
                                focused.drag(0, -10);
                            } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                                focused.drag(0, 10);
                            } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                                focused.drag(-10, 0);
                            } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                                focused.drag(10, 0);
                            } else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                                figs.remove(focused);
                                focused = null;
                            }

                            figs.remove(focused);
                            figs.add(focused);
                            i++;
                            if (i >= figs.size()) {
                                i = 0;
                            }
                        }

                        repaint();
                    }
                });

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Button but : this.buts) {
            but.paint(g, but == focus_but);
        }
        for (Figure fig : this.figs) {
            fig.paint(g, fig == focused);
        }
    }
}