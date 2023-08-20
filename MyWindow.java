import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clockLabel;
    private JPanel clockPanel; // Panel to center-align the clock label

    private Font headingFont = new Font("Arial", Font.BOLD, 30); // Font for the heading
    private Font clockFont = new Font("Arial", Font.BOLD, 50); // Improved font for the clock

    MyWindow() {
        super.setTitle("Digital Clock");
        super.setSize(800, 400);
        super.setLocationRelativeTo(null); // Center the window
        this.createGUI();
        this.startClock();
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createGUI() {
        heading = new JLabel("Digital Clock");
        heading.setFont(headingFont);
        heading.setHorizontalAlignment(JLabel.CENTER); // Center-align the heading

        clockLabel = new JLabel("Clock");
        clockLabel.setFont(clockFont);
        clockPanel = new JPanel();
        clockPanel.setLayout(new GridBagLayout());
        clockPanel.add(clockLabel);

        this.setLayout(new BorderLayout());
        this.add(heading, BorderLayout.NORTH);
        this.add(clockPanel, BorderLayout.CENTER);
    }

    public void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss a");
                String dateTime = sfd.format(d);
                clockLabel.setText(dateTime);
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyWindow());
    }
}
