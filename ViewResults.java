package ProjectMain;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;


public class ViewResults extends JFrame{
 
 String level[]={"VERY EASY",
 "EASY",
 "MEDIUM",
  "HARD",
 "VERY HARD"}; 
     
    JLabel ab,name; 
 
   public  ViewResults(){
 
 super("VIEW RESULTS");
 
 
 
this.setLayout(null); 
 
 ab=new JLabel(LoginScreen.name);
 ab.setBounds(200,20,100,40);
 ab.setFont(new Font("Arial", Font.BOLD, 18));
 this.add(ab);
 
 ab=new JLabel("LEVELS");
 ab.setBounds(20,90,100,40);
  ab.setFont(new Font("Arial", Font.BOLD, 15));
 this.add(ab);
 
 ab=new JLabel("ACCURACY");
 ab.setBounds(200,90,100,40);
  ab.setFont(new Font("Arial", Font.BOLD, 15));
 this.add(ab);
 
 ab=new JLabel("ERRORS");
 ab.setBounds(320,90,100,40);
  ab.setFont(new Font("Arial", Font.BOLD, 15));
 this.add(ab);
  
 ab=new JLabel("WORDS PER MINUTE");
 ab.setBounds(430,90,200,40);
  ab.setFont(new Font("Arial", Font.BOLD, 15));
 this.add(ab);
 
 //labels code
 int c=130;
 for(int i=0;i<5;i++){
 
 ab=new JLabel(level[i]);
 
 ab.setBounds(20,c ,100 ,40);
 this.add(ab);
 c=c+50;
 
 }
 
  database();
 
	 this.setSize(700,500);
	 this.setResizable(false);
	 this.setVisible(true);
	 this.setLocation(350,120);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
    } 

 
public void database(){
 try {
	 Class.forName("com.mysql.jdbc.Driver");

     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing","root","@hm@db@sil");

      Statement statmnt = con.createStatement();
     
		String sql="select * from users where username='"+LoginScreen.name+"'"; //LoginScreen.name
		Statement stm=con.createStatement();
		ResultSet st=stm.executeQuery(sql);
		int a=80;
		while(st.next()){
		
		for(int i=2;i<=16;i++){
		a+=50;
		    ab=new JLabel(st.getString(i));
		    ab.setBounds(230,a,100,40);
		this.add(ab);
		    i=i+1;
		    
		ab=new JLabel(st.getString(i));
		    ab.setBounds(470,a,160,40);
		this.add(ab);
		
		i=i+1;
		ab=new JLabel(st.getString(i));
		    ab.setBounds(340,a,160,40);
		this.add(ab);
		
		}
		    
		}
		 
		
		con.close();
     }catch(Exception ex){
    	 System.err.println(ex);
      }
   }
}
