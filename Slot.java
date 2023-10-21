import java.awt.Point;
import javax.swing.JPanel;

public class Slot extends JPanel{

    public Point leftCorner;
    public static final int length = 50;
    public int pageID;
    public boolean isEmpty;
    public Item Item;

    public Slot(Point corner, int page) {
        this.leftCorner = corner;
        this.pageID = page;
        this.isEmpty = true;
    }

    public void add(Point corner, int page, Item item) {
        // ...
        isEmpty = false;
    }

    public void remove(Point corner, int page) {
        // ...
        isEmpty = true;
    }

    // will probably need some methods getPage , getCorner etc
}
