import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RecipePage extends JPanel implements ActionListener {

    JButton unlockButton = new JButton();
    Recipe recipe;
    RecipeBook recipeBook = new RecipeBook();
    JPanel[] recipePanel = new JPanel[3];

    RecipePage(ImageIcon compIcon) {
        this.recipe = recipeBook.getRecipe(compIcon);
        this.recipePanel[0].add(recipe);
        this.recipePanel[0].setBounds(600 + 250, 300, 100, 100);

        this.setBounds(600, 0, 600 - 25, 800 - 25);
        this.setBackground(new Color(0, 0, 0, 0));

        this.unlockButton.setBounds(600 + 200, 500, 200, 100);
        this.unlockButton.setFocusable(false);
        this.unlockButton.setBackground(new Color(100, 100, 100, 30));
        this.unlockButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 100)));
        this.unlockButton.addActionListener(this);

        // not complete
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlockButton) {
            if (recipe.locked) {
                recipe.unlock();
                unlockButton.setEnabled(false);
                // not complete
            } else {
                unlockButton.setEnabled(false);
                // not complete
            }

        }
    }
}
