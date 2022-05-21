package figures;

import java.awt.*;

public class Triangle extends Figure {
    int x1, x2, x3;
    int y1, y2, y3;
    Color corDePreenchimento;
    Color corDeBorda;

    public Triangle(int num1, int num2, int num3, int num4, int num5, int num6, Color corDePreenchimento,
            Color corDeBorda) {
        this.x1 = num1;
        this.x2 = num2;
        this.x3 = num3;
        this.y1 = num4;
        this.y2 = num5;
        this.y3 = num6;
        this.corDePreenchimento = corDePreenchimento;
        this.corDeBorda = corDeBorda;

    }

    public void print() {

    }

    public void paint(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        int[] xPoints = { this.x1, this.x2, this.x3 };
        int[] yPoints = { this.y1, this.y2, this.y3 };
        g2d.setColor(corDePreenchimento);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.setColor(corDeBorda);

        g2d.drawPolygon(xPoints, yPoints, 3);
    }

}