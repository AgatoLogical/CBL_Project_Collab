import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class RecipePage extends JPanel implements ActionListener {

    static final int width = 575;
    static final int height = 775;
    static final Point leftCorner = new Point(575, 100);

    JButton unlockButton = new JButton();
    Recipe recipe;
    Recipe recipeParents[] = new Recipe[2];
    JPanel[] recipePanels = new JPanel[3];
    JLayeredPane layeredPane = new JLayeredPane();

    RecipePage() {

        // System.out.println("got to page constructor");

        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(false);

        Border lightBorder = BorderFactory.createDashedBorder(new Color(199, 163, 121),
                (float) 2.5, (float) 1, (float) 1, true);

        recipePanels[0] = new JPanel();
        recipePanels[0].setBounds((int) leftCorner.getX() + 250, (int) leftCorner.getY() + 150, 150, 150);
        recipePanels[0].setBorder(lightBorder);
        recipePanels[0].setVisible(true);

        recipePanels[1] = new JPanel();
        recipePanels[1].setBounds((int) leftCorner.getX() + 175, (int) leftCorner.getY() + 450, 100, 150);
        recipePanels[1].setVisible(false);

        recipePanels[2] = new JPanel();
        recipePanels[2].setBounds((int) leftCorner.getX() + 225, (int) leftCorner.getY() + 450, 100, 150);
        recipePanels[2].setVisible(false);

        unlockButton.setBounds((int) leftCorner.getX() + 200, (int) leftCorner.getY() + 475, 200, 100);
        unlockButton.setFocusable(false);
        unlockButton.setBackground(new Color(100, 100, 100, 30));
        unlockButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 100)));
        unlockButton.addActionListener(this);

        layeredPane.setBounds((int) leftCorner.getX(), (int) leftCorner.getY(), width, height);
        layeredPane.add(recipePanels[0], Integer.valueOf(1));
        layeredPane.add(recipePanels[1], Integer.valueOf(1));
        layeredPane.add(recipePanels[2], Integer.valueOf(1));
        layeredPane.add(unlockButton, Integer.valueOf(2));
        this.add(layeredPane);

        // not complete
    }

    private void init(Recipe recip) {

        // System.out.println("got to page init");

        this.recipe = recip;

        this.recipe.changeSize(recipe.image, 145);
        this.recipe.setIcon(recipe.image);
        this.recipe.setHorizontalAlignment(JLabel.CENTER);
        this.recipe.setVerticalAlignment(JLabel.CENTER);

        this.recipe.setText(recipe.name.toUpperCase());
        this.recipe.setHorizontalTextPosition(JLabel.CENTER);
        this.recipe.setVerticalTextPosition(JLabel.BOTTOM);
        this.recipe.setIconTextGap(+25);

        // System.out.println("name of recip: " + recipe.name);

        this.recipePanels[0].add(recipe);

        if (!recipe.locked) {

            this.unlockButton.setEnabled(false);
            this.unlockButton.setVisible(false);

            this.recipeParents[0] = (Recipe) RecipeBook.getRecipe(CombinationManager.getParent1(recip.name));
            // System.out.println("name of parent 1: " + recipeParents[0].name);
            this.recipeParents[0].changeSize(recipeParents[0].image, 75);
            this.recipeParents[0].setIcon(recipeParents[0].image);
            this.recipeParents[0].setHorizontalAlignment(JLabel.CENTER);
            this.recipeParents[0].setVerticalAlignment(JLabel.CENTER);

            this.recipeParents[0].setText(recipe.name.toUpperCase());
            this.recipeParents[0].setHorizontalTextPosition(JLabel.CENTER);
            this.recipeParents[0].setVerticalTextPosition(JLabel.BOTTOM);
            this.recipeParents[0].setIconTextGap(+10);

            this.recipePanels[1].add(recipeParents[0]);
            this.recipePanels[1].setVisible(true);

            this.recipeParents[1] = RecipeBook.getRecipe(CombinationManager.getParent2(recip.name));
            this.recipeParents[1].changeSize(recipeParents[1].image, 75);
            this.recipeParents[1].setIcon(recipeParents[1].image);
            this.recipeParents[1].setHorizontalAlignment(JLabel.CENTER);
            this.recipeParents[1].setVerticalAlignment(JLabel.CENTER);

            this.recipeParents[1].setText(recipe.name.toUpperCase());
            this.recipeParents[1].setHorizontalTextPosition(JLabel.CENTER);
            this.recipeParents[1].setVerticalTextPosition(JLabel.BOTTOM);
            this.recipeParents[1].setIconTextGap(+10);

            this.recipePanels[2].add(recipeParents[1]);
            this.recipePanels[2].setVisible(true);
        }

        // this.recipePanels[0]
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlockButton) {
            recipe.unlock();
            this.init(recipe);
        }
    }

    public void openPage(Recipe recip) {
        // System.out.println("got to open page");
        this.init(recip);
        this.setVisible(true);
        revalidate();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        revalidate();
        repaint();
    }
}
