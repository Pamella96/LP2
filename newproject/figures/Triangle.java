package figures;

import java.awt.*;
import java.awt.Color;

public class Triangle extends Figure {
    int a[] = { x, x + w / 2, x - w / 2 };
    int b[] = { y, y + h, y + h };
    int c = 3;

    public Triangle(int x, int y, int w, int h, int corDeBorda, int corDePreenchimento) {
        super(x, y, corDeBorda, corDePreenchimento, corDePreenchimento, corDePreenchimento);
        this.w = w;
        this.h = h;
        a = new int[] { x, x + w / 2, x - w / 2 };
        b = new int[] { y, y + h, y + h };
    }

    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        a = new int[] { x, x + w / 2, x - w / 2 };
        b = new int[] { y, y + h, y + h };
    }

    public void tamanho(int rw, int rh) {
        this.w += rw;
        this.h += rh;
        a = new int[] { x, x + w / 2, x - w / 2 };
        b = new int[] { y, y + h, y + h };
    }

    public void print() {
        System.out.format("triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint(Graphics g, boolean focused) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.colorBorder));
        g2d.fillPolygon(this.a, this.b, 3);
        g2d.setColor(new Color(this.colorFill));
        g2d.drawPolygon(this.a, this.b, 3);

        if (focused) {
            g2d.setColor(Color.GRAY);
            g2d.drawPolygon(this.a, this.b, 3);
        }
    }
}