package ProjectMain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;

class ProjectMain extends JFrame implements KeyListener, MouseListener,ActionListener {
    JLabel rightlabel,wronglabel,space;
     boolean t=true;    //in  keyPressed function
    JPanel pane;
	JMenu gap, menu,file,mlevels,viewresults,help,aboutus;  // ?
	JMenuBar bar;
	JMenuItem l1,l2,l3,l4,l5,l6,easy,veasy,medium,hard,vhard,save,l,exit; 
	//-----------------------------------------------
	//for timer
	private long tafter,tbefore;
	private int totalwords=0;
	private int totalerrors=0;
	private double Gwpm,Nwpm,accur;
	private JLabel wpm,ac,error;
	//---------------------------
	private String lev[]={"Veasywpm","Veasyaccu","Verrors","Easywpm","Easyaccu","Eerrors","Mediumwpm",
	    "Mediumaccu","Merrors","Hardwpm","Hardaccu","Herrors","Vhardwpm","Vhardaccu","Vherrors"};
	private String strg1[]={"aa bb cc dd ee ff gg hh ii jj kk ll mm nn oo pp qq rr ss tt uu vv xx yy zz ",
	    "Curiously enough, the only thing that went through the mind of the bowl of petunias as it fell was Oh no, not again. Many people have speculated that if we knew exactly why the bowl of petunias had thought that we would know a lot more about the nature of the Universe than we do now.",
	    "In some countries, younger people are neglecting their right to vote.What problems does this cause and what are some of the possible solutions? ??//.::",
	    "/// ;;; The Scholar Link Opportunity Project is not just a software solution but a vision to empower students with valuable opportunities. By bridging the gap between information providers and seekers, this project demonstrates how technology can be a tool for positive change. /// ;",
	        "qwert?/// Some people believe that children should be taught by their parents about how to function as useful members of society, while others believe that sending children to educational institutions is the best way for them to study this. Although the latter opinion can be beneficial in some cases. ::/"
	
	};

    public  String  str[] ={"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "a", "s", "d", "f", "g",
                      "h", "j","k", "l", ";", "'", "z", "x", "c", "v", "b", "n", "m",",",".","/"};
	private int level=0;
	int tw=0;
	private JButton btnspace, button[]=new JButton[str.length];
	
	private String bc; 
	private JPanel pan;
	private Color color;
	private int a=0;
	private JTextArea textarea1,textarea2;
	private int counter=0;
	ProjectMain(){
	super("TYPING TUTOR");      
	this.setLayout(new BorderLayout());
	pan=new JPanel();
	pan.setLayout(new FlowLayout());

//printing keyboard
for(int i=0;i<str.length ;i++ ){
	button[i]=new JButton(str[i]);
	button[i].setPreferredSize(new Dimension(75,50));
	pan.add(button[i]);
	
	    if(str[i]=="]"||str[i]=="'"){
	        pan.add(new JLabel("              "));
	      }
}
//adding space button

 btnspace =new JButton(" ");
 btnspace.setPreferredSize(new Dimension(400,50));
 pan.add(btnspace);
 pan.setPreferredSize(new Dimension(800,230));
 this.add(pan,BorderLayout.SOUTH);
 pane =new JPanel();
 bar=new JMenuBar();
 pane.setLayout(new FlowLayout(FlowLayout.LEFT));
 file =new JMenu("File");
 save=new JMenuItem("Save File");
 l=new JMenuItem("-");
 exit=new JMenuItem("Exit");
 file.add(save);file.add(l);file.add(exit);

 bar.add(file);
 pane.add(bar);
this.addingSpaceBetweenMenu();
 mlevels =new JMenu("Levels");
 veasy=new JMenuItem("Very Easy");
 easy=new JMenuItem("Easy");
 medium=new JMenuItem("Medium");
 hard=new JMenuItem("Hard");
 vhard=new JMenuItem("Very Hard");
 
 mlevels.add(veasy);mlevels.add(easy);mlevels.add(medium);mlevels.add(hard);mlevels.add(vhard);
 bar.add(mlevels);
 pane.add(bar);
 this.addingSpaceBetweenMenu();
 viewresults =new JMenu("View Results");
 bar.add(viewresults);
 pane.add(bar);
this.addingSpaceBetweenMenu();
 aboutus =new JMenu("About us");
 bar.add(aboutus);
 pane.add(bar);

///space
this.addingSpaceBetweenMenu();

   help =new JMenu("Help");
 bar.add(help);
 pane.add(bar);

////
 gap=new JMenu("                                                                                                                                                                                                                          ");
 gap.setEnabled(false);
 bar.add(gap);
 pane.add(bar);
////
 
 
 
       //////////adding mouse listeners
 file.addMouseListener(this);
  aboutus.addMouseListener(this);
 help.addMouseListener(this);
viewresults.addMouseListener(this);
mlevels.addMouseListener(this);




///add action listener 
save.addActionListener(this);
 exit.addActionListener(this);
 easy.addActionListener(this);
 veasy.addActionListener(this);
  medium.addActionListener(this);
 hard.addActionListener(this);
 vhard.addActionListener(this);
 viewresults.addActionListener(this);
 aboutus.addActionListener(this);
 help.addActionListener(this);
 
this.add(pane,BorderLayout.NORTH);


color=button[0].getBackground(); //getting color of button 

//1st text area code
pan=new JPanel();

wronglabel=new JLabel("WRONG BUTTON");
rightlabel=new JLabel(" RIGHT BUTTON");

rightlabel.setFont(new Font("Serif", Font.PLAIN, 20));
rightlabel.setForeground(Color.green);
rightlabel.setVisible(false);
pan.add(rightlabel);

wronglabel.setFont(new Font("Serif", Font.PLAIN, 20));
wronglabel.setForeground(Color.red);
wronglabel.setVisible(false);
pan.add(wronglabel); 

space=new JLabel("                                                ");
pan.add( space);
error=new JLabel("Errors: 0 ");
ac=new JLabel("Accuracy : 00.00%");
 wpm=new JLabel("Wmp : 00.00");
pan.add(new JLabel("                                        ")); 
pan.add(ac);
pan.add(new JLabel("                 "));
pan.add(error); 
pan.add(new JLabel("                 "));
pan.add(wpm);

////////////////1st text area
 textarea1=new JTextArea(strg1[level]);
textarea1.setPreferredSize(new Dimension(550,150));
textarea1.setEditable(false);
textarea1.setFont(new Font("serif",Font.BOLD,20));
textarea1.setBackground(Color.BLUE);
textarea1.setForeground(Color.white);
textarea1.setBorder(BorderFactory.createLineBorder(Color.RED));
textarea1.setLineWrap(true);
textarea1.setWrapStyleWord(true);
textarea1.setVisible(true);
pan.add(textarea1);

/////////////////////////////////////////2nd text area

bc="type text here.....";
textarea2=new JTextArea(bc);
textarea2.setPreferredSize(new Dimension(550,150));
textarea2.setFont(new Font("serif",Font.BOLD,20));
textarea2.addKeyListener(this);

textarea2.setLineWrap(true);
textarea2.setWrapStyleWord(true);
textarea2.setVisible(true);
textarea2.setBorder(BorderFactory.createLineBorder(Color.RED));
pan.add(textarea2);
pan.setLayout(new FlowLayout());
this.add(pan,BorderLayout.CENTER);
this.setSize(1000,650);
this.setResizable(false);
this.setVisible(true);
this.setLocation(160,40);
 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
	void addingSpaceBetweenMenu(){
	    
		gap=new JMenu(" ");
		gap.setEnabled(false);
		bar.add(gap);
		pane.add(bar);
}
    @Override
    public void keyTyped(KeyEvent e) {
  
        totalwords++;

        if(e.getKeyChar()==strg1[level].charAt(counter)){
            int qq=strg1[4].length();
           if(level==4&&qq==counter+tw){
               }
           else{ 
                if(e.getKeyChar()==' '){
                    btnspace.setBackground(Color.green);
                  }
              else{
    	      for(int c=0;c<str.length;c++){
    		        if(str[c].charAt(0)==e.getKeyChar())
    		          {
    			          button[c].setBackground(Color.GREEN);
    		 	       }
    		   }
     	   }
         bc=bc+e.getKeyChar();
         textarea2.setText(bc);
         if(level==4&&qq==counter+1){
    	 tw=1;
    	 saverecord();
         reset();
         }else{
    	 counter++;}
    rightlabel.setVisible(true);
    wronglabel.setVisible(false);
    }
    }
    else if(e.getKeyChar()!=strg1[level].charAt(counter))
    {
    try{
    	totalerrors++;

           if(e.getKeyChar()==' '){
                  btnspace.setBackground(Color.red);
                  }
          else{
                   for(int c=0;c<str.length;c++){
                	   if(str[c].charAt(0)==e.getKeyChar())
                          {
                		   		button[c].setBackground(Color.red);
                          }
                	   }

               }
           int qq=strg1[4].length();
 

		 if(level==4&&qq==counter+1)
		 {
		 
		 }
		 else{
		      textarea2.setText(bc);
		      rightlabel.setVisible(false);
		      wronglabel.setVisible(true);
		     }

        }catch(Exception ex){ System.err.print(ex);   } }
        
        ///////////////////////for next levels
        if(strg1[level].length()==bc.length()){
             saverecord();
            if(level<4){
            level++;
             reset();
              textarea1.setText(strg1[level]);
            }

        
       }
        accuracy();
    
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
    if(t==true){
        t=false;
        bc="";
        tbefore=System.currentTimeMillis();
        space.setVisible(false);
       }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        textarea2.setText(bc);   
        a=0;
        for(;a<button.length;a++){
        	button[a].setBackground(color);
        }
        btnspace.setBackground(color);
    }
    
 @Override
    public void mouseClicked(MouseEvent e) {
    if(e.getSource()==aboutus){
       new about();       
   }
   else if(e.getSource()==help)
         {
	          
	          new help();
	      }
  else if(e.getSource()==viewresults)
        {
	        new ViewResults();
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
            JMenu men=(JMenu) e.getSource(); 
    men.setSelected(true);
   
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       JMenu men=(JMenu) e.getSource();
       men.setSelected(false);
    }
   
    

////////ACCURACY FUNCTION    1000milisec =  1sec
    public void accuracy(){
    
     tafter=System.currentTimeMillis();
    double total=tafter-tbefore;
    
    double aa=total/60000;
    
    
     Gwpm= (totalwords/aa);
     Nwpm= ((totalwords-totalerrors)/aa);
    if(Gwpm!=0 ){
    	accur=((Nwpm/Gwpm)*100);
    }
    else{accur=0;}
    	DecimalFormat ff=new DecimalFormat("#00.00");
    	ac.setText("Accuracy : "+ff.format(accur)+"%");
    	error.setText("Errors: "+totalerrors);
    	wpm.setText("WPM : "+ff.format(Gwpm));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    ///////////////////////////////////////Item in menu if pressed///// 
    if(e.getSource()==save){  
    	new Filing();
    	JOptionPane.showMessageDialog(null, "RECORDS ARE SAVED SUCCESSFULLY");
       }
    
    else if(e.getSource()==exit){
           System.exit(0);
    }
  
    else if(e.getSource()==veasy ){
    	level=0;
    	reset();  
    	textarea1.setText(strg1[level]);
	  }
      else if(e.getSource()==easy){
		  level=1;
		  reset();
		  textarea1.setText(strg1[level]);
	  }
  else if(e.getSource()==medium){
		  level=2;
		  reset();
		  textarea1.setText(strg1[level]);
      }
  else if(e.getSource()==hard){
		  level=3;
	      reset();
		  textarea1.setText(strg1[level]);
  }
  else if(e.getSource()==vhard){
		   level=4;
		   reset();
		   textarea1.setText(strg1[level]);
    }
    
    
    
 }

    
    
    
   ////////////////////////////////////DATA BASE TO SAVE REECORD//////////////////////////////// 
    
    
   public void saverecord(){
       try {
           int a=0;
           
           switch(level){
           
               case 0:
                 a=0;  
                   break;
               case 1:
                   a=3;
                   break;
                    case 2:
                        a=6;
                   break;
                    case 3:
                        a=9;
                   break;
                    case 4:
                        a=12;
                   break;
           
           
           }
         
Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
String url="jdbc:ucanaccess://C:/Users/Zulfiar Hashmi/Downloads/MPL project/newfile.accdb";
Connection con =DriverManager.getConnection(url);


String query="Update ProjectMain set "+lev[a]+" = ?, "+lev[a+1]+"= ?,"+lev[a+2]+"=?  where Name = ? ";
PreparedStatement pst=con.prepareStatement(query);

    
  double roundOff = Math.round(Gwpm * 100.0) / 100.0;
   pst.setString(1, Double.toString(roundOff));
   roundOff = Math.round(accur * 100.0) / 100.0;
   pst.setString(2, Double.toString(roundOff));
   roundOff = Math.round(totalerrors * 100.0) / 100.0;
	pst.setString(3, Double.toString(roundOff));
	pst.setString(4, LoginScreen.name);
	pst.executeUpdate();
    con.close();
    }catch(Exception ex){
       System.err.println(ex);
    }
   
   }
    public void reset(){
    	t=true;
    	counter=0;
    	bc="type text here.....";
    	textarea2.setText(bc);
    	totalwords=0;
    	totalerrors=0;
    	ac.setText("Accuracy : 00.00%");
    	error.setText("Errors : 0 ");
    	wpm.setText("wmp : 00.00");
    	}
     }

public class TypingTutor {

	
	public static void main(String[] args) {
		 try{	
			 
			  SplashScreen a=new SplashScreen();
			  a.Screen();
			  LoginScreen ab=new LoginScreen();
			  
			  //new ProjectMain(); 
			 // 
			   //nom.saverecord();
			  //  nom.accuracy();
			    }catch(Exception e){
			    System.out.print(e);
			    }
	}

}
