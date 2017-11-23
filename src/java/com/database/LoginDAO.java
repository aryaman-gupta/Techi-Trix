/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.database;

import com.Bean.LoginBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aryaman
 */
public class LoginDAO {
    static Connection con;
    public static String validate(LoginBean lb)
    {
         
 PreparedStatement pstmt;
String name=new String("");

 try
 {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
 }
 catch(Exception e)
 {System.out.println("Error opening connection, LoginDAO");
 }
 
    try
    {
   Encrypt e;
        e = new Encrypt();
        String encPass=new String(e.MD5(lb.getPword()));
        
        pstmt=con.prepareStatement("select * from accounts where uname=? and pword=?");
        pstmt.setString(1, lb.getUname());
        pstmt.setString(2, encPass);
        ResultSet rs=pstmt.executeQuery();
        
        if(rs.next())
            name=rs.getString("uname");
 }
 catch(Exception e)
 {
     System.out.println("Error in SQL statements of LoginDAO");
 }
 
 return name;
    }
    
}
