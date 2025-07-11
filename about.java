package ProjectMain;

import javax.swing.*;
import java.awt.*;


public class about extends JFrame {
    public about(){
        super("About");
        JLabel l1=new JLabel("About Typing Tutor");
        l1.setBounds(100,5,300,200);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        this.add(l1);
        
        JLabel l2=new JLabel("<html>Typing Tutor is developed on Java " +
                               "<br/>which provide features to calculate <br/>  speed, accuracy  and errors" +
                                " <br/> this software is helpfull for beginers to achive a better computer writing" +
                                " Developed by Muhammad Ahmad and Ahmad Basil</html>");
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