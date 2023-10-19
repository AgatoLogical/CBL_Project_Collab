import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;

public class Slot extends JPanel {

    public Point leftCorner;
    public static final int length = 100;

    public int pageID;

    public boolean isEmpty;
    public Component component = new Component("", "", null);

    PressReactor pressReactor = new PressReactor();

    public Slot(Point corner, int page) {
        this.leftCorner = corner;
        this.pageID = page;

        this.addMouseListener(pressReactor);

    }

    public Component add(Component comp) {
        this.addImpl(comp, null, -1);
        this.component = comp;
        return comp;
    }

    /**
     * @param corner
     * @param page
     * @param item
     * @return itemInSlot: stores the component that was previously in that slot,
     *         otherwise it returns nothing
     */
    // public void add(Point corner, int page, Component item) {

    // // Component itemInSlot = new Component();
    // // if (!isEmpty) {
    // // itemInSlot = component;
    // // }

    // this.component = item;

    // isEmpty = false;
    // // if (itemInSlot.getName().equals(null)) {
    // // return null;
    // // }

    // // return itemInSlot;
    // }

    // public Component remove(Point corner, int page) {

    // Component itemInSpot;
    // itemInSpot = component;
    // this.component = null;

    // isEmpty = true;
    // return itemInSpot;
    // }

    public class PressReactor extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            System.out.println("mouse pressed in slot");
            MouseTracker mouse = Workshop.mouse;

            // getting the component from the slot?????????????
            mouse.mouseSlot.add(component);
            Slot.this.component = mouse.mouseSlot.component;
            repaint();
            System.out.println("mouse has component: " + mouse.mouseSlot.component.parent1);
        }

    }
}
