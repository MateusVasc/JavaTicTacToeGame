package JavaTicTacToeGame.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    }

    public void firstToPlay() {
        
    }

    public void checkWinner() {

    }

    public void checkXWinner(int buttonOne, int buttonTwo, int buttonThree) {

    }

    public void checkOWinner(int buttonOne, int buttonTwo, int buttonThree) {

    }
}