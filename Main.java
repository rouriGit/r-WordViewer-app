import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordViewer extends JFrame {
    private List<String[]> wordList;
    private int currentIndex = 0;
    private JLabel wordLabel;

    public WordViewer() {
        super("Word Viewer");

        // デスクトップ上のCSVファイルのパス
        String csvFilePath = System.getProperty("user.home") + "/Desktop/WordView/" + "wordViewerGrade5.csv";

        // CSVファイルから単語リストを読み込む
        wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                wordList.add(parts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // GUI要素の設定
        wordLabel = new JLabel();
        wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        updateWordLabel();

        add(wordLabel);

        addKeyListener(new ArrowKeyListener());

        setPreferredSize(new Dimension(390, 844));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateWordLabel() {
        if (currentIndex >= 0 && currentIndex < wordList.size()) {
            wordLabel.setText(wordList.get(currentIndex)[0]);
        } else {
            wordLabel.setText("No more words");
        }
    }

    private class ArrowKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // Not used in this example
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_RIGHT:
                    currentIndex = Math.min(currentIndex + 1, wordList.size() - 1);
                    updateWordLabel();
                    break;
                case KeyEvent.VK_LEFT:
                    currentIndex = Math.max(currentIndex - 1, 0);
                    updateWordLabel();
                    break;
                case KeyEvent.VK_SPACE:
                    // スペースキーが押された場合、2列目を表示する
                    if (currentIndex >= 1 && currentIndex < wordList.size()) {
                        String[] word = wordList.get(currentIndex);
                        wordLabel.setText(word[1]);
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_RIGHT:
                    break;
                case KeyEvent.VK_LEFT:
                    break;
                case KeyEvent.VK_SPACE:
                    String[] word = wordList.get(currentIndex);
                    wordLabel.setText(word[0]);
                    break;
            }

            // directionLabel.setText("released\n" + arrowDirection);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordViewer::new);
    }
}
