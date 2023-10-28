import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class RecipePage extends JPanel implements ActionListener {

    static final int width = 490;
    static final int height = 510;
    // static final Point leftCorner = new Point(575, 100);
    // static final Point leftCorner = new Point(0, 0);

    ImageIcon unlockIcon = new ImageIcon("unlock_button.png");
    JButton unlockButton = new JButton();

    Recipe recipe;
    Recipe recipeParents[] = new Recipe[2];
    JLabel recipeLabel = new JLabel();
    JLabel recipeParentLabels[] = new JLabel[2];
    JPanel[] recipePanels = new JPanel[3];

    JLayeredPane layeredPane = new JLayeredPane();

    Fortune fortune = new Fortune();
    RecipeMessage message = new RecipeMessage();

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

        message.setBounds((int) (width / 2) - 100, (int) (height / 2) - 25, 200, 200);

        recipeParentLabels[0] = new JLabel();
        recipeParentLabels[1] = new JLabel();

        layeredPane.add(recipePanels[0], Integer.valueOf(1));
        layeredPane.add(recipePanels[1], Integer.valueOf(1));
        layeredPane.add(recipePanels[2], Integer.valueOf(1));

        layeredPane.add(unlockButton, Integer.valueOf(3));

        layeredPane.add(recipeLabel, Integer.valueOf(2));
        layeredPane.add(recipeParentLabels[0], Integer.valueOf(2));
        layeredPane.add(recipeParentLabels[1], Integer.valueOf(2));

        layeredPane.add(message, Integer.valueOf(4));
        this.add(layeredPane);

        // not complete
    }

    private void init(Recipe recip) {

        // System.out.println("got to page init");

        this.recipe = recip;

        ImageIcon img = recipe.changeSize(recipe.getImage(), 100);
        this.recipeLabel.setIcon(img);
        this.recipeLabel.setText(recipe.name);

        this.recipeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.recipeLabel.setVerticalAlignment(JLabel.CENTER);
        this.recipeLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.recipeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        this.recipeLabel.setForeground(new Color(0, 32, 96));
        this.recipeLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 28));
        this.recipeLabel.setVisible(true);
        this.recipeLabel.setBounds((int) (width / 2) - 75, 25, 150, 150);

        System.out.println("name of recip: " + recipe.name);

        // this.recipePanels[0].add(recipe);

        if (recipe.locked) {
            this.unlockButton.setEnabled(true);
            this.unlockButton.setVisible(true);
            this.recipePanels[1].setVisible(false);
            this.recipePanels[2].setVisible(false);
            this.recipeParentLabels[0].setVisible(false);
            this.recipeParentLabels[1].setVisible(false);
        }

        if (!recipe.locked) {

            this.unlockButton.setEnabled(false);
            this.unlockButton.setVisible(false);

            this.recipeParents[0] = (Recipe) RecipeBook.getRecipe(CombinationManager.getParent1(recip.name));

            System.out.println("name of parent 1: " + recipeParents[0].name);

            img = recipeParents[0].changeSize(recipeParents[0].getImage(), 70);
            this.recipeParentLabels[0].setIcon(img);
            this.recipeParentLabels[0].setText(recipeParents[0].name);

            this.recipeParentLabels[0].setHorizontalAlignment(JLabel.CENTER);
            this.recipeParentLabels[0].setVerticalAlignment(JLabel.CENTER);
            this.recipeParentLabels[0].setHorizontalTextPosition(JLabel.CENTER);
            this.recipeParentLabels[0].setVerticalTextPosition(JLabel.BOTTOM);
            this.recipeParentLabels[0].setForeground(new Color(0, 32, 96));
            this.recipeParentLabels[0].setFont(new Font("Blackadder ITC", Font.BOLD, 22));
            this.recipeParentLabels[0].setVisible(true);
            this.recipeParentLabels[0].setBounds((int) (width / 2) - 100, (int) (height / 2) + 40, 100, 100);

            this.recipePanels[1].setVisible(true);

            this.recipeParents[1] = RecipeBook.getRecipe(CombinationManager.getParent2(recip.name));

            System.out.println("name of parent2: " + recipeParents[1].name);

            img = recipeParents[1].changeSize(recipeParents[1].getImage(), 70);
            this.recipeParentLabels[1].setIcon(img);
            this.recipeParentLabels[1].setText(recipeParents[1].name);

            this.recipeParentLabels[1].setHorizontalAlignment(JLabel.CENTER);
            this.recipeParentLabels[1].setVerticalAlignment(JLabel.CENTER);
            this.recipeParentLabels[1].setHorizontalTextPosition(JLabel.CENTER);
            this.recipeParentLabels[1].setVerticalTextPosition(JLabel.BOTTOM);
            this.recipeParentLabels[1].setForeground(new Color(0, 32, 96));
            this.recipeParentLabels[1].setFont(new Font("Blackadder ITC", Font.BOLD, 22));
            this.recipeParentLabels[1].setVisible(true);
            this.recipeParentLabels[1].setBounds((int) (width / 2), (int) (height / 2) + 40, 100, 100);

            this.recipePanels[2].setVisible(true);
        }

        // this.recipePanels[0]
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlockButton) {
            if (fortune.spendFortune(recipe)) {
                recipe.unlock();
                this.init(recipe);
                revalidate();
                repaint();
            } else {
                openMessage();
            }

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

    private void openMessage() {
        message.setVisible(true);
    }
}
