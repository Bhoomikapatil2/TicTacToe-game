import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class tictactoe implements  ActionListener {
    Random random = new Random();
    JFrame f = new JFrame("Tic-Tac-Toe");
    JPanel tp = new JPanel();
    JPanel bp = new JPanel();

    JLabel l1 = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1;

    tictactoe() {

        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Serif", Font.PLAIN, 30));
        newGameButton.setBackground(Color.GREEN);
        newGameButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame(); }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.getContentPane().setBackground(new Color(50, 50, 50));
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        l1.setBackground(new Color(25, 25, 25));
        l1.setForeground(new Color(25, 255, 0));
        l1.setFont(new Font("Georgia", Font.PLAIN, 70));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setText("TicTacToe");
        l1.setOpaque(true);

        tp.setLayout(new BorderLayout());
        tp.setBounds(0, 0, 800, 800);
        bp.setLayout(new GridLayout(3, 3));
        bp.setBackground(new Color(125, 125, 125));
        tp.add(l1,BorderLayout.CENTER);

        tp.add(newGameButton, BorderLayout.EAST);
        f.add(tp, BorderLayout.NORTH);
        f.add(bp);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            bp.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

            firstTurn();
        }

    }

    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 9; i++) {
            if (ae.getSource() == buttons[i]) {
                if (player1) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(12, 12, 12));
                        buttons[i].setText("X");
                        player1 = false;
                        l1.setText("O-turn");
                        checkWin();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(100, 120, 120));
                        buttons[i].setText("O");
                        player1 = true;
                        l1.setText("X-turn");
                        checkWin();
                    }
                }
            }

        }

    }

    public void firstTurn() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//             //TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        if(random.nextInt(2)==0){
        player1=true;
        l1.setText("X-turn");
    }
    else{
        player1=false;
        l1.setText("O-turn");
    }


           }

    public void checkWin(){
            if((buttons[0].getText()=="X") && (buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){
                checkXwin(0,1,2);
            }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
            checkXwin(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
            checkXwin(6,7,8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
            checkXwin(0,3,6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
            checkXwin(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
            checkXwin(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
            checkXwin(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
            checkXwin(2,4,6);
        }


        // o winning
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O")&&(buttons[2].getText()=="O")){
            checkOwin(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){
            checkOwin(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){
            checkOwin(6,7,8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){
            checkOwin(0,3,6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){
            checkOwin(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){
            checkOwin(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){
            checkOwin(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){
            checkOwin(2,4,6);
        }


        boolean draw = true;
    for (int i = 0; i < 9; i++){
        if (buttons[i].getText().isEmpty()){
        draw = false;
        break;
        }
    }
    if (draw) {
        l1.setText("Draw!"); }
    }
    public void checkXwin(int a, int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setFocusable(false);
        }
        l1.setText("X Won!");
    }
    public void checkOwin(int a , int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setFocusable(false);
        }
        l1.setText("O Won!");
    }
    public void resetGame() {
         for (int i = 0; i < 9; i++){
         buttons[i].setText("");
         buttons[i].setBackground(new Color(173, 216, 230));// Reset background color
         buttons[i].setFocusable(true);
         }
         l1.setText("TicTacToe");
         firstTurn();
        }

}
