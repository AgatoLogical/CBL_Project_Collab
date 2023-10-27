import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class RecipeBook extends JFrame implements ActionListener {

    // ------------------code that doesn't work------------------//
    MyJButton[][] recipeButtons = new MyJButton[6][5];
    private static List<Recipe> recipes = new ArrayList<>();
    RecipePage recipePage = new RecipePage();
    // ----------------------------------------------------------//

    // ------------------code that worked------------------//
    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 800;

    JLayeredPane layeredPane = new JLayeredPane();

    ImageIcon book = new ImageIcon("book_background.png");
    JLabel background = new JLabel();
    JPanel backgroundPanel = new JPanel();
    // ----------------------------------------------------//

    public RecipeBook() {
        // ------------------code that worked------------------//
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        // this.getContentPane().setBackground(new Color(224, 157, 112));
        this.setTitle("RecipeBook");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);

        layeredPane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        Image image = book.getImage();
        Image newimg = image.getScaledInstance(SCREEN_WIDTH - 50, SCREEN_HEIGHT - 50, java.awt.Image.SCALE_SMOOTH);
        book = new ImageIcon(newimg);

        background.setIcon(book);
        background.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        background.setBackground(new Color(224, 157, 112));
        background.setVerticalAlignment(JLabel.CENTER);
        background.setHorizontalAlignment(JLabel.CENTER);
        background.setOpaque(true);

        backgroundPanel.add(background);
        backgroundPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        backgroundPanel.setVisible(true);
        // ---------------------------------------------------//

        // ------------------code that doesn't work------------------//
        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);

        int i;
        int j;
        int x = 150;
        int y = 150;
        // Border darkBorder = BorderFactory.createLineBorder(new Color(109, 74, 35));
        Border lightBorder = BorderFactory.createLineBorder(new Color(199, 163, 121));

        for (i = 0; i <= 5; i++) {
            x = 150;
            for (j = 0; j <= 4; j++) {
                recipeButtons[i][j] = new MyJButton();
                recipeButtons[i][j].setBounds(x, y, 70, 70);
                recipeButtons[i][j].setFocusable(false);
                // recipeButtons[i][j].setBackground(new Color(199, 163, 121));
                recipeButtons[i][j].setBackground(new Color(247, 236, 212, 0));
                recipeButtons[i][j].setBorder(lightBorder);
                recipeButtons[i][j].addActionListener(this);
                layeredPane.add(recipeButtons[i][j], Integer.valueOf(1));
                x += 85;
            }
            y += 85;

        }

        layeredPane.add(recipePage, Integer.valueOf(1));
        this.add(layeredPane);

        this.pack();
    }

    // everything after this was added after it started not working
    void init() {
        int x = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                recipeButtons[i][j].setIcon(recipes.get(x).getIcon());
                recipeButtons[i][j].setName(recipes.get(x).name);
                if (recipes.get(x).getValue() < 200) {
                    recipes.get(x).unlock();
                    recipeButtons[i][j].setIcon(recipes.get(x).getIcon());
                }
                x++;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                if (e.getSource() == recipeButtons[i][j]) {
                    this.openPage(recipeButtons[i][j]);
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        revalidate();
        repaint();
    }

    public void openBook() {
        this.setVisible(true);
        this.init();
    }

    private void openPage(MyJButton button) {
        recipePage.openPage(getRecipe(button.getName()));
    }

    public static void addRecipe(Recipe recip) {
        recipes.add(recip);
    }

    public static Recipe getRecipe(String name) {
        for (Recipe recipe : recipes) {
            if (name.equals(recipe.name)) {
                // System.out.println("names: " + name + " " + recipe.name);
                return recipe;
            }
        }
        return null;
    }

    private class MyJButton extends JButton {
        private String name = "";

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    // ----------------------------------------------------------//
}
