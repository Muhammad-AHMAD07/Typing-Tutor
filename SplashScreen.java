package ProjectMain;
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    public  void Screen(){
        
        JPanel content=(JPanel)getContentPane();
        Color c=new Color(0,0,0,0);
        content.setBackground(c);
        int width=738;
        int height=539;
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        int x=(screen.width-width)/2;
        int y=(screen.height-height)/2;
        setBounds(x,y,width,height);
        JLabel label=new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\java\\image.gif"));
        content.add(label,BorderLayout.CENTER);
       
        
        JProgressBar bar=new JProgressBar(0,100); 
        Color a=new Color(0,255,255);
        bar.setForeground(a);
         content.add(bar,BorderLayout.SOUTH);
        setVisible(true);
       try{
           for(int i=0 ;i<100;i++){
           Thread.sleep(60);
          bar.setValue(i); 
        }}catch (Exception e){
            e.printStackTrace();
        }
       dispose();
        setVisible(false);
    }
   
}
