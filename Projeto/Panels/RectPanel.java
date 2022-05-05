package Panels;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import figures.Rect;

public class RectPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    public List<Rect> rects = new LinkedList<Rect>();

    public void addRect(Rect rect) {
        rects.add(rect);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        for (Rect r : rects) {
            r.paint(g);
        }
    }
}
