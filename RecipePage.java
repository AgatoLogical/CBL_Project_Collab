import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RecipePage extends JPanel implements ActionListener {

    static final int width = 575;
    static final int height = 775;
    static final Point leftCorner = new Point(575, 100);

    JButton unlockButton = new JButton();
    Recipe recipe;
    JPanel[] recipePanel = new JPanel[3];
    JLayeredPane layeredPane = new JLayeredPane();

    RecipePage() {

        this.setBounds((int) leftCorner.getX(), (int) leftCorner.getY(), width, height);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(false);

        recipePanel[0] = new JPanel();
        recipePanel[0].setBounds((int) leftCorner.getX() + 250, (int) leftCorner.getY() + 150, 150, 150);

        unlockButton.setBounds((int) leftCorner.getX() + 200, (int) leftCorner.getY() + 450, 200, 100);
        unlockButton.setFocusable(false);
        unlockButton.setBackground(new Color(100, 100, 100, 30));
        unlockButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 100)));
        unlockButton.addActionListener(this);

        layeredPane.setBounds((int) leftCorner.getX(), (int) leftCorner.getY(), width, height);
        layeredPane.add(recipePanel[0], JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(unlockButton, Integer.valueOf(2));
        this.add(layeredPane);

        // not complete
    }

    private void init(Recipe recip) {
        this.recipe = recip;
        recipe.setIcon(recip.getIcon());
        recipe.setHorizontalAlignment(JLabel.CENTER);
        recipe.setVerticalAlignment(JLabel.CENTER);
        this.recipePanel[0].add(recipe);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlockButton) {
            if (recipe.locked) {
                recipe.unlock();
                unlockButton.setEnabled(false);
                // unlockButton
                // not complete
            } else {
                unlockButton.setEnabled(false);
                // not complete
            }

        }
    }

    public void openPage(Recipe recip) {
        this.init(recip);
        this.setVisible(true);

    }
}
