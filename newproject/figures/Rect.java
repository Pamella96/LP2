package figures;

import java.awt.*;
import java.awt.Color;

public class Rect extends Figure {
    public int x, y;
    public int w, h;

    public Rect(int x, int y, int w, int h, int corDePreenchimento, int corDeBorda) {
        super(x, y, corDePreenchimento, corDeBorda, corDeBorda, corDeBorda);
        this.w = w;
        this.h = h;
        this.corDePreenchimento = corDePreenchimento;
        this.corDeBorda = corDeBorda;

    }

    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(5));

        g2d.setColor(new Color(this.corDePreenchimento));
        g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setColor(new Color(this.corDeBorda));
        g2d.drawRect(this.x, this.y, this.w, this.h);

        if (focused) {
            g2d.setColor(Color.pink);
            g2d.drawRect(this.x, this.y, this.w, this.h);
        }
    }

}