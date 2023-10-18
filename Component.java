import java.util.*;
import javax.swing.*;

public class Component extends JLabel {

    public String name = "";
    public int value = 0;
    public ImageIcon icon = new ImageIcon("blank_image");
    public String category = "";

    private static final int valueIncrease = 50;

    public static Map<Composite, String> originMap = new HashMap<Composite, String>(26);
    public static Map<String, Composite> componentMap = new HashMap<String, Composite>(30);

    public void init() {

        /*---------------------------------------NATURE---------------------------------------*/

        // componentMap.put("fire", new Composite(valueIncrease * 0, new
        // ImageIcon("fire.png"), "Nature"));
        // componentMap.put("air", new Composite(valueIncrease * 0, new
        // ImageIcon("air.png"), "Nature"));
        // componentMap.put("water", new Composite(valueIncrease * 0, new
        // ImageIcon("water.png"), "Nature"));
        // componentMap.put("earth", new Composite(valueIncrease * 0, new
        // ImageIcon("earth.png"), "Nature"));
        // componentMap.put("lava", new Composite(valueIncrease * 1, new
        // ImageIcon("lava.png"), "Nature"));
        // componentMap.put("mud", new Composite(valueIncrease * 1, new
        // ImageIcon("mud.png"), "Nature"));
        // componentMap.put("plant", new Composite(valueIncrease * 1, new
        // ImageIcon("plant.png"), "Nature"));

        originMap.put(new Composite("earth", "water"), "mud");
        // im not sure how 2 components with the same "origin" / "parents" would work
        originMap.put(new Composite("??", "water"), "plant");
        originMap.put(new Composite("earth", "fire"), "lava");
        originMap.put(new Composite("plant", "water"), "tree");
        originMap.put(new Composite("air", "earth"), "dust");
        originMap.put(new Composite("tree", "earth"), "wood");
        originMap.put(new Composite("stone", "air"), "sand");
        originMap.put(new Composite("air", "fire"), "energy");

        /*--------------------------------------STONE AGE--------------------------------------*/
        originMap.put(new Composite("lava", "air"), "stone");
        originMap.put(new Composite("water", "wood"), "boat");
        originMap.put(new Composite("sand", "mud"), "clay");
        originMap.put(new Composite("clay", "fire"), "pottery");
        originMap.put(new Composite("wood", "stone"), "tools");
        originMap.put(new Composite("wood", "tools"), "wheel");
        originMap.put(new Composite("earth", "tools"), "farming");
        originMap.put(new Composite("stone", "tools"), "gold");

        /*---------------------------------------IRON AGE---------------------------------------*/
        originMap.put(new Composite("fire", "stone"), "metal");
        originMap.put(new Composite("metal", "wood"), "sword");
        originMap.put(new Composite("wheel", "water"), "water wheel");
        originMap.put(new Composite("fire", "sand"), "glass");
        originMap.put(new Composite("metal", "glass"), "mirror");
        originMap.put(new Composite("tools", "gold"), "coins");

        /*--------------------------------------MODERN AGE--------------------------------------*/
        originMap.put(new Composite("fire", "dust"), "gunpowder");
        originMap.put(new Composite("gunpowder", "fire"), "explosion");
        originMap.put(new Composite("energy", "explosion"), "atomic bomb");
        originMap.put(new Composite("metal", "energy"), "electricity");
        originMap.put(new Composite("electricity", "tools"), "computer");
        originMap.put(new Composite("glass", "electricity"), "lightbulb");
        // pressure? air + air? we would need to delete something
        originMap.put(new Composite("wood", "??"), "paper");
        originMap.put(new Composite("paper", "gold"), "money");
    }

    public Component combine(String item1, String item2) {
        return new Component((String) originMap.get(new Composite(item1, item2)));
    }

    public Component(String name1, String name2) {

        this.name = combine(name1, name2).getName();

        Composite comp = new Composite();
        comp = (Composite) componentMap.get(name);
        this.icon = comp.getImage();
        this.value = comp.getNumber();
        this.category = comp.getString();
    }

    public Component(String name) {

        this.name = name;

        Composite comp = new Composite("", "");
        comp = (Composite) (componentMap.get(name));
        this.icon = comp.getImage();
        this.value = comp.getNumber();
        this.category = comp.getString();
    }

    public Component() {
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public static void main(String[] args) {
        Component component = new Component("mud");
        component.init();

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setTitle("test component");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.add(component);
        component.setVisible(true);
    }
}