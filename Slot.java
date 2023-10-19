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
    public Component component;

    public Slot(Point corner, int page) {
        this.leftCorner = corner;
        this.pageID = page;

        PressReactor pressReactor = new PressReactor();
        this.addMouseListener(pressReactor);

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

    public Component remove(Point corner, int page) {

        Component itemInSpot;
        itemInSpot = component;
        this.component = null;

        isEmpty = true;
        return itemInSpot;
    }

    public class PressReactor extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            MouseTracker mouse = new MouseTracker();

            // getting the component from the slot?????????????
            List<JLabel> list = new ArrayList<JLabel>();
            JComponent[] components = panel.getComponents();

            for (JComponent component : components) {
                if (component.getClass().equals(JLabel.class)) {
                    list.add((JLabel) component);
                }
            }
            mouse.mouseSlot.add(list.get(0));
        }

    }
}
