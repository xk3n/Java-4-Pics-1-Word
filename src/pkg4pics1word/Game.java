/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4pics1word;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Game implements Runnable {

    int width = 500;
    int height = 700;
    int coinsValue = 0;
    int level = 0;
    int answerCounter = 0;
    int minLetter;
    String[] holder;
    JFrame f;
    JLabel bg;
    JLabel levelPh, coins;
    JLabel[][] picsLbl = new JLabel[2][2];
    JButton[][] letters = new JButton[2][7];
    JLabel[][] lettersBg = new JLabel[2][7];
    JButton[] answerHolder;
    JLabel[] answerHolderBg;
    Font letterFont;

    String[] shuffledLetters = new String[20];
    String[] correctAnswer = new String[20];

    ImageIcon bgImage = new ImageIcon("assets\\bg.png");
    ImageIcon[] levelPhImage = new ImageIcon[20];
    ImageIcon coinsImage = new ImageIcon("assets\\coins.png");
    ImageIcon letterImage = new ImageIcon("assets\\letters\\A.png");
    ImageIcon answerImage = new ImageIcon("assets\\letters\\answerHolder.png");
    ImageIcon[][] picsImage = new ImageIcon[20][4];

    ButtonListener buttonListener = new ButtonListener();

    Game() {
        if (level >= 0 && level <= 4) {
            minLetter = 3;
        } else if (level >= 5 && level <= 9) {
            minLetter = 4;
        } else if (level >= 10 && level <= 14) {
            minLetter = 5;
        } else if (level >= 15 && level <= 19) {
            minLetter = 6;
        }
        shuffledLetters[0] = "catuisoditoper";
        shuffledLetters[1] = "doglmipoiskdng";
        shuffledLetters[2] = "canuyzpsitjans";
        shuffledLetters[3] = "batlmabsjdnsmq";
        shuffledLetters[4] = "emonxospyiospa";
        shuffledLetters[5] = "giftzalmionksh";
        shuffledLetters[6] = "cardodlqpzshtr";
        shuffledLetters[7] = "signwilakiosht";
        shuffledLetters[8] = "codeproslmrwht";
        shuffledLetters[9] = "wavegthstyioue";
        shuffledLetters[10] = "brainksreoistw";
        shuffledLetters[11] = "sleepawtriyhmn";
        shuffledLetters[12] = "chestiwrstjoqx";
        shuffledLetters[13] = "lightstyoixmnz";
        shuffledLetters[14] = "catchystplienr";
        shuffledLetters[15] = "islanderixiqst";
        shuffledLetters[16] = "vacuumlkipoexh";
        shuffledLetters[17] = "lettershkeatrh";
        shuffledLetters[18] = "squarenxeioytt";
        shuffledLetters[19] = "sportsplaysetx";

        correctAnswer[0] = "CAT";
        correctAnswer[1] = "DOG";
        correctAnswer[2] = "CAN";
        correctAnswer[3] = "BAT";
        correctAnswer[4] = "EMO";
        correctAnswer[5] = "GIFT";
        correctAnswer[6] = "CARD";
        correctAnswer[7] = "SIGN";
        correctAnswer[8] = "CODE";
        correctAnswer[9] = "WAVE";
        correctAnswer[10] = "BRAIN";
        correctAnswer[11] = "SLEEP";
        correctAnswer[12] = "CHEST";
        correctAnswer[13] = "LIGHT";
        correctAnswer[14] = "CATCH";
        correctAnswer[15] = "ISLAND";
        correctAnswer[16] = "VACUUM";
        correctAnswer[17] = "LETTER";
        correctAnswer[18] = "SQUARE";
        correctAnswer[19] = "SPORTS";
        run();
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < letters.length; i++) {
                for (int j = 0; j < letters[i].length; j++) {
                    if (e.getSource() == letters[i][j]) {
                        if (answerCounter < answerHolder.length) {
                            int emptyElement = -1;
                            for (int k = 0; k < answerHolder.length; k++) {
                                if (answerHolder[k].getText().isEmpty()) {
                                    emptyElement = k;
                                    break;
                                }
                            }
                            letters[i][j].setVisible(false);
                            lettersBg[i][j].setVisible(false);
                            answerHolder[emptyElement].setText(letters[i][j].getText());
                            holder[emptyElement] = String.valueOf(i + "-" + j);
                            answerCounter++;
                            checkAnswer(level);
                        }
                    }
                }
            }

            for (int i = 0; i < answerHolder.length; i++) {
                if (e.getSource() == answerHolder[i]) {
                    if (answerCounter >= 0 && !answerHolder[i].getText().isEmpty()) {
                        String[] index = holder[i].split("-");
                        int row = Integer.parseInt(index[0]);
                        int col = Integer.parseInt(index[1]);
                        letters[row][col].setVisible(true);
                        lettersBg[row][col].setVisible(true);
                        answerHolder[i].setText("");
                        answerCounter--;
                    }
                }
            }

        }

    }

    public void shuffle(int i) {
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : shuffledLetters[i].toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(shuffledLetters[i].length());
        while (!characters.isEmpty()) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        shuffledLetters[i] = output.toString();
    }

    public void checkAnswer(int i) {
        boolean goNextLevel = false;
        if (answerCounter == answerHolder.length) {
            if (level >= 0 && level <= 4) {
                if (answerHolder[0].getText().charAt(0) == correctAnswer[i].charAt(0)
                        && answerHolder[1].getText().charAt(0) == correctAnswer[i].charAt(1)
                        && answerHolder[2].getText().charAt(0) == correctAnswer[i].charAt(2)) {
                    goNextLevel = true;
                }
            } else if (level >= 5 && level <= 9) {
                if (answerHolder[0].getText().charAt(0) == correctAnswer[i].charAt(0)
                        && answerHolder[1].getText().charAt(0) == correctAnswer[i].charAt(1)
                        && answerHolder[2].getText().charAt(0) == correctAnswer[i].charAt(2)
                        && answerHolder[3].getText().charAt(0) == correctAnswer[i].charAt(3)) {
                    goNextLevel = true;
                }
            } else if (level >= 10 && level <= 14) {
                if (    answerHolder[0].getText().charAt(0) == correctAnswer[i].charAt(0)
                        && answerHolder[1].getText().charAt(0) == correctAnswer[i].charAt(1)
                        && answerHolder[2].getText().charAt(0) == correctAnswer[i].charAt(2)
                        && answerHolder[3].getText().charAt(0) == correctAnswer[i].charAt(3)
                        && answerHolder[4].getText().charAt(0) == correctAnswer[i].charAt(4)) {
                    goNextLevel = true;
                }
            } else if (level >= 15 && level <= 19) {
                if (    answerHolder[0].getText().charAt(0) == correctAnswer[i].charAt(0)
                        && answerHolder[1].getText().charAt(0) == correctAnswer[i].charAt(1)
                        && answerHolder[2].getText().charAt(0) == correctAnswer[i].charAt(2)
                        && answerHolder[3].getText().charAt(0) == correctAnswer[i].charAt(3)
                        && answerHolder[4].getText().charAt(0) == correctAnswer[i].charAt(4)
                        && answerHolder[5].getText().charAt(0) == correctAnswer[i].charAt(5)) {
                    goNextLevel = true;
                }
            }

            if (goNextLevel) {
                level++;
                if (level == 20) {
                    int choices = JOptionPane.showConfirmDialog(f, "Congratulations! you have reached the end of the game.\n Your final score is" + level * coinsValue + ".\nClick YES to play again, NO to exit.", "Thank you for playing our game!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (choices == JOptionPane.YES_OPTION) {
                        f.dispose();
                        f.setVisible(false);
                        level = 0;
                        coinsValue = 0;
                        answerCounter = 0;
                        run();
                    }else{
                        System.exit(0);
                    }
                }
                JOptionPane.showConfirmDialog(f, "Good Job!\nLets Proceed on level " + (level + 1), "Congrats!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                f.dispose();
                f.setVisible(false);
                coinsValue += 3;
                answerCounter = 0;
                if (level >= 0 && level <= 4) {
                    minLetter = 3;
                } else if (level >= 5 && level <= 9) {
                    minLetter = 4;
                } else if (level >= 10 && level <= 14) {
                    minLetter = 5;
                } else if (level >= 15 && level <= 19) {
                    minLetter = 6;
                }
                run();
            }
        }
    }

    @Override
    public void run() {
        answerHolder = new JButton[minLetter];
        answerHolderBg = new JLabel[minLetter];
        holder = new String[minLetter];
        f = new JFrame("4 Pics 1 word");
        f.setSize(width, height);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        letterFont = new Font("Arial", Font.BOLD, 33);

        for (int i = 0; i < picsImage.length; i++) {
            for (int j = 0; j < picsImage[i].length; j++) {
                picsImage[i][j] = new ImageIcon("assets\\4pics\\pics" + i + "_" + j + ".png");
            }
        }
        for (int i = 0; i < levelPhImage.length; i++) {
            levelPhImage[i] = new ImageIcon("assets\\level\\level" + (i + 1) + ".png");
        }
        int x = 0;
        for (int i = 0; i < picsLbl.length; i++) {
            for (int j = 0; j < picsLbl.length; j++) {
                picsLbl[i][j] = new JLabel(picsImage[level][x++]);
                picsLbl[i][j].setBounds(85 + 170 * (i), 100 + 160 * j, picsImage[level][i].getIconWidth(), picsImage[level][i].getIconHeight());
                picsLbl[i][j].setOpaque(false);
                picsLbl[i][j].setBackground(Color.red);
                f.add(picsLbl[i][j]);
            }
        }
        x = 0;

        shuffle(level);
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                letters[i][j] = new JButton(String.valueOf(shuffledLetters[level].toUpperCase().charAt(x++)));
                letters[i][j].setBounds(40 + 60 * j, 520 + 60 * i, letterImage.getIconWidth(), letterImage.getIconHeight());
                letters[i][j].setOpaque(false);
                letters[i][j].setFont(letterFont);
                letters[i][j].setForeground(new Color(77, 77, 77));
                letters[i][j].setBorder(null);
                letters[i][j].setBackground(Color.red);
                letters[i][j].addActionListener(buttonListener);
                f.add(letters[i][j]);
                lettersBg[i][j] = new JLabel(letterImage);
                lettersBg[i][j].setBounds(40 + 60 * j, 520 + 60 * i, letterImage.getIconWidth(), letterImage.getIconHeight());
                lettersBg[i][j].setOpaque(false);
                lettersBg[i][j].setBorder(null);
                lettersBg[i][j].setBackground(Color.red);
                f.add(lettersBg[i][j]);
            }
        }

        int[] answerHolderPadding = {
            150, 150, 150, 150, 150,
            120, 120, 120, 120, 120,
            90, 90, 90, 90, 90,
            60, 60, 60, 60, 60
        };
        for (int i = 0; i < answerHolder.length; i++) {
            answerHolder[i] = new JButton();
            answerHolder[i].setBounds(answerHolderPadding[level] + 60 * i, 450, letterImage.getIconWidth(), letterImage.getIconHeight());
            answerHolder[i].setOpaque(false);
            answerHolder[i].setBorder(null);
            answerHolder[i].setFont(letterFont);
            answerHolder[i].setBackground(Color.red);
            answerHolder[i].addActionListener(buttonListener);
            f.add(answerHolder[i]);
            answerHolderBg[i] = new JLabel(answerImage);
            answerHolderBg[i].setBounds(answerHolderPadding[level] + 60 * i, 450, letterImage.getIconWidth(), letterImage.getIconHeight());
            f.add(answerHolderBg[i]);
        }
        levelPh = new JLabel(levelPhImage[level]);
        levelPh.setBounds(width / 2 - levelPhImage[level].getIconWidth() / 2, 10, levelPhImage[level].getIconWidth(), levelPhImage[level].getIconHeight());
        f.add(levelPh);

        coins = new JLabel(coinsImage);
        coins.setBounds(width - 120, 20, coinsImage.getIconWidth() + 75, coinsImage.getIconHeight());
        coins.setForeground(new Color(77, 77, 77));
        coins.setText(String.valueOf(coinsValue));
        f.add(coins);

        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, width, height);
        f.add(bg);
    }
    
}
