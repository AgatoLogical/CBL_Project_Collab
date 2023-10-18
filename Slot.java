import java.awt.Point;

public class Slot {

    public Point leftCorner;
    public static final int length = 0;
    public int pageID;
    public boolean isEmpty;
    public Component component;

    public Slot(Point corner, int page, Component item) {
        this.leftCorner = corner;
        this.pageID = page;
        this.component = item;
    }

    public void add(Point corner, int page, Component item) {
        // ...
        isEmpty = false;
    }

    public void remove(Point corner, int page) {
        // ...
        isEmpty = true;
    }

    // will probably need some methods getPage , getCorner etc
}
