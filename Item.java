import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Item extends JLabel{
    public String name;
    public final int value = 0;

    ImageIcon image;

    Point imageCorner;
    Point prevPt;

    int slotNumber;

    public Item(ImageIcon icon) {
        image = icon;
        this.setIcon(icon);
        this.setVisible(false);
        imageCorner = new Point(0, 0);
        //ClickListener clickListener = new ClickListener();
        //DragListener dragListener = new DragListener();
        //this.addMouseListener(clickListener);
        //this.addMouseMotionListener(dragListener);
    }

    public void moveBack(Timer timer){
        timer.start();
    }

    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {

        public void mouseDragged(MouseEvent e){

            Point currentPt = e.getPoint();

            imageCorner.translate(
                (int)(currentPt.getX() - prevPt.getX()),
                (int)(currentPt.getY() - prevPt.getY())
            );
            prevPt = currentPt;
            repaint();
        }
    }*/

    /*public String combine(String item1, String item2) {
        this.setVisible(true);
        return null;
    }*/
}