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
public class ServletContact extends HttpServlet {
//
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        Connection con= null;
        String userName= request.getParameter("userName");
        String userEmail= request.getParameter("userEmail");
        String userSubject= request.getParameter("userSubject");
        String userMessage= request.getParameter("userMessage");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            PreparedStatement ps= con.prepareStatement("insert into contact values(?,?,?,?)");
            ps.setString(1,userName);
            ps.setString(2,userEmail);
            ps.setString(3,userSubject);
            ps.setString(4,userMessage);
            ps.executeUpdate();
            response.sendRedirect("Home.html");
            out.println("Data is inputed succesfully");
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