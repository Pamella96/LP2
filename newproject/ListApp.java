import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.lang.String;
import java.io.*;
import javax.swing.JOptionPane;
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
    Rect aux = new Rect(0, 0, 13, 13, 255, 238);
    Point mouse = null;
    Point PositionMouse = null;
    Figure focused = null;
    Figure focusedAux = null;
    Button focus_but = null;
    boolean clickedBut = false;
    boolean but_aux = false;
    int cont = 0;
    int i, x, y, w, h, colorFill, colorBorder, posx = 0, posy = 0, indice;
    boolean auxKey = false;

    ListFrame() {

        buts.add(new Button(0, new Rect(0, 0, 0, 0, 0, 0)));
        buts.add(new Button(1, new Ellipse(50, 50, 0, 0, 0, 0)));
        buts.add(new Button(2, new Line(50, 50, 0, 0, 0, 0)));
        buts.add(new Button(3, new Triangle(0, 0, 0, 0, 0, 0)));
        buts.add(new Button(4, new ButtonT("Clear", 0, 0, 0, 0, 0, 0)));

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

                        focused = null;
                        auxKey = false;
                        mouse = evt.getPoint();

                        if (but_aux && focus_but != null) {
                            if (!(mouse.x < 60 && mouse.y < 680) && focus_but.idx != 9 && focus_but.idx != 12) {
                                figureBut(focus_but.idx, mouse.x, mouse.y);
                                but_aux = false;
                                focus_but = null;
                            }
                            repaint();
                        }

                        for (Button but : buts) {
                            if (but.clicked(mouse.x, mouse.y)) {
                                focus_but = but;
                                but_aux = true;

                                if (but.idx > 4) {
                                    figureBut(focus_but.idx, mouse.x, mouse.y);
                                }
                            }
                        }

                        for (int i = 0; i < figs.size(); i++) {
                            if (figs.get(i).clicked(mouse.x, mouse.y)) {
                                focused = figs.get(i);
                                focusedAux = focused;

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

                        int colorBorder = rand.nextInt(250);
                        int colorFill = rand.nextInt(150);

                        if (evt.getKeyChar() == 'r') {
                            focused = new Rect(x, y, w, h, colorBorder, colorFill);
                            figs.add(focused);
                        } else if (evt.getKeyChar() == 'e') {
                            focused = new Ellipse(x, y, w, h, colorBorder, colorFill);
                            figs.add(focused);
                        } else if (evt.getKeyChar() == 'l') {
                            focused = new Line(x, y, w, h, colorBorder, colorFill);
                            figs.add(focused);
                        } else if (evt.getKeyChar() == 't') {
                            focused = new Triangle(x, y, w, h, colorBorder, colorFill);
                            figs.add(focused);
                        }

                else if (focused != null) {
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

                        }

                        repaint();
                    }
                });

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
        this.getContentPane().setBackground(Color.white);
    }

    public void figureBut(int idx, int x, int y) {
        if (idx == 0) {
            Figure fig = new Rect(x, y, w, h, colorBorder, colorFill);
            figs.add(fig);
            focused = fig;
            indice = idx;
        } else if (idx == 1) {
            Figure fig = new Ellipse(x, y, w, h, colorBorder, colorFill);
            figs.add(fig);
            focused = fig;

        } else if (idx == 2) {
            Figure fig = new Line(x, y, w, h, colorBorder, colorFill);
            figs.add(fig);
            focused = fig;
        } else if (idx == 3) {
            Figure fig = new Triangle(x, y, w, h, colorBorder, colorFill);
            figs.add(fig);
            focused = fig;

        } else if (idx == 4) {
            int i = JOptionPane.showConfirmDialog(null, "clear?", "clear", JOptionPane.YES_NO_OPTION);

            if (i == JOptionPane.YES_OPTION) {
                figs.clear();
            } else if (i == JOptionPane.NO_OPTION) {
                System.out.close();
            }

        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Button but : this.buts) {
            but.paint(g, but == focus_but);
        }
        for (Figure fig : this.figs) {
            fig.paint(g, fig == focused);
        }
        if (focused != null) {
            aux.x = focused.x + (focused.w + 13);
            aux.y = focused.y + (focused.h + 13);
            aux.paint(g, true);

        }
    }
}