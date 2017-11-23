/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aryaman
 */
public class trials {
    
    
    static Connection con;
 static PreparedStatement pstmt;

public static void enterQuestion()
{
        
    
 try
 {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
 }
 catch(Exception e)
 {
     System.out.println("There was an error in opening connection, isQuestion, DatabaseVals");
 }
 try
 {
 PreparedStatement pstmt=con.prepareStatement("insert into imgquestions values(?,?)");
 pstmt.setInt(1, 6);
 FileInputStream fin=new FileInputStream("d:\\desktop.jpg");
 pstmt.setBinaryStream(2, fin,fin.available());
int i=pstmt.executeUpdate();
     System.out.println(i);
 }
 catch(Exception e)
 {
     System.out.println("error");
 }
}

public static void getImage()
{try{  
 Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
      
PreparedStatement ps=con.prepareStatement("select * from imgquestions");  
ResultSet rs=ps.executeQuery();  
if(rs.next()){//now on 1st row  
              
Blob b=rs.getBlob(2);//2 means 2nd column data  
byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
              
FileOutputStream fout=new FileOutputStream("C:\\Users\\Aryaman\\Documents\\NetBeansProjects\\TechTrix\\web\\img\\q1.jpg");  
fout.write(barr);  
              
fout.close();  
}//end of if  
System.out.println("ok");  
              
con.close();  
}catch (Exception e) {e.printStackTrace();  }  
}



public static void main(String args[])
{
    getImage();
}
}
