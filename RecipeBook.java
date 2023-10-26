import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class RecipeBook extends JFrame implements ActionListener {

    // ------------------code that doesn't work------------------//
    JRadioButton[][] recipeButtons = new JRadioButton[6][5];
    ButtonGroup buttonGroup = new ButtonGroup();
    private static List<Recipe> recipes = new ArrayList<>();
    // ----------------------------------------------------------//

    // ------------------code that worked------------------//
    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 800;

    public JLayeredPane layeredPane = new JLayeredPane();

    static ImageIcon book = new ImageIcon("book_background.png");
    static JLabel background = new JLabel();
    // ----------------------------------------------------//

    RecipeBook() {
        // ------------------code that worked------------------//
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.getContentPane().setBackground(new Color(224, 157, 112));
        this.setTitle("RecipeBook");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(false);
        this.setLocationRelativeTo(null);

        layeredPane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        Image image = book.getImage();
        Image newimg = image.getScaledInstance(SCREEN_WIDTH - 25, SCREEN_HEIGHT - 25, java.awt.Image.SCALE_SMOOTH);
        book = new ImageIcon(newimg);
        background.setIcon(book);

        background.setBackground(new Color(102, 65, 30));
        background.setBounds(0, 0, SCREEN_WIDTH - 25, SCREEN_HEIGHT - 25);
        background.setLayout(null);
        background.setVisible(true);
        // ---------------------------------------------------//

        // ------------------code that doesn't work------------------//
        int i;
        int j;
        int x = 100;
        int y = 100;
        Border darkBorder = BorderFactory.createLineBorder(new Color(54, 31, 10));

        for (i = 0; i <= 5; i++) {
            x = 100;
            for (j = 0; j <= 4; j++) {
                recipeButtons[i][j] = new JRadioButton();
                recipeButtons[i][j].setBounds(x, y, 100, 100);
                recipeButtons[i][j].setFocusable(false);
                recipeButtons[i][j].setBackground(new Color(112, 81, 52));
                recipeButtons[i][j].setBorder(darkBorder);
                recipeButtons[i][j].addActionListener(this);
                layeredPane.add(recipeButtons[i][j], Integer.valueOf(1));
                buttonGroup.add(recipeButtons[i][j]);
                x += 125;
            }
            y += 125;

        }

        layeredPane.add(background, Integer.valueOf(0));
        this.add(layeredPane);

        // this.pack();
    }

    // everything after this was added after it started not working
    void init() {
        int j = 1;
        for (int i = 0; i <= 5; i++) {
            recipeButtons[i][j].setIcon((ImageIcon) recipes.get(i + j).getIcon());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < +4; j++) {
                if (e.getSource() == recipeButtons[i][j]) {
                    this.openPage(recipeButtons[i][j]);
                }
            }
        }
    }

    public void openBook() {
        this.setVisible(true);
        this.init();
    }

    private void openPage(JRadioButton button) {
        new RecipePage((ImageIcon) button.getIcon());
    }

    public void addRecipe(Recipe recip) {
        recipes.add(recip);
    }

    public Recipe getRecipe(ImageIcon image) {
        for (Recipe recipe : recipes) {
            if (recipe.getIcon() == image) {
                return recipe;
            }
        }
        return null;
    }
    // ----------------------------------------------------------//
}
