/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ServletQuiz extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
          int cnt=0;
          String c="",p="",r="",o="";
          c=request.getParameter("city");
          p=request.getParameter("prov");
          r=request.getParameter("pres");
          o=request.getParameter("cont");
          
            out.write("<html>");
            out.write("<head>");
            out.write("<title>Quiz Result</title>");
            out.write("<link rel='stylesheet' href='result.css'>");            
          
          
          if(c.equals("jkt"))
          {
              
      
              out.write("<p>Your answer for question 1 is correct !</p>");
              cnt++;
              
          }
          else
          
              out.write("<p>The correct answer for question 1 is Jakarta</p>");
          
          if(p.equals("tigpat"))
          {
              out.write("<p>Your answer for question 2 is correct !</p>");
              cnt++;
          }
          else
          
              out.write("<p>The correct answer for question 2 is 34(Tiga puluh Empat)</p>");
          
          if(r.equals("jkw"))
          {
              out.write("<p>Your answer for question 3 is correct !</p>");
              cnt++;
          }
          else
          
              out.write("<p>The correct answer for question 3 is Joko Widodo</p>");
          
           if(o.equals("ausas"))
          {
              out.write("<p>Your answer for question 4 is correct ! </p>");
        ;
              cnt++;
          }
          else
          
              out.write("<p>The correct for question 4 answer is Australia and Asia</p>");
          
        
          if (cnt==4)
                  out.write("<h1>Congratulation</h1>");
                  out.write("<h3>your score is "+cnt+" points</h3>");
                  out.write("<center> <a href=\"quiz.html\" class=\"button_back\" value=\"logout\">Back To Quiz</a> </center> ");
                 out.write("<br><br><center> <a href=\"Home.html\" class=\"button_logout\" value=\"logout\">Logout</a> </center> ");
                 
              out.write("</head>");
            out.write("<body>");  
        }
   
    }

