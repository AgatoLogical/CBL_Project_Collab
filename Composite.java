import javax.swing.*;

/*  
 * Stores 2 string keys in alphabetical order and other objects
 */

import javax.swing.ImageIcon;

public class Composite {
    String key1;
    String key2;

    ImageIcon image = new ImageIcon("blank_image");
    int number = 0;
    String string = "";

    public Composite(String key1, String key2) {
        if (key1.compareTo(key2) <= 0) {
            this.key1 = key1;
            this.key2 = key2;
        } else {
            this.key1 = key2;
            this.key2 = key1;
        }
    }

    public Composite(int number, ImageIcon image, String string) {
        this.image = image;
        this.number = number;
        this.string = string;

        this.key1 = "";
        this.key2 = "";
    }

    public Composite() {
    }

    public ImageIcon getImage() {
        return image;
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }
}
