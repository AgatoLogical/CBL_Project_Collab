import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class RecipePage extends JPanel implements ActionListener {

    static final int width = 490;
    static final int height = 510;
    // static final Point leftCorner = new Point(575, 100);
    static final Point leftCorner = new Point(0, 0);

    ImageIcon unlockIcon = new ImageIcon("unlock_button.png");
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

        layeredPane.setBounds(0, 0, width, height);

        Border lightBorder = BorderFactory.createDashedBorder(new Color(199, 163, 121),
                (float) 2.5, (float) 1, (float) 1, true);

        recipePanels[0] = new JPanel();
        recipePanels[0].setBackground(new Color(0, 0, 0, 0));
        recipePanels[0].setBounds((int) (width / 2) - 75, 25, 150, 150);
        recipePanels[0].setOpaque(true);
        recipePanels[0].setLayout(null);
        recipePanels[0].setBorder(lightBorder);

        recipePanels[1] = new JPanel();
        recipePanels[1].setBackground(new Color(0, 0, 0, 0));
        recipePanels[1].setBounds((int) (width / 2) - 100, (int) (height / 2) + 40, 100, 100);
        recipePanels[1].setOpaque(false);
        recipePanels[1].setLayout(null);
        recipePanels[1].setBorder(lightBorder);

        recipePanels[2] = new JPanel();
        recipePanels[2].setBackground(new Color(0, 0, 0, 0));
        recipePanels[2].setBounds((int) (width / 2), (int) (height / 2) + 40, 100, 100);
        recipePanels[2].setOpaque(false);
        recipePanels[2].setLayout(null);
        recipePanels[2].setBorder(lightBorder);

        unlockButton.setBounds((int) (width / 2) - 100, (int) (height / 2) + 40, 200, 70);
        unlockButton.setFocusable(false);
        unlockButton.setBackground(new Color(100, 100, 100, 0));
        unlockButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        Image image = unlockIcon.getImage();
        Image newimg = image.getScaledInstance(200, 70, java.awt.Image.SCALE_SMOOTH);
        unlockIcon = new ImageIcon(newimg);
        unlockButton.setIcon(unlockIcon);
        unlockButton.addActionListener(this);

        layeredPane.add(recipePanels[0], Integer.valueOf(3));
        layeredPane.add(recipePanels[1], Integer.valueOf(3));
        layeredPane.add(recipePanels[2], Integer.valueOf(3));
        layeredPane.add(unlockButton, Integer.valueOf(4));
        this.add(layeredPane);

        // not complete
    }

    private void init(Recipe recip) {

        // System.out.println("got to page init");

        this.recipe = recip;

        // this.recipe.setBackground(new Color(0, 0, 0, 0));
        // // this.recipe.setBounds((int) leftCorner.getX() + 250, (int)
        // leftCorner.getY()
        // // + 150, 150, 150);

        // this.recipe.changeSize(recipe.image, 145);
        // this.recipe.setIcon(recipe.image);
        // this.recipe.setHorizontalAlignment(JLabel.CENTER);
        // this.recipe.setVerticalAlignment(JLabel.CENTER);

        // this.recipe.setText(recipe.name.toUpperCase());
        // this.recipe.setHorizontalTextPosition(JLabel.CENTER);
        // this.recipe.setVerticalTextPosition(JLabel.BOTTOM);
        // this.recipe.setIconTextGap(+25);

        System.out.println("name of recip: " + recipe.name);

        // this.recipePanels[0].add(recipe);

        if (recipe.locked) {
            this.unlockButton.setEnabled(true);
            this.unlockButton.setVisible(true);
            this.recipePanels[1].setVisible(false);
            this.recipePanels[2].setVisible(false);
        }

        if (!recipe.locked) {

            this.unlockButton.setEnabled(false);
            this.unlockButton.setVisible(false);

            this.recipeParents[0] = (Recipe) RecipeBook.getRecipe(CombinationManager.getParent1(recip.name));

            System.out.println("name of parent 1: " + recipeParents[0].name);

            // this.recipeParents[0].setBackground(new Color(0, 0, 0, 0));
            // this.recipeParents[0].setBounds((int) leftCorner.getX() + 175, (int)
            // leftCorner.getY() + 450, 100, 150);

            // this.recipeParents[0].changeSize(recipeParents[0].image, 75);
            // this.recipeParents[0].setIcon(recipeParents[0].image);
            // this.recipeParents[0].setHorizontalAlignment(JLabel.CENTER);
            // this.recipeParents[0].setVerticalAlignment(JLabel.CENTER);

            // this.recipeParents[0].setText(recipe.name.toUpperCase());
            // this.recipeParents[0].setHorizontalTextPosition(JLabel.CENTER);
            // this.recipeParents[0].setVerticalTextPosition(JLabel.BOTTOM);
            // this.recipeParents[0].setIconTextGap(+10);

            // this.recipePanels[1].add(recipeParents[0]);
            this.recipePanels[1].setVisible(true);

            this.recipeParents[1] = RecipeBook.getRecipe(CombinationManager.getParent2(recip.name));

            System.out.println("name of parent2: " + recipeParents[1].name);

            // this.recipeParents[1].setBackground(new Color(0, 0, 0, 0));
            // this.recipeParents[1].changeSize(recipeParents[1].image, 75);
            // this.recipeParents[1].setIcon(recipeParents[1].image);
            // this.recipeParents[1].setHorizontalAlignment(JLabel.CENTER);
            // this.recipeParents[1].setVerticalAlignment(JLabel.CENTER);

            // this.recipeParents[1].setText(recipe.name.toUpperCase());
            // this.recipeParents[1].setHorizontalTextPosition(JLabel.CENTER);
            // this.recipeParents[1].setVerticalTextPosition(JLabel.BOTTOM);
            // this.recipeParents[1].setIconTextGap(+10);

            // this.recipePanels[2].add(recipeParents[1]);
            this.recipePanels[2].setVisible(true);
        }

        // this.recipePanels[0]
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlockButton) {
            recipe.unlock();
            this.init(recipe);
            revalidate();
            repaint();
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
