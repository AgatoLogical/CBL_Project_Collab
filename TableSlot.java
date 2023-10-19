import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

public class TableSlot extends Slot {

    public TableSlot(Point corner, int page) {
        super(corner, page);
        // TODO Auto-generated constructor stub
    }

    private class TablePressReactor extends PressReactor {

        @Override
        public void mousePressed(MouseEvent e) {
            MouseTracker mouse = new MouseTracker();

            // getting the component from the slot?????????????
            List<JLabel> list = new ArrayList<JLabel>();
            JComponent[] components = panel.getComponents();

            for (JComponent component : components) {
                if (component.getClass().equals(JLabel.class)) {
                    list.add((JLabel) component);
                }
            }
            mouse.mouseSlot.add(list.get(0));

            this.removeAll();

            // add the other stuff, background etc
        }

        public void combine(Component item1, Component item2) {

        }

    }
}
