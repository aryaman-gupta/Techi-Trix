<%-- 
    Document   : QuestionList
    Created on : 1 Sep, 2014, 7:30:25 PM
    Author     : Aryaman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
            String uname=null;
            uname=(String)session.getAttribute("uname");
            if(uname==null)
            response.sendRedirect("Login.jsp");
            
            String x="Q2.jsp";
            
            %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello World!</h1>
        <%=uname%>
        <br>
        <a href=<%=x%>>
          Question 1 
        </a>
        <br>
        <a href=<%=x%>>
           Question 2 
        </a>
        <br>
        <a href="Q3.jsp">
           Question 3 
        </a>
    </body>
</html>
