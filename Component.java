import java.awt.*;
import javax.swing.*;

public class Component extends JLabel{
    public String name;
    public final int value = 0;

    public Component(ImageIcon icon){
        this.setIcon(icon);
        this.setVisible(false);
    }

    public String combine(String item1, String item2) {
        this.setVisible(true);
        return null;
    }
}