import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class main{
    public static void main(String[] args) {
        tictactoe obj= new tictactoe();
    }
}
public class tictactoe implements ActionListener{
    Random random = new Random();
    JFrame f= new JFrame();
    JPanel tp = new JPanel();
    JPanel bp=new JPanel();
    JLabel l1= new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1 ;
    tictactoe(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,600);
        f.getContentPane().setBackground(new Color(50,50,50));
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        l1.setBackground(new Color(25,25,25));
        l1.setForeground(new Color(25,255,0));
        l1.setFont(new Font("Ink free",Font.PLAIN,70));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setText("TicTacToe");
        l1.setOpaque(true);

        tp.setLayout(new BorderLayout());
        tp.setBounds(0,0,800,100);
        tp.add(l1);
        f.add(tp);

    }
    public void actionPerformed(ActionEvent ae){

    }
    public void firstturn(){

    }
    public void checkwin(){

    }
    public void checkxwin(int a, int b,int c){
        
    }
    public void checkowin(int a , int b,int c){
        
    }
}