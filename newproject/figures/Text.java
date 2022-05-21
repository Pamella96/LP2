package figures;

import java.awt.*;

public class Text extends Figure {

    protected String text;

    public Text(String text, int x, int y, int w, int h, int corDePreenchimento, int corDeBorda) {
        super(x, y, corDePreenchimento, corDeBorda, corDeBorda, corDeBorda);
        this.w = w;
        this.h = h;
        this.text = text;

    }

    public void print() {
        System.out.format("Texto de conteúdo %s na posição %d, %d.\n",
                this.text, this.x, this.y);
    }

    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.corDePreenchimento));
        g2d.setFont(new Font("Ink Free", Font.BOLD, this.w));
        g2d.drawString(this.text, this.x, this.y);

        if (focused) {
            g2d.setColor(Color.pink);
            g2d.drawString(this.text, this.x, this.y);
        }
    }

}