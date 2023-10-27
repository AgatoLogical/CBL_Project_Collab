import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Item extends JLabel{
    public String name;
    //public final int value = 0;

    ImageIcon image;

    int slotNumber;

    //Andreea
    private int valueOfItem = 0;
    private static final int valueIncrease = 100;

    public Item(ImageIcon icon, int category, String nameStr) {
        name = nameStr;
        image = icon;
        this.setIcon(icon);
        this.setVisible(false);
        this.valueOfItem = valueIncrease * category;
    }

    public int getValue() {
        return valueOfItem;
    }

    public ImageIcon getAssignedImage(){
        return this.image;
    }


}