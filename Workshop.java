import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Workshop extends JPanel implements ActionListener {

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

    // JPanel ivyPanel = new JPanel();
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

    JPanel defaultItemsPanel = new JPanel(new GridLayout(1, 4, 16, 0));
    // Graphics g2D;
    CombinationManager checkCombo = new CombinationManager(); // should i have it here or move it inside a method?

    StartPage startPage = new StartPage();

    public Fortune fortune = new Fortune();
    RecipeBook recipeBook = new RecipeBook();

    Message message;

    Workshop() {

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

        for (int i = 0; i < SLOTS_ON_PAGE; ++i) {
            for (int j = 0; j < PAGES_NUMBER; ++j) {
                counterForShelf++;
                if (counterForCoord % 10 == 0 && counterForCoord != 0) {
                    x = 17;
                    counterForCoord = 0;
                }
                slots[i][j] = new Slot(new Point(x, y), j);
                slots[i][j].setBackground(new Color(0, 0, 0, 30));
                slots[i][j].setBounds((int) slots[i][j].leftCorner.getX(), (int) slots[i][j].leftCorner.getY(), 100,
                        100);
                x += 113;

                if (counterForShelf <= 10) {
                    firstShelf.add(slots[i][j]);
                } else if (counterForShelf <= 20) {
                    secondShelf.add(slots[i][j]);
                } else if (counterForShelf <= 30) {
                    thirdShelf.add(slots[i][j]);
                }

                counterForCoord++;
            }
        }

        defaultItemsPanel.setOpaque(true);
        defaultItemsPanel.setBackground(new Color(0, 0, 0, 0));
        defaultItemsPanel.setBounds(795, 445, 380, 80);

        x = 795;
        y = 445;
        for (int i = 30; i < 34; ++i) {
            slots[i][0] = new Slot(new Point(x, y), 0);
            slots[i][0].setBackground(new Color(0, 0, 0, 30));
            // slots[i][0].setBounds((int) slots[i][0].leftCorner.getX(), (int)
            // slots[i][0].leftCorner.getY(), 80, 80);
            // layeredPane.add(slots[i][0], Integer.valueOf(0));
            defaultItemsPanel.add(slots[i][0]);
            x += 100;
        }

        // startGame();
        itemsInit();

        tableLabel.setIcon(table);
        tableLabel.setBounds(25, 3, 550, 592);

        tablePanel.setLayout(null);
        tablePanel.setBackground(new Color(0, 0, 0, 0));
        tablePanel.setBounds(300, 450, 600, 600);
        tablePanel.add(tableLabel);

        tableSlotsPanel.setOpaque(true);
        tableSlotsPanel.setBackground(new Color(0, 0, 0, 0));
        tableSlotsPanel.setBounds(470, 539, 260, 100);

        tableSlots[0] = new Slot(new Point(0, 0), -1);
        tableSlots[0].setOpaque(true);
        tableSlots[0].setBackground(new Color(0, 0, 0, 30));
        tableSlotsPanel.add(tableSlots[0]);

        tableSlots[1] = new Slot(new Point(159, 0), -1);
        tableSlots[1].setOpaque(true);
        tableSlots[1].setBackground(new Color(0, 0, 0, 30));
        tableSlotsPanel.add(tableSlots[1]);

        ivyTableLabel.setIcon(ivyTable);
        ivyTableLabel.setVerticalAlignment(JLabel.CENTER);
        ivyTableLabel.setHorizontalAlignment(JLabel.CENTER);

        ivyTablePanel.setLayout(new BorderLayout());
        ivyTablePanel.setBackground(new Color(0, 0, 0, 0));
        ivyTablePanel.setBounds(270, 590, 155, 200);
        ivyTablePanel.add(ivyTableLabel);

        ivyTableLabel2.setIcon(ivyTable2);
        ivyTableLabel2.setVerticalAlignment(JLabel.CENTER);
        ivyTableLabel2.setHorizontalAlignment(JLabel.CENTER);

        ivyTablePanel2.setLayout(new BorderLayout());
        ivyTablePanel2.setBackground(new Color(0, 0, 0, 0));
        ivyTablePanel2.setBounds(370, 620, 155, 200);
        ivyTablePanel2.add(ivyTableLabel2);

        bookButton.setBounds(25, 680, 100, 100);
        bookButton.setFocusable(false);
        bookButton.setIcon(bookIcon);
        Border darkBorder = BorderFactory.createLineBorder(new Color(54, 31, 10));
        bookButton.setBackground(new Color(112, 81, 52));
        bookButton.addActionListener(this);
        // bookButton.setBorder(darkBorder);
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
        layeredPane.add(fortune, JLayeredPane.DEFAULT_LAYER);

        int xIvy = 5;
        int yIvy = 115;
        for (int i = 0; i < 25; ++i) {
            ivyLabel[i] = new JLabel();
            ivyLabel[i].setIcon(ivy);
            ivyLabel[i].setVerticalAlignment(JLabel.CENTER);
            ivyLabel[i].setHorizontalAlignment(JLabel.CENTER);
            ivyPanel[i] = new JPanel();
            ivyPanel[i].setLayout(new BorderLayout());
            ivyPanel[i].setBackground(new Color(0, 0, 0, 0));
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

    }

    public void removeStartPage(JPanel startPage) {
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
            if (clickedPanel == null) {
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

            java.awt.Component[] components = clickedPanel.getComponents();
            if (components.length == 0) {
                return;
            }
            if (components[0] instanceof JLabel) {
                dragLabel = (JLabel) components[0];

                // checks if an item is visible because if not the user shouldn't be able to
                // move it
                if (dragLabel.isVisible() == false) {
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                    layeredPane.repaint();
                    dragLabel = null;
                    return;
                }

                clickedPanel.remove(dragLabel);
                clickedPanel.revalidate();
                clickedPanel.repaint();

                // Calculate half dimensions for centering
                dragLabelWidthDiv2 = dragLabel.getWidth() / 2;
                dragLabelHeightDiv2 = dragLabel.getHeight() / 2;

                // Calculate the new position for the dragged label
                int x = me.getPoint().x - dragLabelWidthDiv2;
                int y = me.getPoint().y - dragLabelHeightDiv2;
                dragLabel.setLocation(x, y);
                layeredPane.add(dragLabel, JLayeredPane.DRAG_LAYER); // ???????????
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
            layeredPane.remove(dragLabel); // Remove dragLabel from the DRAG_LAYER
            Point pointInTableSlotsPanel = SwingUtilities.convertPoint(layeredPane, me.getPoint(), tableSlotsPanel);
            JPanel droppedPanel = (JPanel) tableSlotsPanel.getComponentAt(pointInTableSlotsPanel);

            if (droppedPanel == null) {
                // If off the the shelves, return the label to its original location
                clickedPanel.add(dragLabel);
                clickedPanel.revalidate();

            } else {

                // checks if slot already full
                java.awt.Component[] components = droppedPanel.getComponents();
                if (components.length != 0 && components[0] instanceof JLabel) {
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                    layeredPane.repaint();
                    dragLabel = null;
                    return;
                }

                if (droppedPanel == tableSlots[0]) {
                    droppedPanel.add(dragLabel);
                    droppedPanel.revalidate();
                } else if (droppedPanel == tableSlots[1]) {
                    droppedPanel.add(dragLabel);
                    droppedPanel.revalidate();
                } else {
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                }
            }

            java.awt.Component[] content1 = tableSlots[0].getComponents();
            java.awt.Component[] content2 = tableSlots[1].getComponents();
            if (content1.length != 0 && content1[0] instanceof JLabel && content2.length != 0
                    && content2[0] instanceof JLabel) {
                // checkCombo.newDiscovery(g2D);
                mixing((Item) content1[0], (Item) content2[0]);
            }

            layeredPane.repaint();
            dragLabel = null;
        }

    }

    // add to the combination manager as a method
    public void mixing(Item Parent1, Item Parent2) {
        CombinationManager combination = new CombinationManager();
        Item child = combination.combineItems(Parent1, Parent2);

        // child = combination.combineItems(Parent1, Parent2);

        if (child == null) {
            slots[Parent1.slotNumber][0].add(Parent1);
            slots[Parent2.slotNumber][0].add(Parent2);

            tableSlots[0].remove(Parent1);
            tableSlots[1].remove(Parent2);
        } else {
            // consider multithreading so child and items can be added to shelves and
            // removed from the table simultaneously
            child.setVisible(true);

            if (!child.isDicovered) {
                message = new Message(child);
                layeredPane.add(message, Integer.valueOf(2));
                RecipeBook.getRecipe(child.name).unlock();
            }

            child.isDicovered = true;

            slots[Parent1.slotNumber][0].add(Parent1);
            slots[Parent2.slotNumber][0].add(Parent2);

            tableSlots[0].remove(Parent1);
            tableSlots[1].remove(Parent2);

            fortune.gainFortune(child);
        }
    }

    public void removeMessage(Message message) {
        layeredPane.remove(message);

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    /*
     * public void startGame(){
     * init();
     * }
     */

    // other variables for rendering
    public void itemsInit() {

        // -----------------------------NATURE--------------------------------//
        ImageIcon airIcon = new ImageIcon("icons/air.png", "Air");
        Item air = new Item(airIcon, 0);
        air.setVisible(true);
        air.slotNumber = 30;
        slots[30][0].add(air);
        recipInit(airIcon, 0);

        ImageIcon earthIcon = new ImageIcon("icons/earth.png", "Earth");
        Item earth = new Item(earthIcon, 0);
        earth.setVisible(true);
        earth.slotNumber = 31;
        slots[31][0].add(earth);
        recipInit(earthIcon, 0);

        ImageIcon fireIcon = new ImageIcon("icons/fire.png", "Fire");
        Item fire = new Item(fireIcon, 0);
        fire.setVisible(true);
        fire.slotNumber = 32;
        slots[32][0].add(fire);
        recipInit(fireIcon, 0);

        ImageIcon waterIcon = new ImageIcon("icons/water.png", "Water");
        Item water = new Item(waterIcon, 0);
        water.setVisible(true);
        water.slotNumber = 33;
        slots[33][0].add(water);
        recipInit(waterIcon, 0);

        ImageIcon lavaIcon = new ImageIcon("icons/lava.png", "Lava");
        Item lava = new Item(lavaIcon, 1);
        Combination lavaCombination = new Combination(earth, fire, lava);
        propertiesInit(lavaCombination, 0);
        recipInit(lavaIcon, 1);

        ImageIcon plantIcon = new ImageIcon("icons/plant.png", "Plant");
        Item plant = new Item(plantIcon, 1);
        Combination plantCombination = new Combination(earth, water, plant);
        propertiesInit(plantCombination, 1);
        recipInit(plantIcon, 1);

        ImageIcon treeIcon = new ImageIcon("icons/tree.png", "Tree");
        Item tree = new Item(treeIcon, 1);
        Combination treeCombination = new Combination(plant, water, tree);
        propertiesInit(treeCombination, 2);
        recipInit(treeIcon, 1);

        ImageIcon woodIcon = new ImageIcon("icons/wood.png", "Wood");
        Item wood = new Item(woodIcon, 1);
        Combination woodCombination = new Combination(earth, tree, wood);
        propertiesInit(woodCombination, 3);
        recipInit(woodIcon, 1);

        ImageIcon stoneIcon = new ImageIcon("icons/stone.png", "Stone");
        Item stone = new Item(stoneIcon, 2);

        ImageIcon sandIcon = new ImageIcon("icons/sand.png", "Sand");
        Item sand = new Item(sandIcon, 1);
        Combination sandCombination = new Combination(air, stone, sand);
        propertiesInit(sandCombination, 4);
        recipInit(sandIcon, 1);

        ImageIcon mudIcon = new ImageIcon("icons/mud.png", "Mud");
        Item mud = new Item(mudIcon, 1);
        Combination mudCombination = new Combination(sand, water, mud);
        propertiesInit(mudCombination, 5);
        recipInit(mudIcon, 1);

        ImageIcon dustIcon = new ImageIcon("icons/dust.png", "Dust");
        Item dust = new Item(dustIcon, 1);
        Combination dustCombination = new Combination(air, earth, dust);
        propertiesInit(dustCombination, 6);
        recipInit(dustIcon, 1);

        ImageIcon energyIcon = new ImageIcon("icons/energy.png", "Energy");
        Item energy = new Item(energyIcon, 1);
        Combination energyCombination = new Combination(air, fire, energy);
        propertiesInit(energyCombination, 7);
        recipInit(energyIcon, 1);

        ImageIcon pressureIcon = new ImageIcon("icons/pressure.png", "Pressure");
        Item pressure = new Item(pressureIcon, 1);
        Combination pressureCombination = new Combination(air, energy, pressure);
        propertiesInit(pressureCombination, 8);
        recipInit(pressureIcon, 1);

        // -----------------------------STONE AGE--------------------------------//
        Combination stoneCombination = new Combination(air, lava, stone);
        propertiesInit(stoneCombination, 9);
        recipInit(stoneIcon, 2);

        ImageIcon boatIcon = new ImageIcon("icons/boat.png", "Boat");
        Item boat = new Item(boatIcon, 2);
        Combination boatCombination = new Combination(water, wood, boat);
        propertiesInit(boatCombination, 10);
        recipInit(boatIcon, 2);

        ImageIcon clayIcon = new ImageIcon("icons/clay.png", "Clay");
        Item clay = new Item(clayIcon, 2);
        Combination clayCombination = new Combination(mud, sand, clay);
        propertiesInit(clayCombination, 11);
        recipInit(clayIcon, 2);

        ImageIcon potteryIcon = new ImageIcon("icons/pottery.png", "Pottery");
        Item pottery = new Item(potteryIcon, 2);
        Combination potteryCombination = new Combination(clay, fire, pottery);
        propertiesInit(potteryCombination, 12);
        recipInit(potteryIcon, 2);

        ImageIcon toolsIcon = new ImageIcon("icons/tools.png", "Tools");
        Item tools = new Item(toolsIcon, 2);
        Combination toolsCombination = new Combination(stone, wood, tools);
        propertiesInit(toolsCombination, 13);
        recipInit(toolsIcon, 2);

        ImageIcon wheelIcon = new ImageIcon("icons/wheel.png", "Wheel");
        Item wheel = new Item(wheelIcon, 2);
        Combination wheelCombination = new Combination(tools, wood, wheel);
        propertiesInit(wheelCombination, 14);
        recipInit(wheelIcon, 2);

        ImageIcon farmingIcon = new ImageIcon("icons/farming.png", "Farming");
        Item farming = new Item(farmingIcon, 2);
        Combination farmingCombination = new Combination(earth, tools, farming);
        propertiesInit(farmingCombination, 15);
        recipInit(farmingIcon, 2);

        ImageIcon goldIcon = new ImageIcon("icons/gold.png", "Gold");
        Item gold = new Item(goldIcon, 2);
        Combination goldCombination = new Combination(stone, tools, gold);
        propertiesInit(goldCombination, 16);
        recipInit(goldIcon, 2);

        // -----------------------------IRON AGE--------------------------------//
        ImageIcon metalIcon = new ImageIcon("icons/metal.png", "Metal");
        Item metal = new Item(metalIcon, 3);
        Combination metalCombination = new Combination(fire, stone, metal);
        propertiesInit(metalCombination, 17);
        recipInit(metalIcon, 3);

        ImageIcon swordIcon = new ImageIcon("icons/sword.png", "Swoard");
        Item sword = new Item(swordIcon, 3);
        Combination swordCombination = new Combination(metal, wood, sword);
        propertiesInit(swordCombination, 18);
        recipInit(swordIcon, 3);

        ImageIcon waterWheelIcon = new ImageIcon("icons/waterWheel.png", "Water Wheel");
        Item waterWheel = new Item(waterWheelIcon, 3);
        Combination waterWheelCombination = new Combination(water, wheel, waterWheel);
        propertiesInit(waterWheelCombination, 19);
        recipInit(waterWheelIcon, 3);

        ImageIcon glassIcon = new ImageIcon("icons/glass.png", "Glass");
        Item glass = new Item(glassIcon, 3);
        Combination glassCombination = new Combination(sand, fire, glass);
        propertiesInit(glassCombination, 20);
        recipInit(glassIcon, 3);

        ImageIcon mirrorIcon = new ImageIcon("icons/mirror.png", "Mirror");
        Item mirror = new Item(mirrorIcon, 3);
        Combination mirrorCombination = new Combination(glass, metal, mirror);
        propertiesInit(mirrorCombination, 21);
        recipInit(mirrorIcon, 3);

        ImageIcon coinsIcon = new ImageIcon("icons/coins.png", "Coins");
        Item coins = new Item(coinsIcon, 3);
        Combination coinsCombination = new Combination(gold, tools, coins);
        propertiesInit(coinsCombination, 22);
        recipInit(coinsIcon, 3);

        // -----------------------------MODERN--------------------------------//
        ImageIcon gunpowderIcon = new ImageIcon("icons/gunpowder.png", "Gunpowder");
        Item gunpowder = new Item(gunpowderIcon, 4);
        Combination gunpowderCombination = new Combination(dust, fire, gunpowder);
        propertiesInit(gunpowderCombination, 23);
        recipInit(gunpowderIcon, 4);

        ImageIcon explosionIcon = new ImageIcon("icons/explosion.png", "Explosion");
        Item explosion = new Item(explosionIcon, 4);
        Combination explosionCombination = new Combination(fire, gunpowder, explosion);
        propertiesInit(explosionCombination, 24);
        recipInit(explosionIcon, 4);

        ImageIcon atomicBombIcon = new ImageIcon("icons/atomicBomb.png", "Atomic Bomb");
        Item atomicBomb = new Item(atomicBombIcon, 4);
        Combination atomicBombCombination = new Combination(energy, explosion, atomicBomb);
        propertiesInit(atomicBombCombination, 25);
        recipInit(atomicBombIcon, 4);

        ImageIcon electricityIcon = new ImageIcon("icons/electricity.png", "Electricity");
        Item electricity = new Item(electricityIcon, 4);
        Combination electricityCombination = new Combination(energy, metal, electricity);
        propertiesInit(electricityCombination, 26);
        recipInit(electricityIcon, 4);

        ImageIcon computerIcon = new ImageIcon("icons/computer.png", "Computer");
        Item computer = new Item(computerIcon, 4);
        Combination computerCombination = new Combination(electricity, tools, computer);
        propertiesInit(computerCombination, 27);
        recipInit(computerIcon, 4);

        ImageIcon lightBulbIcon = new ImageIcon("icons/lightbulb.png", "Light Bulb");
        Item lightbulb = new Item(lightBulbIcon, 4);
        Combination lightbulbCombination = new Combination(electricity, glass, lightbulb);
        propertiesInit(lightbulbCombination, 28);
        recipInit(lightBulbIcon, 4);

        ImageIcon paperIcon = new ImageIcon("icons/paper.png", "Paper");
        Item paper = new Item(paperIcon, 4);
        Combination paperCombination = new Combination(pressure, wood, paper);
        propertiesInit(paperCombination, 29);
        paper.setVisible(false);
        recipInit(paperIcon, 4);

    }

    public void propertiesInit(Combination combination, int slotNr) {
        CombinationManager.addCombination(combination);
        // combination.getChild().setVisible(true);
        slots[slotNr][0].add(combination.getChild());
        combination.getChild().slotNumber = slotNr;
    }

    private void recipInit(ImageIcon icon, int category) {
        Recipe recipe = new Recipe(icon, category);
        RecipeBook.addRecipe(recipe);
    }

    public void showItems() {
        // new GameFrame();

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

    // go to recipe book
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bookButton) {
            recipeBook.openBook();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        fortune.paintFortune();
        revalidate();
        repaint();
    }

    // goToShop
}
