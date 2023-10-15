import java.awt.*;
import javax.swing.*;


public class Workshop extends JPanel{

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 800;
    static final int SLOTS_ON_PAGE = 30; 
    static final int PAGES_NUMBER = 1;

    JPanel firstShelf = new JPanel();
    JPanel secondShelf = new JPanel();
    JPanel thirdShelf = new JPanel();

    JPanel brownShelf1 = new JPanel();
    JPanel brownShelf2 = new JPanel();
    JPanel brownShelf3 = new JPanel();

    JPanel tablePanel = new JPanel();

    ImageIcon table = new ImageIcon("table.png");

    JLabel tableLabel = new JLabel();

    Workshop(){

        Slot[][] slots = new Slot[SLOTS_ON_PAGE][PAGES_NUMBER];
        int x = 17;
        int y = 15;
        int counterForCoord = 0;
        int counterForShelf = 0;

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(null);
        this.setBackground(new Color(191, 150, 111));

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


        this.add(firstShelf);
        this.add(secondShelf);
        this.add(thirdShelf);
        this.add(tablePanel);

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
        new GameFrame();

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
