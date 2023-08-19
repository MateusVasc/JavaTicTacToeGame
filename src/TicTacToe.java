package JavaTicTacToeGame.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random(); // creating  a Random instance
    JFrame gameFrame = new JFrame(); // creating a JFrame instance
    JPanel titlePanel = new JPanel(); // creating a JPanel instance
    JPanel buttonPanel = new JPanel(); // creating a JPanel instance
    JLabel fieldLabel = new JLabel(); // creating a JLabel instance
    JButton[] buttons = new JButton[9]; // creating a list of 9 buttons
    JFrame newGameFrame; // creating a new JFrame instance
    JButton buttonPlayAgain; // creating a JButton variable
    JButton buttonClose; // creating a JButton variable
    boolean player1Turn; // boolean value responsible for knowing which player gets to play at the moment

    public TicTacToe() {
        // setting up frame configuration
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setTitle("Tic-Tac-Toe Game");
        gameFrame.setSize(600,600);
        gameFrame.setLocation(388,57);
        gameFrame.getContentPane().setBackground(new Color(50,50,50));
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setVisible(true);

        // setting up label configuration
        fieldLabel.setBackground(new Color(25,25,25));
        fieldLabel.setForeground(new Color(25,255,0));
        fieldLabel.setFont(new Font("Ink Free",Font.BOLD,50));
        fieldLabel.setHorizontalAlignment(JLabel.CENTER);
        fieldLabel.setText("Tic-Tac-Toe Game");
        fieldLabel.setOpaque(true);

        // setting up panel configuration
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        // setting up buttons configuration
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        // adding all the buttons to the panel, as well as adding their listeners
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,85));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // setting up new game stuff
        buttonPlayAgain = new JButton(); // creating a new button
        buttonPlayAgain.setFont(new Font("MV Boli",Font.BOLD,12));
        buttonPlayAgain.setText("Play again?");
        buttonPlayAgain.setFocusable(false);
        buttonPlayAgain.addActionListener(this);
        buttonClose = new JButton(); // creating a new button
        buttonClose.setFont(new Font("MV Boli",Font.BOLD,12));
        buttonClose.setText("Close");
        buttonClose.setFocusable(false);
        buttonClose.addActionListener(this);
        // end of the new game stuff

        titlePanel.add(fieldLabel); // adding the label to the panel

        gameFrame.add(titlePanel,BorderLayout.NORTH); // adding the panel to the frame window with its position
                                                  // on a borderlayot model

        gameFrame.add(buttonPanel); // adding  the button panel to the frame window

        firstToPlay(); // calling the firstToPlay method
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPlayAgain) playAgain();
        if (e.getSource() == buttonClose) endGame();
        // method to verify the player's actions through the gameplay
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                // verifying which player is clicking in the button
                if (player1Turn) {
                    // verifying if the button is actually "empty"
                    if (Objects.equals(buttons[i].getText(), "")) {
                        // filling in the button,
                        // setting next player's turn
                        // and checking if there is a winner
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        fieldLabel.setText("O turn");
                        checkWinner();
                    }
                } else {
                    // same process to the other player...
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
        // creating player turn management by verifying the result number of the random instance
        // which may be 0 or 1
        player1Turn = random.nextInt(2) == 0;

        // disabling the buttons to preserve the sleeping state of the Thread
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        // creating a sleeping between the game label and the player turn label
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // enabling the buttons after the end of the sleeping process
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
        }

        // adding a label to identify the player's turn through the boolean variable
        // true means X's player turn while false means O's player turn
        if (player1Turn) {
            fieldLabel.setText("X turn");
        } else {
            fieldLabel.setText("O turn");
        }
    }

    public void checkWinner() {
        // checking all the X's player winning conditions
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
        } /* O's winning conditions */ else if (      (Objects.equals(buttons[0].getText(), "O")) &&
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
        // making X's player winning buttons green
        buttons[buttonOne].setBackground(Color.GREEN);
        buttons[buttonTwo].setBackground(Color.GREEN);
        buttons[buttonThree].setBackground(Color.GREEN);

        // disabling the buttons
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        // adding a new title in the panel to inform the winning player
        fieldLabel.setText("X won");
        restart(player1Turn);
    }

    public void yWon(int buttonOne, int buttonTwo, int buttonThree) {
        // making O's player winning buttons green
        buttons[buttonOne].setBackground(Color.GREEN);
        buttons[buttonTwo].setBackground(Color.GREEN);
        buttons[buttonThree].setBackground(Color.GREEN);

        // disabling the buttons
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        // adding a new title in the panel to inform the winning player
        fieldLabel.setText("O won");
        restart(player1Turn);
    }

    public void restart(boolean player1Turn) {
        newGameFrame = new JFrame(); // creating a new JFrame instance

        // setting up frame configuration
        newGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newGameFrame.setTitle("Tic-Tac-Toe Game");
        newGameFrame.setSize(400,145);
        newGameFrame.setLocation(488,250);
        newGameFrame.getContentPane().setBackground(Color.white);
        newGameFrame.setLayout(new BorderLayout());
        newGameFrame.setVisible(true);

        JLabel newFieldLabel = new JLabel(); // creating a new JLabel instance

        // setting up label configuration
        newFieldLabel.setBackground(new Color(25,25,25));
        newFieldLabel.setForeground(new Color(25,255,0));
        newFieldLabel.setFont(new Font("Ink Free",Font.BOLD,50));
        newFieldLabel.setHorizontalAlignment(JLabel.CENTER);
        newFieldLabel.setText("Game Over");
        newFieldLabel.setOpaque(true);

        JPanel newTitlePanel = new JPanel(); // creating a new JPanel instance
        // setting up panel configuration
        newTitlePanel.setLayout(new BorderLayout());
        newTitlePanel.setBounds(0,0,800,100);

        JPanel newButtonPanel = new JPanel(); // creating a new JPanel instance
        newButtonPanel.setLayout(new FlowLayout());
        newButtonPanel.setBackground(Color.BLACK);

        newButtonPanel.add(buttonPlayAgain);
        newButtonPanel.add(createBlankSpace(40));
        newButtonPanel.add(buttonClose);

        newTitlePanel.add(newFieldLabel); // adding the label to the panel

        newGameFrame.add(newTitlePanel,BorderLayout.NORTH); // adding the panel to the frame window
                                                            // with its position on a borderlayot model

        newGameFrame.add(newButtonPanel);
    }

    private static Component createBlankSpace(int width) {
        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(width, 0));
        return space;
    }

    public void playAgain() {
        // creating a new instance of the game
        TicTacToe newGame = new TicTacToe();
        // closing the frame
        gameFrame.dispose();
        newGameFrame.dispose();
    }

    public void endGame() {
        System.exit(0);
    }
}
