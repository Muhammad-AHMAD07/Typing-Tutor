package ProjectMain;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filing {
    public Filing(){
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();
     String le[]={"VERY EASY",
 "EASY     ",
 "MEDIUM   ",
  "HARD     ",
 "VERY HARD",};
      try{
    File fn=new File("C:\\Users\\HP\\Documents"+LoginScreen.name+".txt");
    
    if(fn.exists()){
    
    System.out.println(fn.getParentFile()+"     file exist");    }
    else{
    fn.createNewFile();
    }
      
      
      
      
      FileWriter ff= new FileWriter(fn);
      BufferedWriter bw=new BufferedWriter(ff);
      
      Class.forName("com.mysql.jdbc.Driver");

      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/typing","root","@hm@db@si");
     
      Statement statmnt = con.createStatement();
      String sql = "SELECT * FROM tbl_users where Name='"+ LoginScreen.name+"'";
            
            
         ResultSet rs = statmnt.executeQuery(sql);
               
     
          
          bw.write("                                  USER NAME :"+LoginScreen.name+"                   " +formatter.format(date));
          bw.newLine();
          bw.newLine();
          bw.newLine();
          bw.write("Levels                      Accuracy           WordsPerMinute(wpm)              Errors  "); 
         bw.newLine();

         bw.newLine();
         while(rs.next())
            {
                int a=0;
      for(int i=2;i<=16;i++,a++){
    
          bw.write(le[a]);
		    bw.write("                   ");
		    bw.write(rs.getString(i));
		    bw.write("                     ");
		        i++;
		    bw.write(rs.getString(i));
		    bw.write("                    ");
		        i++;
		    bw.write(rs.getString(i));
		    bw.newLine();
		    }
            }      
      bw.close();
      }catch(Exception ex){
      System.err.print(ex);
      
      }
    
    
    }
    
    
}

