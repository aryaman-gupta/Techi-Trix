package com.Servlet;
import com.database.SignUpDAO;


import com.Bean.User;
import java.io.IOException;
import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aryaman
 */
@WebServlet(name = "signUpServlet", urlPatterns = {"/signUpServlet"})
public class signUpServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        
        
        User u;
        u = new User();
        
        u.setName1(request.getParameter("name1"));
        u.setName2(request.getParameter("name2"));
        u.setUname(request.getParameter("uname"));
        u.setPword(request.getParameter("pword"));
        u.setPhone(request.getParameter("phone"));
        
        
        
        try{
            
        boolean flag=SignUpDAO.enterDetails(u);
        if(flag)
            response.sendRedirect("index.html");
        }
        catch(Exception e)
        {System.out.println("error");
        }
        
        
    }
}