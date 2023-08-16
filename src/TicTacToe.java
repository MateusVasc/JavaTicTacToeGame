package JavaTicTacToeGame.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel fieldLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocation(388,57);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        fieldLabel.setBackground(new Color(25,25,25));
        fieldLabel.setForeground(new Color(25,255,0));
        fieldLabel.setFont(new Font("Ink Free",Font.BOLD,50));
        fieldLabel.setHorizontalAlignment(JLabel.CENTER);
        fieldLabel.setText("Tic-Tac-Toe Game");
        fieldLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,85));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(fieldLabel);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstToPlay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        fieldLabel.setText("O turn");
                        checkWinner();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        fieldLabel.setText("X turn");
                        checkWinner();
                    }
                }
            }
        }
    }

    public void firstToPlay() {
        player1Turn = random.nextInt(2) == 0;

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
        }

        if (player1Turn) {
            fieldLabel.setText("X turn");
        } else {
            fieldLabel.setText("O turn");
        }
    }

    public void checkWinner() {
        // X winning conditions
        if (    (Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[2].getText(), "X"))
        ) {
            xWon(0,1,2);
        } else if (     (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X"))
        ) {
            xWon(3,4,5);
        } else if (     (Objects.equals(buttons[6].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWon(6,7,8);
        } else if (     (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWon(0,3,6);
        } else if (     (Objects.equals(buttons[1].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X"))
        ) {
            xWon(1,4,7);
        } else if (     (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWon(2,5,8);
        } else if (     (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWon(0,4,8);
        } else if (     (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWon(2,4,6);
        } /* O winning conditions */ else if (      (Objects.equals(buttons[0].getText(), "O")) &&
                                                    (Objects.equals(buttons[1].getText(), "O")) &&
                                                    (Objects.equals(buttons[2].getText(), "O"))
        ) {
            yWon(0,1,2);
        } else if (     (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O"))
        ) {
            yWon(3,4,5);
        } else if (     (Objects.equals(buttons[6].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            yWon(6,7,8);
        } else if (     (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O"))
        ) {
            yWon(0,3,6);
        } else if (     (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O"))
        ) {
            yWon(1,4,7);
        } else if (     (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            yWon(2,5,8);
        } else if (     (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            yWon(0,4,8);
        } else if (     (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O"))
        ) {
            yWon(2,4,6);
        }
    }

    public void xWon(int buttonOne, int buttonTwo, int buttonThree) {
        buttons[buttonOne].setBackground(Color.GREEN);
        buttons[buttonTwo].setBackground(Color.GREEN);
        buttons[buttonThree].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        fieldLabel.setText("X won");
    }

    public void yWon(int buttonOne, int buttonTwo, int buttonThree) {
        buttons[buttonOne].setBackground(Color.GREEN);
        buttons[buttonTwo].setBackground(Color.GREEN);
        buttons[buttonThree].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        fieldLabel.setText("O won");
    }
}
