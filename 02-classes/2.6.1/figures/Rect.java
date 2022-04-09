package figures;

import java.awt.*;

public class Rect extends Figure {
    private int x, y;
    private int w, h;
    Color corDePreenchimento;
    Color corDeBorda;

    public Rect(int x, int y, int w, int h, Color corDePreenchimento, Color corDeBorda) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corDePreenchimento = corDePreenchimento;
        this.corDeBorda = corDeBorda;
    }

    public void print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
                this.w, this.h, this.x, this.y);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(corDeBorda);
        g2d.drawRect(this.x, this.y, this.w, this.h);
        g2d.setColor(corDePreenchimento);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }
}