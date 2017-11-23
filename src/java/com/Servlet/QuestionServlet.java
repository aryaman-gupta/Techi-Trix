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
@WebServlet(name = "QuestionServlet", urlPatterns = {"/QuestionServlet"})
public class QuestionServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false);
        
        
        if(session==null)
            response.sendRedirect("index.html");
        
        String user;
        user=(String)session.getAttribute("uname");
        DatabaseVals obj;
        PrintWriter out=response.getWriter();
        
        obj=new DatabaseVals();
            
           
            
            
        String ans=request.getParameter("Ans");
        String correct=request.getParameter("CorAns");
        String QNum=request.getParameter("QNum");
        if(ans.equalsIgnoreCase(correct))
            obj.QuestionDone(user,QNum, 4);
        else
            obj.QuestionDone(user,QNum, -1);
        
        
        String ques[]={"Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Q11", "Q12", "Q13", "Q14", "Q15"};
        
        int i=0;
        
        for(i=0; i<15; i++)
        {
            
            if(ques[i].equalsIgnoreCase(QNum))
                break;
        }
        
        
        for(int j=i+1; j<15; j++)
        {
        if(!obj.isQuestion(user, ques[j]))
        {
        response.sendRedirect(ques[i].concat(".jsp"));
        return;
        }
        }
        
        for(int j=0; j<i; j++)
        if(!obj.isQuestion(user, ques[j]))
        {response.sendRedirect(ques[i].concat(".jsp"));
        return;
        }
        
        response.sendRedirect("Scorecard.jsp");
                return;
    }

}