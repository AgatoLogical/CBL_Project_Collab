import java.awt.*;

import javax.swing.*;

public class Fortune extends JPanel {

    public static int fortune = 0;
    private JLabel label = new JLabel();
    private ImageIcon fortuneIcon = new ImageIcon("fortune.png");
    private String fortuneText;

    public Fortune() {
        this.setBackground(new Color(112, 81, 52));
        this.setBounds(925, 680, 250, 100);

        Image image = fortuneIcon.getImage();
        Image newimg = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
        this.fortuneIcon = new ImageIcon(newimg);
        this.label.setIcon(fortuneIcon);

        this.fortuneText = "" + fortune;
        this.label.setText(fortuneText);

        this.label.setHorizontalTextPosition(JLabel.RIGHT);
        this.label.setVerticalTextPosition(JLabel.CENTER);

        this.label.setVerticalAlignment(JLabel.CENTER);
        this.label.setHorizontalAlignment(JLabel.LEFT);

        this.label.setForeground(new Color(245, 245, 220));
        this.label.setFont(new Font("Algerian", Font.BOLD, 24));

        this.add(label);

        // spendFortune(new Component(fortuneIcon));

    }

    // bookButton.setBounds(25, 680, 100, 100);
    // bookButton.setBackground(new Color(112, 81, 52));

    public void gainFortune(Component item) {
        fortune += item.getValue();
        this.fortuneText = "" + fortune;
        this.label.setText(fortuneText);

        repaint();
    }

    public boolean spendFortune(Component item) {
        if (fortune - item.getValue() >= 0) {
            fortune -= item.getValue();
            this.fortuneText = "" + fortune;
            this.label.setText(fortuneText);
            repaint();
            return true;
        }
        return false;
    }
}