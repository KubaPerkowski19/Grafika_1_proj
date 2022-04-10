import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Menu {

    private JComponent getStartupPanel()
    {
        JPanel startup = new JPanel();
        startup.setVerifyInputWhenFocusTarget(false);
        startup.setLayout(new GridLayout(2,2,50,5));
        JButton Drawing = new JButton("Drawing");
        JButton Game = new JButton("Game");
        JButton Bezie = new JButton("Bezie");
        JButton xxx = new JButton("xxx");
        startup.add(Drawing);
        startup.add(Game);
        startup.add(Bezie);
        startup.add(xxx);


        return startup;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Object[] options = {"Drawing", "Game", "Bezie","Czajnik_cords"};
                Menu sp = new Menu();
                 int n = JOptionPane.showOptionDialog(sp.getStartupPanel(), "", "What to run",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                 switch (n){
                     case 0:
                         EventQueue.invokeLater(new Runnable() {

                             @Override
                             public void run() {
                                 First ex = new First();
                                 ex.setVisible(true);
                             }
                         });
                         break;
                     case 1:
                         EventQueue.invokeLater(new Runnable() {

                             @Override
                             public void run() {
                                 JFrame obj=new JFrame();
                                 GamePlay gamePlay = new GamePlay();

                                 obj.setBounds(10, 10, 700, 600);
                                 obj.setTitle("Breakout Ball");
                                 obj.setResizable(false);
                                 obj.setVisible(true);
                                 obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 obj.add(gamePlay);
                                 obj.setVisible(true);
                             }
                         });
                         break;

                     case 2:
                         EventQueue.invokeLater(new Runnable() {

                             @Override
                             public void run() {
                                 Bezier bz = new Bezier();
                             }
                         });
                         break;

                     case 3:
                         EventQueue.invokeLater(new Runnable() {

                             @Override
                             public void run() {
                                 Bezier_utahTP czajnik = new Bezier_utahTP("czejnik.txt","czajnik-info.txt");
                                 try {
                                     czajnik.Coordinates();
                                 } catch (IOException e) {
                                     e.printStackTrace();
                                 }
                             }
                         });
                         break;



                 }
            }
        });
    }
}