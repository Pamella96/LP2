package listeners;

import Panels.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import figures.Ellipse;

public class ReleaseListenerEllipse extends MouseAdapter implements MouseListener {

    public EllipsePanel ePanel;

    public ReleaseListenerEllipse(EllipsePanel ePanel) {
        super();
        this.ePanel = ePanel;
    }

    public void mouseReleased(MouseEvent e) {
        ePanel.addEllipse(new Ellipse(e.getX(), e.getY(), 24, 24));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
