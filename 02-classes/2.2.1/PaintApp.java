import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50, 50, 100, 30, Color.black, Color.pink);
        this.r2 = new Rect(90, 90, 100, 40, Color.yellow, Color.black);
        this.r3 = new Rect(200, 200, 110, 50, Color.red, Color.orange);

    }

    public void paint(Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color corDeBack;
    Color corDeBorda;

    Rect(int x, int y, int w, int h, Color corDeBack, Color corDeBorda) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corDeBack = corDeBack;
        this.corDeBorda = corDeBorda;
    }

    void print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(corDeBack);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRect(this.x, this.y, this.w, this.h);
        g2d.setColor(corDeBorda);
        g2d.fillRect(this.x, this.y, this.w, this.h);

    }
}