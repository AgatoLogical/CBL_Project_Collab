import javax.swing.*;

public class Item extends JLabel{
    String name;
    ImageIcon image;
    int slotNumber;
    Boolean isDicovered = false;
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

    /*public ImageIcon getAssignedImage(){
        return this.image;
    }*/

}