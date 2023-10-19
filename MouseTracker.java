import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class MouseTracker extends JPanel {

    public static Slot mouseSlot = new Slot(null, 1);
    Point prevPoint;

    static final int width = 100;
    static final int height = 100;

    MouseTracker() {

        // track mouse and make the slot follow it

        Reactor reactor = new Reactor();
        mouseSlot.addMouseListener(reactor);
        DragReactor drag = new DragReactor();
        mouseSlot.addMouseMotionListener(drag);
    }

    private class Reactor extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            prevPoint = e.getPoint();
        }

        public void mouseReleased(MouseEvent e) {
            mouseSlot.removeAll();
        }

        public void mouseMoved(MouseEvent e) {
            mouseSlot.leftCorner = new Point((int) e.getPoint().getX(), (int) e.getPoint().getY());
        }
    }

    private class DragReactor extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {

            Point currentPoint = e.getPoint();

            mouseSlot.leftCorner.translate(((int) (currentPoint.getX() - prevPoint.getX())),
                    ((int) (currentPoint.getY() - prevPoint.getY())));

            prevPoint = currentPoint;

            repaint();
        }
    }

    public void paint(Graphics g) {
        super.paintComponents(g);
        mouseSlot.paintImmediately((int) mouseSlot.leftCorner.getX(), (int) mouseSlot.leftCorner.getX(), width, height);
    }

}
