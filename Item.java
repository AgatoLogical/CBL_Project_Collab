import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Item extends JLabel{
    public String name;
    public final int value = 0;

    ImageIcon image;

    Point imageCorner;
    Point prevPt;

    int slotNumber;

    public Item(ImageIcon icon) {
        image = icon;
        this.setIcon(icon);
        this.setVisible(false);
        imageCorner = new Point(0, 0);
    }

    public void moveBack(Timer timer){
        timer.start();
    }

}