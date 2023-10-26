import javax.swing.*;

public class Recipe extends Component {

    public boolean locked;
    private final ImageIcon lockIcon = new ImageIcon("lock.png");
    private ImageIcon compIcon;
    String name;

    public Recipe(ImageIcon compIcon) {
        super(compIcon);
        name = compIcon.getDescription();
        this.setIcon(lockIcon);
        this.setVisible(false);
        locked = true;
    }

    public void unlock() {
        this.setIcon(compIcon);
        locked = false;
    }
}
