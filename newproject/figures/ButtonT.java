package figures;

import java.awt.*;

public class ButtonT extends Figure {

    protected String text;

    public ButtonT(String text, int x, int y, int w, int h, int corDePreenchimento, int colorBorder) {
        super(x, y, corDePreenchimento, colorBorder, colorBorder, colorBorder);
        this.w = w;
        this.h = h;
        this.text = text;

    }

    public void paint(Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Ink Free", Font.BOLD, this.w / 3));
        g2d.setColor(new Color(this.colorBorder));
        g2d.drawString(this.text, this.x, this.y);
        g2d.drawString(this.text, this.x, this.y);

    }

}