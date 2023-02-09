/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class Servletregis extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        Connection con= null;
        String userName= request.getParameter("userName");
        String userPass= request.getParameter("userPass");
        String userEmail= request.getParameter("userEmail");
        String userDOB= request.getParameter("userDOB");
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            PreparedStatement ps= con.prepareStatement("insert into register values(?,?,?,?)");
            ps.setString(1,userName);
            ps.setString(2,userPass);
            ps.setString(3,userEmail);
            ps.setString(4,userDOB);
            ps.executeUpdate();
            
            out.println("Data is inputed succesfully");
            response.sendRedirect("Home.html");
        }
        catch(Exception e)
        {e.printStackTrace();
        }
        finally
        {
            try{
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        
}
}