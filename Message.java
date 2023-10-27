import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Message extends JPanel implements ActionListener{
    Item item;
    JLabel textLabel;
    ImageIcon itemImage;
    JButton closeButton;

    Message(Item item){
        this.setBounds(425, 190, 350, 220);
        this.setBorder(BorderFactory.createLineBorder(new Color(204, 173, 4), 5));
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(69, 37, 12));

        textLabel = new JLabel();
        textLabel.setText("<html><center>New Item Discovered:<br>" + item.name + "</center></html>");
        textLabel.setIcon(item.image);
		textLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		textLabel.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		textLabel.setForeground(new Color(250, 219, 195)); //set font color of text
		textLabel.setFont(new Font("Courier New", Font.PLAIN, 20)); //set font of text
		textLabel.setIconTextGap(20); //set gap of text to image
		textLabel.setOpaque(false); //display background color
		textLabel.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		textLabel.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label

        closeButton = new JButton();
        closeButton.setPreferredSize(new Dimension(150, 50));
        closeButton.setVisible(true);
		closeButton.addActionListener(this);
		closeButton.setFocusable(false);
		closeButton.setForeground(new Color(69, 37, 12));
		closeButton.setBackground(new Color(150, 119, 89));
		closeButton.setBorder(BorderFactory.createEtchedBorder());
        closeButton.setIcon(new ImageIcon("buttonImg.png"));
        closeButton.setHorizontalTextPosition(JButton.CENTER);
		closeButton.setVerticalTextPosition(JButton.BOTTOM);

        this.add(textLabel, BorderLayout.NORTH);
        this.add(closeButton, BorderLayout.SOUTH);

        this.add(Box.createRigidArea(new Dimension(5, 10))); // Add space at the top
        this.add(textLabel, BorderLayout.NORTH);
        this.add(Box.createRigidArea(new Dimension(5, 10))); // Add space between the text and button
        this.add(closeButton, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton){
            Workshop mainPage = new Workshop();
            mainPage.removeMessage(this);
            this.setVisible(false);
            
        }
    }
}
