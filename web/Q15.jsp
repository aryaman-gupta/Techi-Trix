<%-- 
    Document   : Q2
    Created on : 2 Sep, 2014, 12:49:47 AM
    Author     : Aryaman
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.database.DatabaseVals" %>
<%
            String uname=null;
            
            uname=(String)session.getAttribute("uname");
            if(uname==null)
            response.sendRedirect("index.html");
            
           
            DatabaseVals dv;
            dv=new DatabaseVals();
            if(dv.isQuestion(uname, "Q15")==true)
            {String ques[]={"Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Q11", "Q12", "Q13", "Q14", "Q15"};                
int i=0;

for(i=0; i<15; i++)
{  
    
   if(!dv.isQuestion(uname, ques[i]))
   {
       break;
   }
}
if(i>=15)
{
%>
                <jsp:include page="Scorecard.jsp"></jsp:include>
                <%
    
}
else
    
{   
    
    String redirect=ques[i].concat(".jsp");
    %>
    
    <jsp:include page="<%=redirect%>"></jsp:include>
                 
    
    <%
}
            }
            
            else
                
{ 

    %>
<%-- 
    Document   : SignUp
    Created on : 4 Sep, 2014, 3:18:02 AM
    Author     : Aryaman
--%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  
  
  <%--  <script type="text/javascript" src="timer.js">

</script> --%>

  
  <title>Question 1</title>
  <link rel="stylesheet" href="css/mcq.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
    <%--
    <form id="time" name="hform" onsubmit="return setDate()" onload="submit">
        <input type="text" value="2014" name="year">
        <input type="submit">
        
    </form>
    
    <div id="countbox1"></div>
    --%>
    
    <div id="headimg">
        <img src="img/header.jpg" alt="Header" width="1366">
        
    </div>
    
    <div id="qNum">
        <img src="img/q15.png" alt="QUESTION 1">
    </div>
    
   <%--
    <div id="vert">
        <img src="img/VerticalLine.png">
    </div>
   --%>
<%
String q=dv.retQuestion(uname, 15);


%>
   
   
    <form method="post" action="QuestionServlet" class="login">
    
      <div id="Question">
          
         
          <%=q
                  %>
          Choose the Correct Option<br>
          <hr>
          <br>
          
          44 <input type="radio" value="A" name="Ans"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="B" name="Ans"> 12<br>
          &nbsp;&nbsp;&nbsp;144<input type="radio" value="C" name="Ans"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="D" name="Ans"> 120<br>
          <input type="hidden" value="A" name="CorAns">
          <br>
          <br>
          <input type="hidden" value="Q15" name="QNum">
          <br>
          <br>
          
      </div>
      
      
   

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>
  </form>
          
          <div id="timeleft">
              <img src="img/TimeLeft.png">
          </div>
          <div id="pick">
              
       <img src="img/JumpToAQuestion.png">
   </div>
         
          
    <div id="list">
        <br>
        <table>
            <tr>
            <% int i;
            
            String ques[]={"Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Q11", "Q12", "Q13", "Q14", "Q15"};
            for(i=0; i<15; i++)
            {
                if(i%5==0)
                {
                    %>
                 
            </tr>
            
            <tr>
             
                <td>
                    
                    <%
                 }
                else
                {
                    
                    %>
                    
                <td>
                            
                 <%           
                            
                }
                
                if(!dv.isQuestion(uname, ques[i]))
                {
                    %>
                    
            
                <% String redirect=ques[i].concat(".jsp"); %>
            <a href=<%=redirect%>>
            
                <%=i+1%>
                
                
            </a>
                &nbsp;
                </td>
                
                <% }
                else
                {
                    %>
                    
                    <%=i+1%>
                &nbsp;
            </td>
                    
                    <%
                }
            }
            %>
                    
                    
                    
        </table>
        </div>


</body>
</html>


<% }
            %>