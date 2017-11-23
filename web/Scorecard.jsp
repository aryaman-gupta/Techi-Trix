<%-- 
    Document   : Rules
    Created on : 6 Sep, 2014, 2:49:25 AM
    Author     : Aryaman
--%>

<%@page import="com.sun.tools.ws.wsdl.document.soap.SOAP12Binding"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.database.DatabaseVals"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String uname=null;
            
            uname=(String)session.getAttribute("uname");
            if(uname==null)
            response.sendRedirect("index.html");
            
            %>
           
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scorecard </title>
        <link rel="stylesheet" href="css/leaderboard.css">
    </head>
    <body>
            
    <div id="headimg">
        <img src="img/header.jpg" alt="Header" width="1366">
        
    </div>
        
        <%
            
            DatabaseVals db;
            db=new DatabaseVals();
            int score=db.retscore(uname);
            
            
            %>

            
    
    <div class="login">
    
      <div id="Question">
          
          
          <div id="rules">
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; LEADERBOARD
          </div>
          
          
          
          Your score is: <%=score%>
          <hr>
          
          
          <div id="board">
          
          <table style="width: 80%">
              
          
          <%
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
          try
 {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@jarvis:1521:orcl", "hr", "aryaman1994");
 }
 catch(Exception e)
 {
     System.out.println("There was an error in opening connection, Scorecard.jsp");
 }
 try
 {
     
 Statement stmt=con.createStatement();
 
 ResultSet rs=stmt.executeQuery("select a.fname, s.total from accounts a, scores s where s.uname=a.uname and 11>= (select count(*) from scores s2 where s2.total>s.total) order by s.total desc");
 System.out.println("1");
 String name;
 int totals;
 int cnt=0;
 while(rs.next())
 {
 
     cnt++;
     name=rs.getString("fname");
     totals=rs.getInt("total");
 
     %>
     <tr>
         
         <td>
             <%=cnt%>
         </td>
         
     <td>
         <%= name %>
     </td>
     <td>
          <%= totals%>
     </td>
     </tr>
     
     
     
     <%
     
 }
 }
 catch(Exception e)
 {
     System.out.println("Error printing leaderboard.");
 }
 
          
          %>
          
          </table>
          
          </div>
          
          
          
      </div>
    
          <a href="/TechieTrix">
              Logout
              <%
 session.invalidate();
              %>
          </a>
      
   

    
  </div>
    </body>
</html>
