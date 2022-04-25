package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Panels.EllipsePanel;
import figures.Ellipse;

public class ClickListener extends MouseAdapter {

    private EllipsePanel panel;

    public ClickListener(EllipsePanel panel) {
        super();
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panel.addEllipse(new Ellipse(e.getX(), e.getY(), 24, 24));
    }
}