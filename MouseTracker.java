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
        this.add(mouseSlot);
        this.setVisible(true);
        // track mouse and make the slot follow it

        Reactor reactor = new Reactor();
        this.addMouseListener(reactor);
        DragReactor drag = new DragReactor();
        this.addMouseMotionListener(drag);
        System.out.println("mouseslot is created");
    }

    private class Reactor extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            prevPoint = e.getPoint();
            System.out.println("mouse pressed in mouseslot");
        }

        public void mouseReleased(MouseEvent e) {
            mouseSlot.remove(mouseSlot.component);
            System.out.println("mouse released in mouseslot");
            System.out.println("mouse doesn't have component");
        }

        public void mouseMoved(MouseEvent e) {
            mouseSlot.leftCorner = new Point((int) e.getPoint().getX(), (int) e.getPoint().getY());
            System.out.println("mouse is moving");
        }
    }

    private class DragReactor extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e) {

            Point currentPoint = e.getPoint();

            mouseSlot.leftCorner.translate(((int) (currentPoint.getX() - prevPoint.getX())),
                    ((int) (currentPoint.getY() - prevPoint.getY())));

            prevPoint = currentPoint;

            repaint();

            System.out.println("mouse dragged");
        }
    }

    public void paint(Graphics g) {
        super.paintComponents(g);
        mouseSlot.paintImmediately((int) mouseSlot.leftCorner.getX(), (int) mouseSlot.leftCorner.getX(), width, height);
    }

}
