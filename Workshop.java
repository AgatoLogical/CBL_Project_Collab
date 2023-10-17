import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Workshop extends JPanel{

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 800;
    static final int SLOTS_ON_PAGE = 30; 
    static final int PAGES_NUMBER = 1;

    JLayeredPane layeredPane = new JLayeredPane();

    JPanel firstShelf = new JPanel();
    JPanel secondShelf = new JPanel();
    JPanel thirdShelf = new JPanel();

    JPanel brownShelf1 = new JPanel();
    JPanel brownShelf2 = new JPanel();
    JPanel brownShelf3 = new JPanel();

    JPanel tablePanel = new JPanel();

    ImageIcon table = new ImageIcon("table.png");

    JLabel tableLabel = new JLabel();

    //JPanel ivyPanel = new JPanel();
    JPanel[] ivyPanel = new JPanel[25];
    ImageIcon ivy = new ImageIcon("ivy_horizontal.png");
    JLabel[] ivyLabel = new JLabel[25];

    JPanel ivyTablePanel = new JPanel();
    ImageIcon ivyTable = new ImageIcon("ivy_vertical.png");
    JLabel ivyTableLabel = new JLabel();

    JPanel ivyTablePanel2 = new JPanel();
    ImageIcon ivyTable2 = new ImageIcon("ivy_vertical2.png");
    JLabel ivyTableLabel2 = new JLabel();

    Slot[][] slots = new Slot[SLOTS_ON_PAGE][PAGES_NUMBER];

    Slot[] tableSlots = new Slot[2];

    JButton bookButton = new JButton();
    JButton shopButton = new JButton();

    ImageIcon bookIcon = new ImageIcon("recipe_book.png");
    ImageIcon shopIcon = new ImageIcon("shop.png");

    Workshop(){
        
        int x = 17;
        int y = 15;
        int counterForCoord = 0;
        int counterForShelf = 0;

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(150, 119, 89));

        layeredPane.setBounds(0, 0, 1200, 800);

        brownShelf1.setBackground(new Color(74, 38, 3));
        brownShelf1.setBounds(0, 115, 1150, 15);
        brownShelf2.setBackground(new Color(74, 38, 3));
        brownShelf2.setBounds(0, 115, 1150, 15);
        brownShelf3.setBackground(new Color(74, 38, 3));
        brownShelf3.setBounds(0, 115, 1150, 15);

        firstShelf.setBackground(new Color(102, 65, 30));
        firstShelf.setBounds(25, 10, 1150, 130);
        firstShelf.setLayout(null);
        firstShelf.add(brownShelf1);

        secondShelf.setBackground(new Color(143, 79, 16));
        secondShelf.setBounds(25, 150, 1150, 130);
        secondShelf.setLayout(null);
        secondShelf.add(brownShelf2);

        thirdShelf.setBackground(new Color(128, 76, 25));
        thirdShelf.setBounds(25, 290, 1150, 130); 
        thirdShelf.setLayout(null); 
        thirdShelf.add(brownShelf3); 

        for(int i = 0; i < SLOTS_ON_PAGE; ++i) {
            for(int j = 0; j < PAGES_NUMBER; ++j) {
                counterForShelf++;
                if(counterForCoord % 10 == 0 && counterForCoord != 0) {
                    x = 17;
                    counterForCoord = 0;
                }
                slots[i][j] = new Slot(new Point(x, y), j);
                slots[i][j].setBackground(new Color(0,0,0,30));
                slots[i][j].setBounds((int) slots[i][j].leftCorner.getX(), (int) slots[i][j].leftCorner.getY(), 100, 100);
                x += 113;

                if(counterForShelf <= 10){
                    firstShelf.add(slots[i][j]);
                } else if (counterForShelf <= 20){
                    secondShelf.add(slots[i][j]);
                } else if (counterForShelf <= 30){
                    thirdShelf.add(slots[i][j]);
                }

                counterForCoord++;
            }
        }

        tableLabel.setIcon(table);
        tableLabel.setVerticalAlignment(JLabel.CENTER);
        tableLabel.setHorizontalAlignment(JLabel.CENTER);
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(new Color(0,0,0,0));
        tablePanel.setBounds(300, 450, 600, 600);
        tablePanel.add(tableLabel);

        tableSlots[0] = new Slot(new Point(470, 539), -1);
        tableSlots[0].setBackground(new Color(0,0,0,30));
        tableSlots[0].setBounds((int) tableSlots[0].leftCorner.getX(), (int) tableSlots[0].leftCorner.getY(), 100, 100);
        
        tableSlots[1] = new Slot(new Point(628, 539), -1);
        tableSlots[1].setBackground(new Color(0,0,0,30));
        tableSlots[1].setBounds((int) tableSlots[1].leftCorner.getX(), (int) tableSlots[1].leftCorner.getY(), 100, 100);

        /*ivyLabel.setIcon(ivy);
        ivyLabel.setVerticalAlignment(JLabel.CENTER);
        ivyLabel.setHorizontalAlignment(JLabel.CENTER);*/

        /*ivyPanel.setLayout(new BorderLayout());
        ivyPanel.setBackground(new Color(0,0,0,0));
        ivyPanel.setBounds(25, 115, 150, 60);
        ivyPanel.add(ivyLabel);*/

        ivyTableLabel.setIcon(ivyTable);
        ivyTableLabel.setVerticalAlignment(JLabel.CENTER);
        ivyTableLabel.setHorizontalAlignment(JLabel.CENTER);

        ivyTablePanel.setLayout(new BorderLayout());
        ivyTablePanel.setBackground(new Color(0,0,0,0));
        ivyTablePanel.setBounds(270, 590, 155, 200);
        ivyTablePanel.add(ivyTableLabel);

        ivyTableLabel2.setIcon(ivyTable2);
        ivyTableLabel2.setVerticalAlignment(JLabel.CENTER);
        ivyTableLabel2.setHorizontalAlignment(JLabel.CENTER);

        ivyTablePanel2.setLayout(new BorderLayout());
        ivyTablePanel2.setBackground(new Color(0,0,0,0));
        ivyTablePanel2.setBounds(370, 620, 155, 200);
        ivyTablePanel2.add(ivyTableLabel2);

        bookButton.setBounds(25, 680, 100, 100);
        bookButton.setFocusable(false);
        bookButton.setIcon(bookIcon);
        Border darkBorder = BorderFactory.createLineBorder(new Color(54, 31, 10));
        bookButton.setBackground(new Color(112, 81, 52));
        bookButton.setBorder(darkBorder);
        shopButton.setBounds(150, 680, 100, 100);
        shopButton.setFocusable(false);
        shopButton.setIcon(shopIcon);
        shopButton.setBackground(new Color(112, 81, 52));
        shopButton.setBorder(darkBorder);

        layeredPane.add(firstShelf, Integer.valueOf(0));
        layeredPane.add(secondShelf, Integer.valueOf(0));
        layeredPane.add(thirdShelf, Integer.valueOf(0));
        layeredPane.add(tablePanel, Integer.valueOf(0));
        layeredPane.add(ivyTablePanel, Integer.valueOf(1));
        layeredPane.add(ivyTablePanel2, Integer.valueOf(1));
        layeredPane.add(tableSlots[0], Integer.valueOf(1));
        layeredPane.add(tableSlots[1], Integer.valueOf(1));
        layeredPane.add(bookButton, Integer.valueOf(0));
        layeredPane.add(shopButton, Integer.valueOf(0));
        //layeredPane.add(ivyPanel, Integer.valueOf(1));

        int xIvy = 5;
        int yIvy = 115;
        for (int i = 0; i < 25; ++i){
            ivyLabel[i] = new JLabel();
            ivyLabel[i].setIcon(ivy);
            ivyLabel[i].setVerticalAlignment(JLabel.CENTER);
            ivyLabel[i].setHorizontalAlignment(JLabel.CENTER);
            ivyPanel[i] = new JPanel();
            ivyPanel[i].setLayout(new BorderLayout());
            ivyPanel[i].setBackground(new Color(0,0,0,0));
            ivyPanel[i].setBounds(xIvy, yIvy, 150, 60);
            ivyPanel[i].add(ivyLabel[i]);
            layeredPane.add(ivyPanel[i], Integer.valueOf(1));
            xIvy += 150;

            if (i == 8) {
                xIvy = 5;
                yIvy += 140; 
            } else if (i == 16) {
                xIvy = 5;
                yIvy += 130;
            }
        }

        this.add(layeredPane);

        startGame();
    }

    public void startGame(){
        init();
    }

    // other variables for rendering
    public void init() {
        Component dust = new Component("air", "earth");
        Component land = new Component("earth", "stone");
        Component lava = new Component("earth", "fire");
        Component stone = new Component("air", "pressure");
        Component smoke = new Component("fire", "air");
        Component steam = new Component("water", "lava");
        Component pressure = new Component("air", "air");
    }

    public void render() {
        //new GameFrame();

        // uses moveItem
        // uses goToRecipeBook?
        // uses scroll
    }

    private Point moveItem() {
        // to know the coord. of the place it is dropped?
        return null;
    }

    private void scroll() {
        // for the shelves
        // uses pageDisplayed
    }

    private void goToRecipeBook() {
        // when the button is clicked...
    }

    // goToShop
}