/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Servlet;

import com.Bean.LoginBean;
import com.database.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aryaman
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        LoginBean lb;
        lb=new LoginBean();
        lb.setUname(request.getParameter("uname"));
        lb.setPword(request.getParameter("pword"));
        
        try{
            
        String uname=LoginDAO.validate(lb);
        if(!uname.equals(""))
        {   
        HttpSession session=request.getSession();
        session.setAttribute("uname", uname);
        session.setMaxInactiveInterval(15*60);
        response.sendRedirect("Rules.jsp");
        
        }
        else
        {
            out.println("<font color='red'><b>Incorrect Username Password combination. Try again. </b></font>");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
        }
        catch(Exception e)
        {System.out.println("error");
        }
        
        
        
    }

   

}
