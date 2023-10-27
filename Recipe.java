import java.awt.Image;

import javax.swing.*;

public class Recipe extends Item {

    public boolean locked;
    private ImageIcon lockIcon = new ImageIcon("lock.png");
    public String name = "";

    public Recipe(ImageIcon compIcon, int category) {
        super(compIcon, category);
        super.image = changeSize(compIcon);
        this.name = compIcon.getDescription();
        lockIcon = changeSize(lockIcon);
        this.setIcon(lockIcon);
        this.setVisible(false);
        locked = true;
    }

    public void unlock() {
        this.setIcon(super.image);
        locked = false;
    }

    private ImageIcon changeSize(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(55, 55, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    // public ImageIcon getIconOfItem() {
    // return super.image;
    // }
}
