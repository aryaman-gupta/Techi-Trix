<%-- 
    Document   : Rules
    Created on : 6 Sep, 2014, 2:49:25 AM
    Author     : Aryaman
--%>

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
        <title>Rules </title>
        <link rel="stylesheet" href="css/rules.css">
    </head>
    <body>
            
    <div id="headimg">
        <img src="img/header.jpg" alt="Header" width="1366">
        
    </div>
    
    <div class="login">
    
      <div id="Question">
          
          
          <div id="rules">
          RULES OF THE GAME
          </div>
          <hr>
          1.&nbsp;&nbsp;&nbsp;This round consists of 15 Multiple Choice Questions.
          <br>
          <br>
          2.&nbsp;&nbsp;&nbsp;Time Limit:15 Minutes
          <br>
          <br>
          3.&nbsp;&nbsp;&nbsp;For each question, only one option is correct.
          <br>
          <br>
          4.&nbsp;&nbsp;&nbsp;Once you submit a question, you will not be allowed to view it again.
          <br>
          <br>
          5.&nbsp;&nbsp;&nbsp;We have no problem with cheating, unless you get caught at it.
          <br>
          <br>
          
      </div>
    
      
      
   
        
    <form action="Rules">
        <p class="login-submit">
      
        <button type="submit" class="login-button">Login</button>
      
    </p>
    </form>
  </div>
    </body>
</html>
