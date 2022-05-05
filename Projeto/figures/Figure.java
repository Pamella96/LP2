package figures;

import java.awt.Graphics;

public abstract class Figure {
    public abstract void paint (Graphics g);
    
    int x, y;
    int w, h;

    public Figure (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = y;
        this.h = h;
    }
}