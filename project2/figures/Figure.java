package figures;

import java.awt.*;

public abstract class Figure {

    public abstract void paint(Graphics g);

    int x;
    int y;
    int w;
    int h;
    Color corDePreenchimento;
    Color corDeBorda;

    public Figure(int x, int y, int w, int h, Color corDePreenchimento, Color corDeBorda) {

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corDePreenchimento = corDePreenchimento;
        this.corDeBorda = corDeBorda;

    }
}