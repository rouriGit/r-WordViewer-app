// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// public class WordViewer extends JFrame {
//     private List<String[]> wordList;
//     private int currentIndex = 0;
//     private JLabel wordLabel;
//     private int grade;

//     public WordViewer(int grade) {
//         super("Word Viewer");

//         // デスクトップ上のCSVファイルのパス
//         this.grade = grade;
//         String csvFilePath = System.getProperty("user.home") + "/Desktop/WordView/" + "wordViewerGrade" + grade + ".csv";

//         // CSVファイルから単語リストを読み込む
//         wordList = new ArrayList<>();
//         try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] parts = line.split(",");
//                 wordList.add(parts);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // GUI要素の設定
//         wordLabel = new JLabel();
//         wordLabel.setHorizontalAlignment(JLabel.CENTER);
//         wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
//         updateWordLabel();

//         add(wordLabel);

        

//         // addKeyListener(new ModeYomi());
//         addKeyListener(new ModeRei());

//         setPreferredSize(new Dimension(390, 844));
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         pack();
//         setLocationRelativeTo(null);
//         setVisible(true);
//     }

//     private void updateWordLabel() {
//         if (currentIndex >= 0 && currentIndex < wordList.size()) {
//             wordLabel.setText(wordList.get(currentIndex)[0]);
//         } else {
//             wordLabel.setText("No more words");
//         }
//     }

//     private class ModeYomi implements KeyListener {
//         @Override
//         public void keyTyped(KeyEvent e) {
//             // Not used in this example
//         }

//         @Override
//         public void keyPressed(KeyEvent e) {
//             int keyCode = e.getKeyCode();
//             switch (keyCode) {
//                 case KeyEvent.VK_RIGHT:
//                     currentIndex = Math.min(currentIndex + 1, wordList.size() - 1);
//                     updateWordLabel();
//                     break;
//                 case KeyEvent.VK_LEFT:
//                     currentIndex = Math.max(currentIndex - 1, 0);
//                     updateWordLabel();
//                     break;
//                 case KeyEvent.VK_SPACE:
//                     // スペースキーが押された場合、2列目を表示する
//                     if (currentIndex >= 1 && currentIndex < wordList.size()) {
//                         String[] word = wordList.get(currentIndex);
//                         wordLabel.setText(word[2]);
//                     }
//                     break;
//             }
//         }

//         @Override
//         public void keyReleased(KeyEvent e) {
//             int keyCode = e.getKeyCode();

//             switch (keyCode) {
//                 case KeyEvent.VK_RIGHT:
//                     break;
//                 case KeyEvent.VK_LEFT:
//                     break;
//                 case KeyEvent.VK_SPACE:
//                     String[] word = wordList.get(currentIndex);
//                     wordLabel.setText(word[0]);
//                     break;
//             }

//             // directionLabel.setText("released\n" + arrowDirection);
//         }
//     }

//     private class ModeRei implements KeyListener {

//         int randomNumber;

//         @Override
//         public void keyTyped(KeyEvent e) {
//             // Not used in this example
//         }

//         @Override
//         public void keyPressed(KeyEvent e) {
//             int keyCode = e.getKeyCode();
//             Random rand = new Random();

//             String line = "data1,data2,data3,data4,data5,data6"; // CSVファイルから読み込んだ一行の例
//             String[] data = line.split(",");
//             int numberOfData = data.length;

//             switch (keyCode) {
//                 case KeyEvent.VK_RIGHT:
//                     currentIndex = Math.min(currentIndex + 1, wordList.size() - 1);
//                     updateWordLabel();

//                     randomNumber = rand.nextInt(numberOfData) + 2;
//                     break;
//                 case KeyEvent.VK_LEFT:
//                     currentIndex = Math.max(currentIndex - 1, 0);
//                     updateWordLabel();

//                     randomNumber = rand.nextInt(numberOfData) + 2;
//                     break;
//                 case KeyEvent.VK_SPACE:
//                     // スペースキーが押された場合、2列目を表示する
//                     if (currentIndex >= 1 && currentIndex < wordList.size()) {
//                         String[] word = wordList.get(currentIndex);
                        
//                         // Random rand = new Random();
//                         // int randomNumber = rand.nextInt(wordList.size()) + 2;
//                         wordLabel.setText(word[randomNumber]);
//                     }
//                     break;
//             }
//         }

//         @Override
//         public void keyReleased(KeyEvent e) {
//             int keyCode = e.getKeyCode();

//             switch (keyCode) {
//                 case KeyEvent.VK_RIGHT:
//                     break;
//                 case KeyEvent.VK_LEFT:
//                     break;
//                 case KeyEvent.VK_SPACE:
//                     String[] word = wordList.get(currentIndex);
//                     wordLabel.setText(word[0]);
//                     break;
//             }

//             // directionLabel.setText("released\n" + arrowDirection);
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(WordViewer::new);
//     }
// }


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
import java.util.Random;

public class WordViewer extends JFrame {
    private List<String[]> wordList;
    private int currentIndex = 0;
    private JLabel wordLabel;
    private int grade;

    public WordViewer(int grade) {
        super("Word Viewer");

        // デスクトップ上のCSVファイルのパス
        this.grade = grade;
        String csvFilePath = System.getProperty("user.home") + "/Desktop/WordView/" + "wordViewerGrade" + grade + ".csv";

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
        setLayout(new FlowLayout());
        JLabel wordLabel = new JLabel();
        wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        updateWordLabel();

        panel.add(wordLabel);

        

        // addKeyListener(new ModeYomi());
        addKeyListener(new ModeRei());
    }

    private void updateWordLabel() {
        if (currentIndex >= 0 && currentIndex < wordList.size()) {
            wordLabel.setText(wordList.get(currentIndex)[0]);
        } else {
            wordLabel.setText("No more words");
        }
    }

    private class ModeYomi implements KeyListener {
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
                        wordLabel.setText(word[2]);
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

    private class ModeRei implements KeyListener {

        int randomNumber;

        @Override
        public void keyTyped(KeyEvent e) {
            // Not used in this example
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            Random rand = new Random();

            String line = "data1,data2,data3,data4,data5,data6"; // CSVファイルから読み込んだ一行の例
            String[] data = line.split(",");
            int numberOfData = data.length;

            switch (keyCode) {
                case KeyEvent.VK_RIGHT:
                    currentIndex = Math.min(currentIndex + 1, wordList.size() - 1);
                    updateWordLabel();

                    randomNumber = rand.nextInt(numberOfData) + 2;
                    break;
                case KeyEvent.VK_LEFT:
                    currentIndex = Math.max(currentIndex - 1, 0);
                    updateWordLabel();

                    randomNumber = rand.nextInt(numberOfData) + 2;
                    break;
                case KeyEvent.VK_SPACE:
                    // スペースキーが押された場合、2列目を表示する
                    if (currentIndex >= 1 && currentIndex < wordList.size()) {
                        String[] word = wordList.get(currentIndex);
                        
                        // Random rand = new Random();
                        // int randomNumber = rand.nextInt(wordList.size()) + 2;
                        wordLabel.setText(word[randomNumber]);
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
