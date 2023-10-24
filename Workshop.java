import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Workshop extends JPanel {

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

    JPanel tableSlotsPanel = new JPanel(new GridLayout(1, 2, 50, 0));

    JPanel defaultItemsPanel = new JPanel(new GridLayout(1, 4,16, 0));
    //Graphics g2D;
    CombinationManager checkCombo = new CombinationManager(); //should i have it here or move it inside a method?

    StartPage startPage = new StartPage();

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
        firstShelf.setOpaque(true);
        firstShelf.setLayout(null);
        firstShelf.add(brownShelf1);

        secondShelf.setBackground(new Color(143, 79, 16));
        secondShelf.setBounds(25, 150, 1150, 130);
        secondShelf.setOpaque(true);
        secondShelf.setLayout(null);
        secondShelf.add(brownShelf2);

        thirdShelf.setBackground(new Color(128, 76, 25));
        thirdShelf.setBounds(25, 290, 1150, 130); 
        thirdShelf.setOpaque(true);
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

        defaultItemsPanel.setOpaque(true);
        defaultItemsPanel.setBackground(new Color(0, 0, 0, 0));
        defaultItemsPanel.setBounds(795,445, 380, 80);

        x = 795;
        y = 445;
        for (int i = 30; i < 34; ++i){
            slots[i][0] = new Slot(new Point(x, y), 0);                
            slots[i][0].setBackground(new Color(0,0,0,30));
            //slots[i][0].setBounds((int) slots[i][0].leftCorner.getX(), (int) slots[i][0].leftCorner.getY(), 80, 80);
            //layeredPane.add(slots[i][0], Integer.valueOf(0));
            defaultItemsPanel.add(slots[i][0]);
            x += 100;
        }

        //startGame();
        itemsInit();

        tableLabel.setIcon(table);
        tableLabel.setBounds(25, 3, 550, 592);
        
        tablePanel.setLayout(null);
        tablePanel.setBackground(new Color(0,0,0,0));
        tablePanel.setBounds(300, 450, 600, 600);
        tablePanel.add(tableLabel);

        tableSlotsPanel.setOpaque(true);
        tableSlotsPanel.setBackground(new Color(0,0,0,0));
        tableSlotsPanel.setBounds(470, 539, 260, 100);

        tableSlots[0] = new Slot(new Point(0, 0), -1);
        tableSlots[0].setOpaque(true);
        tableSlots[0].setBackground(new Color(0,0,0,30));
        tableSlotsPanel.add(tableSlots[0]);

        tableSlots[1] = new Slot(new Point(159, 0), -1);
        tableSlots[1].setOpaque(true);
        tableSlots[1].setBackground(new Color(0,0,0,30));
        tableSlotsPanel.add(tableSlots[1]);


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

        layeredPane.add(firstShelf, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(secondShelf, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(thirdShelf, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(tablePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(tableSlotsPanel, Integer.valueOf(1));
        layeredPane.add(ivyTablePanel, Integer.valueOf(1));
        layeredPane.add(ivyTablePanel2, Integer.valueOf(1));
        layeredPane.add(bookButton, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(shopButton, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(defaultItemsPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(startPage, Integer.valueOf(2));

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

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        layeredPane.addMouseListener(myMouseAdapter);
        layeredPane.addMouseMotionListener(myMouseAdapter);

        this.add(layeredPane);

        /*Component[] content1 = tableSlots[0].getComponents();
        Component[] content2 = tableSlots[1].getComponents();
        if(content1.length != 0 && content1[0] instanceof JLabel && content2.length != 0 && content2[0] instanceof JLabel) {
            System.out.println("I'm mixing!");
            mixing((Item)content1[0], (Item)content2[0]);
        }*/

    }

    public void removeStartPage(JPanel startPage){
        layeredPane.remove(startPage);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private class MyMouseAdapter extends MouseAdapter {
        private JLabel dragLabel = null;
        private int dragLabelWidthDiv2;
        private int dragLabelHeightDiv2;
        private JPanel clickedPanel = null;

        @Override
        public void mousePressed(MouseEvent me) {
            Point slotPoint = SwingUtilities.convertPoint(layeredPane, me.getPoint(), firstShelf);
            clickedPanel = (JPanel) firstShelf.getComponentAt(slotPoint);
            if (clickedPanel == null){
                slotPoint = SwingUtilities.convertPoint(layeredPane, me.getPoint(), secondShelf);
                clickedPanel = (JPanel) secondShelf.getComponentAt(slotPoint);
            }
            
            if (clickedPanel == null) {
                slotPoint = SwingUtilities.convertPoint(layeredPane, me.getPoint(), thirdShelf);
                clickedPanel = (JPanel) thirdShelf.getComponentAt(slotPoint);
            }

            if (clickedPanel == null) {
                slotPoint = SwingUtilities.convertPoint(layeredPane, me.getPoint(), defaultItemsPanel);
                clickedPanel = (JPanel) defaultItemsPanel.getComponentAt(slotPoint);
            }

            if (clickedPanel == null) {
                return;
            }

            Component[] components = clickedPanel.getComponents();
            if (components.length == 0) {
                return;
            }
            if (components[0] instanceof JLabel) {
                dragLabel = (JLabel) components[0];

                //checks if an item is visible because if not the user shouldn't be able to move it
                if (dragLabel.isVisible()==false) {
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                    layeredPane.repaint();
                    dragLabel = null;
                    return;     
                }
                

                clickedPanel.remove(dragLabel);
                clickedPanel.revalidate();
                clickedPanel.repaint();

                //Calculate half dimensions for centering
                dragLabelWidthDiv2 = dragLabel.getWidth()/2;
                dragLabelHeightDiv2 = dragLabel.getHeight()/2;

                //Calculate the new position for the dragged label
                int x = me.getPoint().x - dragLabelWidthDiv2;
                int y = me.getPoint().y - dragLabelHeightDiv2;
                dragLabel.setLocation(x, y);
                layeredPane.add(dragLabel, JLayeredPane.DRAG_LAYER); //???????????
                layeredPane.repaint();
            }

        }
        
        @Override
        public void mouseDragged(MouseEvent me) {
            // Update the position of the dragged label during the drag
            if (dragLabel == null) {
                return;
            }
            int x = me.getPoint().x - dragLabelWidthDiv2;
            int y = me.getPoint().y - dragLabelHeightDiv2;
            dragLabel.setLocation(x, y);
            layeredPane.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (dragLabel == null) {
                return;
            }
            layeredPane.remove(dragLabel); //Remove dragLabel from the DRAG_LAYER
            Point pointInTableSlotsPanel = SwingUtilities.convertPoint(layeredPane, me.getPoint(), tableSlotsPanel);
            JPanel droppedPanel = (JPanel) tableSlotsPanel.getComponentAt(pointInTableSlotsPanel);
            
            if (droppedPanel == null) { 
                //If off the the shelves, return the label to its original location
                clickedPanel.add(dragLabel);
                clickedPanel.revalidate();

            } else {

                //checks if slot already full
                Component[] components = droppedPanel.getComponents();
                if(components.length != 0 && components[0] instanceof JLabel) {
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                    layeredPane.repaint();
                    dragLabel = null;
                    return;                    
                }

                if(droppedPanel == tableSlots[0]){
                    droppedPanel.add(dragLabel);
                    droppedPanel.revalidate();
                } else if (droppedPanel == tableSlots[1]){
                    droppedPanel.add(dragLabel);
                    droppedPanel.revalidate();
                } else {
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                }
            }

            Component[] content1 = tableSlots[0].getComponents();
            Component[] content2 = tableSlots[1].getComponents();
            if(content1.length != 0 && content1[0] instanceof JLabel && content2.length != 0 && content2[0] instanceof JLabel) {
                //checkCombo.newDiscovery(g2D);
                mixing((Item)content1[0], (Item)content2[0]);
            }

            layeredPane.repaint();
            dragLabel = null;
        }

    }


    //add to the combination manager as a method
    public void mixing(Item Parent1, Item Parent2){
        CombinationManager combination = new CombinationManager();
        Item child = new Item(new ImageIcon("icons/questionMark.png"));
    
        child = combination.combineItems(Parent1, Parent2);

        if (child == null) {
            slots[Parent1.slotNumber][0].add(Parent1);
            slots[Parent2.slotNumber][0].add(Parent2);

            tableSlots[0].remove(Parent1);
            tableSlots[1].remove(Parent2);
        } else {
            //consider multithreading so child and items can be added to shelves and removed from the table simultaneously
            child.setVisible(true);

            slots[Parent1.slotNumber][0].add(Parent1);
            slots[Parent2.slotNumber][0].add(Parent2);

            tableSlots[0].remove(Parent1);
            tableSlots[1].remove(Parent2);
        }
    }

    /*public void startGame(){
        init();
    }*/

    // other variables for rendering
    public void itemsInit() {

        //-----------------------------NATURE--------------------------------//
        Item air = new Item(new ImageIcon("icons/air.png"));
        air.setVisible(true);
        air.slotNumber = 30;
        slots[30][0].add(air);
        Item earth = new Item(new ImageIcon("icons/earth.png"));
        earth.setVisible(true);
        earth.slotNumber = 31;
        slots[31][0].add(earth);
        Item fire = new Item(new ImageIcon("icons/fire.png"));
        fire.setVisible(true);
        fire.slotNumber = 32;
        slots[32][0].add(fire);
        Item water = new Item(new ImageIcon("icons/water.png"));
        water.setVisible(true);
        water.slotNumber = 33;
        slots[33][0].add(water);

        Item lava = new Item(new ImageIcon("icons/lava.png"));
        Combination lavaCombination = new Combination(earth, fire, lava);
        propertiesInit(lavaCombination, 0);

        Item plant = new Item(new ImageIcon("icons/plant.png"));
        Combination plantCombination = new Combination(earth, water, plant);
        propertiesInit(plantCombination, 1);

        Item tree = new Item(new ImageIcon("icons/tree.png"));
        Combination treeCombination = new Combination(plant, water, tree);
        propertiesInit(treeCombination, 2);

        Item wood = new Item(new ImageIcon("icons/wood.png"));
        Combination woodCombination = new Combination(earth, tree, wood);
        propertiesInit(woodCombination, 3);

        Item stone = new Item(new ImageIcon("icons/stone.png"));

        Item sand = new Item(new ImageIcon("icons/sand.png"));
        Combination sandCombination = new Combination(air, stone, sand);
        propertiesInit(sandCombination, 4);

        Item mud = new Item(new ImageIcon("icons/mud.png"));
        Combination mudCombination = new Combination(sand, water, mud);
        propertiesInit(mudCombination, 5);

        Item dust = new Item(new ImageIcon("icons/dust.png"));
        Combination dustCombination = new Combination(air, earth, dust);
        propertiesInit(dustCombination, 6);

        Item energy = new Item(new ImageIcon("icons/energy.png"));
        Combination energyCombination = new Combination(air, fire, energy);
        propertiesInit(energyCombination, 7);

        Item pressure = new Item(new ImageIcon("icons/pressure.png"));
        Combination pressureCombination = new Combination(air, energy, pressure);
        propertiesInit(pressureCombination, 8);


        //-----------------------------STONE AGE--------------------------------//
        Combination stoneCombination = new Combination(air, lava, stone);
        propertiesInit(stoneCombination, 9);

        Item boat = new Item(new ImageIcon("icons/boat.png"));
        Combination boatCombination = new Combination(water, wood, boat);
        propertiesInit(boatCombination, 10);

        Item clay = new Item(new ImageIcon("icons/clay.png"));
        Combination clayCombination = new Combination(mud, sand, clay);
        propertiesInit(clayCombination, 11);

        Item pottery = new Item(new ImageIcon("icons/pottery.png"));
        Combination potteryCombination = new Combination(clay, fire, pottery);
        propertiesInit(potteryCombination, 12);

        Item tools = new Item(new ImageIcon("icons/tools.png"));
        Combination toolsCombination = new Combination(stone, wood, tools);
        propertiesInit(toolsCombination, 13);

        Item wheel = new Item(new ImageIcon("icons/wheel.png"));
        Combination wheelCombination = new Combination(tools, wood, wheel);
        propertiesInit(wheelCombination, 14);

        Item farming = new Item(new ImageIcon("icons/farming.png"));
        Combination farmingCombination = new Combination(earth, tools, farming);
        propertiesInit(farmingCombination, 15);
    
        Item gold = new Item(new ImageIcon("icons/gold.png"));
        Combination goldCombination = new Combination(stone, tools, gold);
        propertiesInit(goldCombination, 16);

        //-----------------------------IRON AGE--------------------------------//
        Item metal = new Item(new ImageIcon("icons/metal.png"));
        Combination metalCombination = new Combination(fire, stone, metal);
        propertiesInit(metalCombination, 17);

        Item sword = new Item(new ImageIcon("icons/sword.png"));
        Combination swordCombination = new Combination(metal, wood, sword);
        propertiesInit(swordCombination, 18);

        Item waterWheel = new Item(new ImageIcon("icons/waterWheel.png"));
        Combination waterWheelCombination = new Combination(water, wheel, waterWheel);
        propertiesInit(waterWheelCombination, 19);

        Item glass = new Item(new ImageIcon("icons/glass.png"));
        Combination glassCombination = new Combination(sand, fire, glass);
        propertiesInit(glassCombination, 20);

        Item mirror = new Item(new ImageIcon("icons/mirror.png"));
        Combination mirrorCombination = new Combination(glass, metal, mirror);
        propertiesInit(mirrorCombination, 21);

        Item coins = new Item(new ImageIcon("icons/coins.png"));
        Combination coinsCombination = new Combination(gold, tools, coins);
        propertiesInit(coinsCombination, 22);        

        //-----------------------------MODERN--------------------------------//
        Item gunpowder = new Item(new ImageIcon("icons/gunpowder.png"));
        Combination gunpowderCombination = new Combination(dust, fire, gunpowder);
        propertiesInit(gunpowderCombination, 23);  

        Item explosion = new Item(new ImageIcon("icons/explosion.png"));
        Combination explosionCombination = new Combination(fire, gunpowder, explosion);
        propertiesInit(explosionCombination, 24);  

        Item atomicBomb = new Item(new ImageIcon("icons/atomicBomb.png"));
        Combination atomicBombCombination = new Combination(energy, explosion, atomicBomb);
        propertiesInit(atomicBombCombination, 25);  

        Item electricity = new Item(new ImageIcon("icons/electricity.png"));
        Combination electricityCombination = new Combination(energy, metal, electricity);
        propertiesInit(electricityCombination, 26);  

        Item computer = new Item(new ImageIcon("icons/computer.png"));
        Combination computerCombination = new Combination(electricity, tools, computer);
        propertiesInit(computerCombination, 27);  

        Item lightbulb = new Item(new ImageIcon("icons/lightbulb.png"));
        Combination lightbulbCombination = new Combination(electricity, glass, lightbulb);
        propertiesInit(lightbulbCombination, 28);  

        Item paper = new Item(new ImageIcon("icons/paper.png"));
        Combination paperCombination = new Combination(pressure, wood, paper);
        propertiesInit(paperCombination, 29); 
        paper.setVisible(false); 

    }

    public void propertiesInit(Combination combination, int slotNr){
        CombinationManager.addCombination(combination);
        //combination.getChild().setVisible(true);
        slots[slotNr][0].add(combination.getChild());
        combination.getChild().slotNumber = slotNr;
    }

    public void showItems() {
        //new GameFrame();

        // uses moveItem
        // uses goToRecipeBook?
        // uses scroll
    }

    private Point moveItem() {
        // to know the coord. of the place it is dropped?
        return null;
    }

    private void goToRecipeBook() {
        // when the button is clicked...
    }

    // goToShop
}
