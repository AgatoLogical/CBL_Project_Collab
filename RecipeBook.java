import java.awt.*;
import javax.swing.*;

public class RecipeBook extends JFrame{

    final int SCREEN_HEIGHT = 800;
    final int SCREEN_WIDTH = 1200;

    JLayeredPane newLayeredPane = new JLayeredPane();

    JPanel backPanel = new JPanel();
    JLabel bookBackground = new JLabel();
    ImageIcon bookIcon = new ImageIcon("book_background.png");

    JPanel bookPanel = new JPanel(new GridLayout(1, 2, 100, 0)); 
    JPanel firstPage = new JPanel(new GridLayout(6, 5, 0, 0));

    RecipeButton[] itemButton = new RecipeButton[30];

    RecipeBook(){

        newLayeredPane.setBounds(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
        newLayeredPane.setVisible(true);

        backPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        backPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        backPanel.setBackground(new Color(150, 119, 89));

        bookPanel.setBounds(165, 50, 400, 680);
        bookPanel.setBackground(Color.BLACK);

        bookBackground.setIcon(bookIcon);

        backPanel.add(bookBackground);

        /*for(int i = 0; i < 30; ++i) {
            //itemButton[i] = new RecipeButton();
            itemButton[i].setPreferredSize(new Dimension(80, 80));
            //itemButton[i].setIcon();
        }*/

        newLayeredPane.add(backPanel, JLayeredPane.DEFAULT_LAYER);
        newLayeredPane.add(bookPanel, Integer.valueOf(1));
        this.add(newLayeredPane);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }



}
