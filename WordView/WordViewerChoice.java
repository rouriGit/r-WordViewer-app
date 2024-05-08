import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample extends JFrame {
    
    public GUIExample() {
        setTitle("GUI Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // Set the size of the frame to 500x500 pixels
        setLocationRelativeTo(null); // Center the frame on the screen
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1)); // 6 rows, 1 column
        
        // Create the five choices
        JButton choice1 = new JButton("１年生");
        JButton choice2 = new JButton("２年生");
        JButton choice3 = new JButton("３年生");
        JButton choice4 = new JButton("４年生");
        JButton choice5 = new JButton("５年生");
        JButton choice6 = new JButton("６年生");
        
        // Add the choices to the panel
        panel.add(new JLabel("何年生の漢字を勉強する？？"));
        panel.add(choice1);
        panel.add(choice2);
        panel.add(choice3);
        panel.add(choice4);
        panel.add(choice5);
        panel.add(choice6);

        // Add action listener to the choice1 button
        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                WordViewer wordviewer = new WordViewer();
                wordviewer.setVisible(true);
            }
        });

        // Add action listener to the choice5 button
        choice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                WordViewer wordviewer = new WordViewer();
                wordviewer.setVisible(true);
            }
        });
        
        // Add action listener to the choice5 button
        choice3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                WordViewer wordviewer = new WordViewer();
                wordviewer.setVisible(true);
            }
        });
        
        // Add action listener to the choice5 button
        choice4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                WordViewer wordviewer = new WordViewer();
                wordviewer.setVisible(true);
            }
        });
        
        // Add action listener to the choice5 button
        choice5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                WordViewer wordviewer = new WordViewer();
                wordviewer.setVisible(true);
            }
        });

        // Add action listener to the choice5 button
        choice6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                WordViewer wordviewer = new WordViewer();
                wordviewer.setVisible(true);
            }
        });
        
        // Add the panel to the frame
        add(panel);
    }
}
