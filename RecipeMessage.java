import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RecipeMessage extends JPanel implements ActionListener {

    static final int width = 200;
    static final int height = 200;

    ImageIcon backgroundIcon = new ImageIcon("piece_of_paper.png");
    JLabel backgroundLabel = new JLabel();

    ImageIcon textIcon = new ImageIcon("coins_sketch.png");
    JLabel textLabel = new JLabel();

    ImageIcon closeIcon = new ImageIcon("close_button_book.png");
    JButton closeButton = new JButton();

    JLayeredPane layeredPane = new JLayeredPane();

    RecipeMessage() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(false);

        layeredPane.setBounds(0, 0, width, height);

        Image image = backgroundIcon.getImage();
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(newImg);
        this.backgroundLabel.setIcon(backgroundIcon);

        this.backgroundLabel.setBackground(new Color(0, 0, 0, 0));
        this.backgroundLabel.setBounds(0, 0, width, height);
        this.backgroundLabel.setOpaque(true);

        this.textLabel.setText("Not enough");
        image = textIcon.getImage();
        newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        textIcon = new ImageIcon(newImg);
        this.textLabel.setIcon(textIcon);
        this.textLabel.setForeground(new Color(0, 32, 96));
        this.textLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 32));

        this.textLabel.setBackground(new Color(5, 0, 0, 0));
        this.textLabel.setBounds(1, 1, width - 1, height - 1);
        this.textLabel.setHorizontalAlignment(JLabel.CENTER);
        this.textLabel.setVerticalAlignment(JLabel.CENTER);
        this.textLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.textLabel.setVerticalTextPosition(JLabel.TOP);

        this.textLabel.setOpaque(true);

        image = closeIcon.getImage();
        newImg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        closeIcon = new ImageIcon(newImg);
        this.closeButton.setIcon(closeIcon);

        this.closeButton.setBackground(new Color(0, 0, 0, 0));
        this.closeButton.setBounds(10, 10, 25, 25);
        this.closeButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0)));
        this.closeButton.setVisible(true);
        this.closeButton.addActionListener(this);

        layeredPane.add(backgroundLabel, Integer.valueOf(1));
        layeredPane.add(textLabel, Integer.valueOf(2));
        layeredPane.add(closeButton, Integer.valueOf(3));

        this.add(layeredPane);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            this.setVisible(false);
        }
    }

}
