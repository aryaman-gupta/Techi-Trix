/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Servlet;

import com.database.DatabaseVals;
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
@WebServlet(name = "SecondQ", urlPatterns = {"/SecondQ"})
public class SecondQ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false);
        
        
        if(session==null)
            response.sendRedirect("Login.jsp");
        String user=null;
        user=(String)session.getAttribute("uname");
        DatabaseVals obj;
        PrintWriter out=response.getWriter();
        
        obj=new DatabaseVals();
            
           
            
            if(obj.isQuestion(user, "Q2")==true)
            {   out.println("<font color=red>You've attempted this question.</font>");
                
                RequestDispatcher rd=request.getRequestDispatcher("QuestionList.jsp");
                rd.include(request, response);
                
            }
        String ans=request.getParameter("Ans");
        if(ans.equals("B"))
            obj.QuestionDone(user,"Q2", 5);
        else
            obj.QuestionDone(user,"Q2", 0);
        
        response.sendRedirect("QuestionList.jsp");
        
    }

}