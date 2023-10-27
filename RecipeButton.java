import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class RecipeButton extends JButton{
    
    private Item assignedItem;
    private ImageIcon itemIcon;
    private Image itemImg;
    Boolean unlocked = false;

    RecipeButton(Item item){
        this.setPreferredSize(new Dimension(80, 80));
        itemImg = item.getAssignedImage().getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        itemIcon = new ImageIcon(itemImg);
        this.setIcon(itemIcon);
        
        assignedItem = item;
    }

    public Item getItem(){
        return this.assignedItem;
    }


}
