package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Ellipse extends Figure {
    public int x, y;
    public int w, h;

    public Ellipse(int x, int y, int w, int h, int corDeBorda, int corDePreenchimento) {
        super(x, y, corDeBorda, corDePreenchimento, corDePreenchimento, corDePreenchimento);
        this.w = w;
        this.h = h;

    }

    public void print() {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.corDePreenchimento));
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(this.corDeBorda));
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        if (focused) {
            g2d.setColor(Color.pink);
            g2d.drawOval(this.x, this.y, this.w, this.h);
        }
    }
}