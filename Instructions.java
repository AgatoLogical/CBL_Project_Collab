import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Instructions extends JPanel implements ActionListener{
    Item item;
    JLabel textLabel;
    ImageIcon itemImage;
    JButton closeButton;
    JPanel buttonPanel;
    private Workshop mainPage;

    Instructions(Workshop mainPage){
        this.mainPage = mainPage;

        this.setBounds(425, 185, 350, 255);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(69, 37, 12));

        textLabel = new JLabel();
        textLabel.setText("<html><br><center>Welcome!<br>Mix Items together by dragging them onto the table and have fun discovering new combinations!</center></html>");
        //textLabel.setIcon(item.image);
		textLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		textLabel.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		textLabel.setForeground(new Color(250, 219, 195)); //set font color of text
		textLabel.setFont(new Font("Courier New", Font.PLAIN, 20)); //set font of text
		//textLabel.setIconTextGap(15); //set gap of text to image
		textLabel.setOpaque(false); //display background color
		textLabel.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		textLabel.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(350, 70));
        buttonPanel.setOpaque(false);

        closeButton = new JButton();
        closeButton.setPreferredSize(new Dimension(60, 40));
        closeButton.setVisible(true);
		closeButton.addActionListener(this);
		closeButton.setFocusable(false);
		//closeButton.setForeground(new Color(69, 37, 12));
		//closeButton.setBackground(new Color(150, 119, 89));
		//closeButton.setBorder(BorderFactory.createEtchedBorder());
        closeButton.setBackground(new Color(150, 119, 89));
        closeButton.setBorder(BorderFactory.createEtchedBorder());
        closeButton.setIcon(new ImageIcon("close.png"));
        //closeButton.setHorizontalTextPosition(JButton.CENTER);
		//closeButton.setVerticalTextPosition(JButton.BOTTOM);
        buttonPanel.add(closeButton);

        this.add(textLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton){
            //Workshop mainPage = new Workshop();
            mainPage.removeInstructions();
            this.setVisible(false);
        }
    }
}