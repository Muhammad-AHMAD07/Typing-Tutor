package ProjectMain;
import java.awt.Color;
import java.sql.*;  

import javax.swing.*;
import java.awt.event.*;

public class LoginScreen extends JFrame implements MouseListener{
  
    String Username,Password;
  public static  int loc=-1;
  public static String name="AHMAD";
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton bnewuser,blogin,bsubmit,bback;
  JLabel username,invalid;///////////////////////invalid
  JLabel password;
  String text="";
          
  public LoginScreen(){
    super("Login Autentification");

    blogin = new JButton("LOGIN");
    loginpanel = new JPanel();
    txuser = new JTextField(text,15);
    pass = new JPasswordField(text,15);
    bnewuser = new JButton("NEW USER?");
    username = new JLabel("USERNAME ");
    password = new JLabel("PASSWORD ");
    invalid=new JLabel("INVALID USER NAME OR PASSWORD ");
bsubmit=new JButton("Submit");
bback=new JButton("<");
   
   
    loginpanel.setLayout(null); 

      ////////////////align
    
    txuser.setBounds(180,70,170,25);
    pass.setBounds(180,105,170,25);
    blogin.setBounds(80,180,110,20);
    bnewuser.setBounds(180,180,110,20);
    username.setBounds(50,72,90,25);
    password.setBounds(50,105,90,25);
    bsubmit.setBounds(110,170,110,20);
    bback.setBounds(10,5,45,20);
    invalid.setBounds(80,150,240,25);
    invalid.setForeground(Color.RED);
    invalid.setVisible(false);
//
  blogin.addMouseListener(this);
  bnewuser.addMouseListener(this);
bback.addMouseListener(this);
bsubmit.addMouseListener(this);
/////////add  

    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(bnewuser);
    loginpanel.add(username);
    loginpanel.add(password);
    loginpanel.add(bsubmit);
    loginpanel.add(bback);
    loginpanel.add(invalid);
    bsubmit.setVisible(false);
    bback.setVisible(false);
    this.add(loginpanel);
  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500,400);
  
    this.setResizable(false);
   
    this.setLocation(400,200);
    this.setFocusable(true);
    
   this.setFocusableWindowState(true);
    setVisible(true);}

public void insert(){
try {

	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing","root","@hm@db@sil");
	Statement stm=con.createStatement();
	String sql="insert into tbl_users(Name,password) values (?,?)";
	PreparedStatement pst=con.prepareStatement(sql);
	
	pst.setString(1,txuser.getText());
	pst.setString(2,pass.getText());
	
	pst.executeUpdate();  
	

    if(pst.execute()==true){
    	

  
    }
	con.close();
	}catch(Exception ex){
	System.err.println(ex);
	}
	JOptionPane.showMessageDialog(this, "User successfully Registered!");
	

}
public void checkUser(){
  
  
      try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing","root","@hm@db@sil");

             Statement statmnt = con.createStatement();
            String sql = "SELECT * FROM tbl_users ";
           
            ResultSet rs = statmnt.executeQuery(sql);
          
            
            while(rs.next())
            {
       
         if(rs.getString(1).equals(Username)&&rs.getString(2).equals(Password)){
         
         loc++;
         name=Username;
        

		this.dispose();
		if(loc>=0){
		        new ProjectMain();
              }
         }
    
      }
            if(loc==-1){
            invalid.setVisible(true);
          
            }
        
        con.close();    
        }
        catch (Exception e) 
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

           }
        
  
  }    

    @Override
    public void mouseClicked(MouseEvent e) {
  if(e.getSource()==blogin){ 
     
     
       if(pass.getText().equals("") || txuser.getText().equals("")){
           
           JOptionPane.showMessageDialog(this,"Please type user name or password in fields");  
       }
       else{
    	   Username=txuser.getText();
    	   Password=pass.getText();
    	   checkUser(); 
               }
  
  }
    
else if(e.getSource()== bnewuser){
		
		txuser.setText("");
		pass.setText("");
		invalid.setVisible(false);
		blogin.setVisible(false);
		bnewuser.setVisible(false);
		bback.setVisible(true);
		bsubmit.setVisible(true);
}
else if(e.getSource()==bback){	
		
		txuser.setText("");
		pass.setText("");
		blogin.setVisible(true);
		bnewuser.setVisible(true);
		bback.setVisible(false);
		bsubmit.setVisible(false);

}
else if(e.getSource()==bsubmit){
		
		if(pass.getText().equals("") || txuser.getText().equals("")){
		           
		           JOptionPane.showMessageDialog(this,"Please type user name or password in fields");  
		         }
		else{
			insert();
			
		    }
		}
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    
    }
    
    
  }
