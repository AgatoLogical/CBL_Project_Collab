import java.awt.Point;
import javax.swing.*;

public class Slot extends JPanel {

    public Point leftCorner;
    public static final int length = 100;

    public int pageID;

    public boolean isEmpty;
    public Component component;

    public Slot(Point corner, int page, Component item) {
        this.leftCorner = corner;
        this.pageID = page;
        this.component = item;
    }

    /**
     * @param corner
     * @param page
     * @param item
     * @return itemInSlot: stores the component that was previously in that slot,
     *         otherwise it returns nothing
     */
    public void add(Point corner, int page, Component item) {

        // Component itemInSlot = new Component();
        // if (!isEmpty) {
        // itemInSlot = component;
        // }

        this.component = item;

        isEmpty = false;
        // if (itemInSlot.getName().equals(null)) {
        // return null;
        // }

        // return itemInSlot;
    }

    public Component remove(Point corner, int page) {

        Component itemInSpot;
        itemInSpot = component;
        this.component = null;

        isEmpty = true;
        return itemInSpot;
    }

    // will probably need some methods getPage , getCorner etc
}
