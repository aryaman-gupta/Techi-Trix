package com.database;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import com.Bean.User;
import java.sql.SQLException;

public class SignUpDAO {
    static Connection con;
public static Boolean enterDetails(User u)throws SQLException
{
    
 PreparedStatement pstmt;
boolean flag=false;
 try
 {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    
    
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
    
 }
 catch(Exception e)
 {
     System.out.println("Error opening connection, SignUpDAO");
 }
 try
 {
     
    
   Encrypt e;
        e = new Encrypt();
    
    String encPass=e.MD5(u.getPword());
   if(encPass.equals(""))
   {System.out.println("Sorry, Could not encrypt password");
   return false;
   }

    pstmt = con.prepareStatement("insert into accounts values(?,?,?,?,?)");
 pstmt.setString(1, u.getName1());
 pstmt.setString(2, u.getName2());
 pstmt.setString(3, u.getUname());
 
 
 
 pstmt.setString(4, encPass);
 
 pstmt.setString(5, u.getPhone());
 
 pstmt.executeUpdate();

flag=true;
 
 }
 catch(Exception e)
 {
     System.out.println("Error");
 }
return flag;

}
}
