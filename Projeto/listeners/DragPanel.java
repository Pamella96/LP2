package listeners;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import figures.Rect;

import javax.swing.JPanel;

public class DragPanel extends JPanel {

  figures.Rect fig = new figures.Rect(0, 0, 0, 0);

  Point figCorner;
  Point prevPt;

  public DragPanel() {

    figCorner = new Point(0, 0);
    ClickListener clickListener = new ClickListener();
    DragPanel dragListener = new DragPanel();
    this.addMouseListener(clickListener);
    this.addMouseMotionListener(dragListener);

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

  }

  public class ClickListener extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
      prevPt = e.getPoint();
    }
  }

  public class DragListener extends MouseMotionAdapter {

    public void mouseDragged(MouseEvent e) {

      Point currentPt = e.getPoint();

      figCorner.translate(

          (int) (currentPt.getX() - prevPt.getX()),
          (int) (currentPt.getY() - prevPt.getY()));
      prevPt = currentPt;
      repaint();
    }
  }
}
