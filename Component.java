import java.awt.*;
import javax.swing.*;

public class Component extends JLabel{
    public String name;
    public final int value = 0;
    public String parent1;
    public String parent2;

    public Component(String initParent1, String initParent2, ImageIcon icon){
        this.parent1 = initParent1;
        this.parent2 = initParent2;
        this.setIcon(icon);
        this.setVisible(false);
    }

    // icon

    // category

    public String combine(String item1, String item2) {
        this.setVisible(true);
        return null;
    }
}