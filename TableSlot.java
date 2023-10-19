import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

public class TableSlot extends Slot {

    public TableSlot(Point corner, int page) {
        super(corner, page);

        this.removeMouseListener(this.pressReactor);
        TablePressReactor tablePressReactor = new TablePressReactor();
        this.addMouseListener(tablePressReactor);
    }

    public class TablePressReactor extends MouseAdapter {

        public void mousePressed(MouseEvent e) {

            System.out.println("mouse pressed in tableslot");
            MouseTracker mouse = new MouseTracker();

            // getting the component from the slot?????????????
            mouse.mouseSlot.add(component);
            System.out.println("mouse has component: " + mouse.mouseSlot.component.parent1);

            TableSlot.this.remove(TableSlot.this.component);

            // add the other stuff, background etc
        }

        public void combine(Component item1, Component item2) {

        }

    }
}
