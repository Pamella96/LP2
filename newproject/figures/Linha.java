package figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Linha extends Figure {

    public Linha(int x, int y, int w, int h, int corDePreenchimento, int corDeBorda) {
        super(x, y, corDePreenchimento, corDeBorda, corDeBorda, corDeBorda);

        this.w = 40;
        this.h = 40;

    }

    public void print() {
        System.out.format("Linha de tamanho  (%d, %d) na posição: (%d, %d).\n",
                this.w, this.h, this.x, this.y);
    }

    public boolean clicked(int mx, int my) {
        return (this.x <= mx && mx <= this.x + this.w && this.y - 20 <= my && my <= this.y + 20);
    }

    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.corDePreenchimento));
        g2d.drawLine(this.x, this.y, this.x + this.w, this.y);

        if (focused) {
            g2d.setColor(Color.pink);
            g2d.drawLine(this.x, this.y, this.x + this.w, this.y);
        }
    }
}