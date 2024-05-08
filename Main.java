import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordViewerStart extends JFrame {

    public WordViewerStart() {
        setTitle("GUI Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // Set the size of the frame to 500x500 pixels
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1)); // 6 rows, 1 column

        // Create the start button
        JButton startButton = new JButton("Start");

        // Add action listener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call GUIExample when the start button is clicked
                GUIExample guiExample = new GUIExample();
                guiExample.setVisible(true);
            }
        });

        // Add the start button to the panel
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(startButton);

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordViewerStart wordViewerStart = new WordViewerStart();
            wordViewerStart.setVisible(true);
        });
    }
}
