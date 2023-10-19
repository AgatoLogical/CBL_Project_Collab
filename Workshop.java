import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Workshop extends JPanel{

    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 800;
    static final int SLOTS_ON_PAGE = 30; 
    static final int PAGES_NUMBER = 1;

    public JLayeredPane layeredPane = new JLayeredPane();

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

    Slot[][] slots = new Slot[SLOTS_ON_PAGE + 4][PAGES_NUMBER];

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

        x = 795;
        y = 445;
        for (int i = 30; i < 34; ++i){
            slots[i][0] = new Slot(new Point(x, y), 0);                
            slots[i][0].setBackground(new Color(0,0,0,30));
            slots[i][0].setBounds((int) slots[i][0].leftCorner.getX(), (int) slots[i][0].leftCorner.getY(), 80, 80);
            layeredPane.add(slots[i][0], Integer.valueOf(0));
            x += 100;
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

        layeredPane.add(firstShelf, Integer.valueOf(2));
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

        //-----------------------------NATURE--------------------------------//
        Component air = new Component(new ImageIcon("icons/air.png"));
        air.setVisible(true);
        slots[30][0].add(air);
        Component earth = new Component(new ImageIcon("icons/earth.png"));
        earth.setVisible(true);
        slots[31][0].add(earth);
        Component fire = new Component(new ImageIcon("icons/fire.png"));
        fire.setVisible(true);
        slots[32][0].add(fire);
        Component water = new Component(new ImageIcon("icons/water.png"));
        water.setVisible(true);
        slots[33][0].add(water);

        Component lava = new Component(new ImageIcon("icons/lava.png"));
        Combination lavaCombination = new Combination(earth, fire, lava);
        propertiesInit(lavaCombination, 0);

        Component plant = new Component(new ImageIcon("icons/plant.png"));
        Combination plantCombination = new Combination(earth, water, plant);
        propertiesInit(plantCombination, 1);

        Component tree = new Component(new ImageIcon("icons/tree.png"));
        Combination treeCombination = new Combination(plant, water, tree);
        propertiesInit(treeCombination, 2);

        Component wood = new Component(new ImageIcon("icons/wood.png"));
        Combination woodCombination = new Combination(earth, tree, wood);
        propertiesInit(woodCombination, 3);

        Component stone = new Component(new ImageIcon("icons/stone.png"));

        Component sand = new Component(new ImageIcon("icons/sand.png"));
        Combination sandCombination = new Combination(air, stone, sand);
        propertiesInit(sandCombination, 4);

        Component mud = new Component(new ImageIcon("icons/mud.png"));
        Combination mudCombination = new Combination(earth, water, mud);
        propertiesInit(mudCombination, 5);

        Component dust = new Component(new ImageIcon("icons/dust.png"));
        Combination dustCombination = new Combination(air, earth, dust);
        propertiesInit(dustCombination, 6);

        Component energy = new Component(new ImageIcon("icons/energy.png"));
        Combination energyCombination = new Combination(air, fire, energy);
        propertiesInit(energyCombination, 7);

        Component pressure = new Component(new ImageIcon("icons/pressure.png"));
        Combination pressureCombination = new Combination(air, energy, pressure);
        propertiesInit(pressureCombination, 8);


        //-----------------------------STONE AGE--------------------------------//
        Combination stoneCombination = new Combination(air, lava, stone);
        propertiesInit(stoneCombination, 9);

        Component boat = new Component(new ImageIcon("icons/boat.png"));
        Combination boatCombination = new Combination(water, wood, boat);
        propertiesInit(boatCombination, 10);

        Component clay = new Component(new ImageIcon("icons/clay.png"));
        Combination clayCombination = new Combination(mud, sand, clay);
        propertiesInit(clayCombination, 11);

        Component pottery = new Component(new ImageIcon("icons/pottery.png"));
        Combination potteryCombination = new Combination(clay, fire, pottery);
        propertiesInit(potteryCombination, 12);

        Component tools = new Component(new ImageIcon("icons/tools.png"));
        Combination toolsCombination = new Combination(stone, wood, tools);
        propertiesInit(toolsCombination, 13);

        Component wheel = new Component(new ImageIcon("icons/wheel.png"));
        Combination wheelCombination = new Combination(tools, wood, wheel);
        propertiesInit(wheelCombination, 14);

        Component farming = new Component(new ImageIcon("icons/farming.png"));
        Combination farmingCombination = new Combination(earth, tools, farming);
        propertiesInit(farmingCombination, 15);
    
        Component gold = new Component(new ImageIcon("icons/gold.png"));
        Combination goldCombination = new Combination(stone, tools, gold);
        propertiesInit(goldCombination, 16);

        //-----------------------------IRON AGE--------------------------------//
        Component metal = new Component(new ImageIcon("icons/metal.png"));
        Combination metalCombination = new Combination(air, lava, metal);
        propertiesInit(metalCombination, 17);

        Component sword = new Component(new ImageIcon("icons/sword.png"));
        Combination swordCombination = new Combination(water, wood, sword);
        propertiesInit(swordCombination, 18);

        Component waterWheel = new Component(new ImageIcon("icons/waterWheel.png"));
        Combination waterWheelCombination = new Combination(mud, sand, waterWheel);
        propertiesInit(waterWheelCombination, 19);

        Component glass = new Component(new ImageIcon("icons/glass.png"));
        Combination glassCombination = new Combination(clay, fire, glass);
        propertiesInit(glassCombination, 20);

        Component mirror = new Component(new ImageIcon("icons/mirror.png"));
        Combination mirrorCombination = new Combination(stone, wood, mirror);
        propertiesInit(mirrorCombination, 21);

        Component coins = new Component(new ImageIcon("icons/coins.png"));
        Combination coinsCombination = new Combination(tools, wood, coins);
        propertiesInit(coinsCombination, 22);        

        //-----------------------------MODERN--------------------------------//
        Component gunpowder = new Component(new ImageIcon("icons/gunpowder.png"));
        Combination gunpowderCombination = new Combination(dust, fire, gunpowder);
        propertiesInit(gunpowderCombination, 23);  

        Component explosion = new Component(new ImageIcon("icons/explosion.png"));
        Combination explosionCombination = new Combination(fire, gunpowder, explosion);
        propertiesInit(explosionCombination, 24);  

        Component atomicBomb = new Component(new ImageIcon("icons/atomicBomb.png"));
        Combination atomicBombCombination = new Combination(energy, explosion, atomicBomb);
        propertiesInit(atomicBombCombination, 25);  

        Component electricity = new Component(new ImageIcon("icons/electricity.png"));
        Combination electricityCombination = new Combination(energy, metal, electricity);
        propertiesInit(electricityCombination, 26);  

        Component computer = new Component(new ImageIcon("icons/computer.png"));
        Combination computerCombination = new Combination(electricity, tools, computer);
        propertiesInit(computerCombination, 27);  

        Component lightbulb = new Component(new ImageIcon("icons/lightbulb.png"));
        Combination lightbulbCombination = new Combination(electricity, glass, lightbulb);
        propertiesInit(lightbulbCombination, 28);  

        Component paper = new Component(new ImageIcon("icons/paper.png"));
        Combination paperCombination = new Combination(pressure, wood, paper);
        propertiesInit(paperCombination, 29);  

    }

    public void propertiesInit(Combination combination, int slotNr){
        CombinationManager.addCombination(combination);
        combination.getChild().setVisible(true);
        slots[slotNr][0].add(combination.getChild());
    }

    public void showComponents() {
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
