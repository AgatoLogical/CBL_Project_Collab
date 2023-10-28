import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Item extends JLabel {
    public String name;
    // public final int value = 0;

    public ImageIcon image;

    int slotNumber;

    Boolean isDicovered = false;

    // Andreea
    private int valueOfItem = 0;
    private static final int valueIncrease = 100;

    public Item(ImageIcon icon, int category) {
        name = icon.getDescription();
        image = icon;
        this.setIcon(icon);
        this.setVisible(false);
        this.valueOfItem = valueIncrease * category;
    }

    public int getValue() {
        return valueOfItem;
    }

    public ImageIcon getAssignedImage() {
        return this.image;
    }

}