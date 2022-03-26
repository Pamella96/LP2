import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main(String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1, e2, e3;

    public EllipseFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(50, 100, 100, 30, Color.black, Color.pink);
        this.e2 = new Ellipse(80, 150, 150, 40, Color.red, Color.yellow);
        this.e3 = new Ellipse(150, 200, 200, 35, Color.orange, Color.blue);
    }

    public void paint(Graphics g) {
        super.paint(g);

        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color corDeBack;
    Color corDeBorda;

    Ellipse(int x, int y, int w, int h, Color corDeBack, Color corDeBorda) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corDeBack = corDeBack;
        this.corDeBorda = corDeBorda;
    }

    void print() {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setColor(corDeBack);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(corDeBorda);
        g2d.fillOval(this.x, this.y, this.w, this.h);

    }
}