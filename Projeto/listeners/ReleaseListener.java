package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Panels.RectPanel;
import figures.Rect;

public class ReleaseListener extends MouseAdapter {

    private RectPanel panel;

    public ReleaseListener(RectPanel panel) {
        super();
        this.panel = panel;

    }

    public void mouseReleased(MouseEvent e) {
        panel.addRect(new Rect(e.getX(), e.getY(), 24, 24));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

}