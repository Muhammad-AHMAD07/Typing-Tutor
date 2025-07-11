package ProjectMain;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class help extends JFrame {
    public help(){
        super("Help");
        JLabel l1=new JLabel("Contact us");
        l1.setBounds(100,5,300,200);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        this.add(l1);
        
        JLabel l2=new JLabel("<html>Muhammad Ahmad (23-CP-07) " +
                               "<br/>Ahmad Basil (23-CP-99)" +
                                " </html>");
        l2.setBounds(50,140,400,200);
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(l2);

        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLocation(400,100);
        this.setResizable(false);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
}
