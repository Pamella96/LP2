package figures;

import java.io.Serializable;
import ivisible.IVisible;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
    protected int colorFill, colorBorder;

    public Figure(int x, int y, int w, int h, int colorFill, int colorBorder) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    public Figure(int x2, int y2, Color colorFill2, Color colorBorder2) {
    }

    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked(int mx, int my) {
        return (this.x <= mx && mx <= this.x + this.w && this.y <= my && my <= this.y + this.h);
    }

    public void tamanho(int w, int h) {
        if (this.w >= 30 && this.w <= 200) {
            if (this.w == 200) {
                w = -5;
                h = -5;
            } else if (this.w == 30) {
                w = +5;
                h = +5;
            }

            this.w += w;
            this.h += h;
        }
    }

    public abstract void paint(Graphics g, boolean focused);
}