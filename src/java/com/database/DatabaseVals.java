/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.database;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aryaman
 */
public class DatabaseVals {
    Connection con;
 PreparedStatement pstmt;

public boolean isQuestion(String user, String Q)
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
 Statement stmt=con.createStatement();
 ResultSet rs;
     
 rs=stmt.executeQuery("Select "+Q+" from questions where uname='"+user+"'");
     if(rs.next())
     return rs.getString(Q).equalsIgnoreCase("yes");
             else
         return false;
 
 }
 
 catch(Exception e)
 {
     System.out.println("There was an error in SQL statement part of isQuestion, DatabaseVals");
     
 }
return true;
}

public void QuestionDone(String user, String Q, int marks)
{
    
    if(isQuestion(user, Q))
    {return;
    
    }
    
    try
 {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
 }
 catch(Exception e)
 {
     System.out.println("There was an error in opening connection, QuestionDone, DatabaseVals");
 }
    
    
    try
    {
        Statement stmt=con.createStatement();
 ResultSet rs=stmt.executeQuery("select * from SCORES where uname='"+user+"'");
 if(rs.next())
 {
     int m=rs.getInt("total");
     m+=marks;
     pstmt=con.prepareStatement("update SCORES set total=? where uname=?");
     pstmt.setInt(1, m);
     pstmt.setString(2, user);
     pstmt.executeUpdate();
     pstmt=con.prepareStatement("update questions set "+Q+"='yes' where uname=?");
     
     pstmt.setString(1, user);
     pstmt.executeUpdate();
 }
 else
 {
     pstmt=con.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
     pstmt.setString(1, user);
     if(Q.equalsIgnoreCase("Q1"))
         pstmt.setString(2, "yes");
     else
        pstmt.setString(2, "no");
     
     if(Q.equalsIgnoreCase("Q2"))
         pstmt.setString(3, "yes");
     else
         pstmt.setString(3, "no");
     if(Q.equalsIgnoreCase("Q3"))
         pstmt.setString(4, "yes");
     else
        pstmt.setString(4, "no");
     
     if(Q.equalsIgnoreCase("Q4"))
         pstmt.setString(5, "yes");
     else
        pstmt.setString(5, "no");
     
     if(Q.equalsIgnoreCase("Q5"))
         pstmt.setString(6, "yes");
     else
         pstmt.setString(6, "no");
     if(Q.equalsIgnoreCase("Q6"))
         pstmt.setString(7, "yes");
     else
         pstmt.setString(7, "no");
     if(Q.equalsIgnoreCase("Q7"))
         pstmt.setString(8, "yes");
     else
         pstmt.setString(8, "no");
     if(Q.equalsIgnoreCase("Q8"))
         pstmt.setString(9, "yes");
     else
         pstmt.setString(9, "no");
     if(Q.equalsIgnoreCase("Q9"))
         pstmt.setString(10, "yes");
     else
         pstmt.setString(10, "no");
     if(Q.equalsIgnoreCase("Q10"))
         pstmt.setString(11, "yes");
     else
         pstmt.setString(11, "no");
     if(Q.equalsIgnoreCase("Q11"))
         pstmt.setString(12, "yes");
     else
         pstmt.setString(12, "no");
     if(Q.equalsIgnoreCase("Q12"))
         pstmt.setString(13, "yes");
     else
         pstmt.setString(13, "no");
     if(Q.equalsIgnoreCase("Q13"))
         pstmt.setString(14, "yes");
     else
         pstmt.setString(14, "no");
     if(Q.equalsIgnoreCase("Q14"))
         pstmt.setString(15, "yes");
     else
         pstmt.setString(15, "no");
     if(Q.equalsIgnoreCase("Q15"))
         pstmt.setString(16, "yes");
     else
         pstmt.setString(16, "no");
     
     pstmt.executeUpdate();
     
     pstmt=con.prepareStatement("Insert into scores values(?,?)");
     pstmt.setString(1, user);
     pstmt.setInt(2, marks);
     
     pstmt.executeUpdate();
 }
    }
    catch(SQLException e)
    {
        System.out.println("There was an error in SQL statement part of QuestonDone, DatabaseVals");
    }
    
}

public int retscore(String user)
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
 Statement stmt=con.createStatement();
     System.out.println("1");
 ResultSet rs;
     System.out.println("2");
     
 rs=stmt.executeQuery("Select total from scores where uname='"+user+"'");
     System.out.println("3");
     rs.next();
     System.out.println("4");
 int scores=rs.getInt("Total");
     System.out.println("4");
     return scores;
    
}
 
 catch(Exception e)
 {
     System.out.println("There was an error in SQL Statements of retscores, DatabaseVals");
     return 0;
 }
        
}

public String retQuestion(String user,int num)
{
    int i=(int)user.charAt(3)%3;
    i+=num;
    String question;
    
    try
 {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
 }
 catch(Exception e)
 {
     
     System.out.println("There was an error in opening connection, retQuestion, DatabaseVals");
     return "Question text here";
     
 }
    
    
    try
    {
        Statement stmt=con.createStatement();
 ResultSet rs=stmt.executeQuery("select * from textquestions where qnum="+i);
 rs.next();
 question =rs.getString("question");
 return question;
}
    
    catch(Exception e)
    {
      System.out.println("There was an error in SQL statements, retQuestion, DatabaseVals");  
    return "Question text here";
    }

}

public int retImage(String user, int num)
{
    int a=num/4;
    int i=(int)user.charAt(2)%2;
    i+=a;
    
    try{  
 Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
      
PreparedStatement ps=con.prepareStatement("select * from imgquestions where qnum="+i);  
ResultSet rs=ps.executeQuery();  
if(rs.next()){//now on 1st row  
              
Blob b=rs.getBlob(2);//2 means 2nd column data  
byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
              
FileOutputStream fout=new FileOutputStream("C:\\Users\\Aryaman\\Documents\\NetBeansProjects\\TechTrix\\web\\img\\p"+i+".jpg");  
fout.write(barr);  
              
fout.close();  
}//end of if  

              
con.close();  

}catch (Exception e) {e.printStackTrace();  }
return i;
}

}