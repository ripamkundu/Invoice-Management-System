package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbconnection.Dbconnection;
@WebServlet("/editcustomerurl")
public class EditCustomerForm extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	private final static String query = "select fname,lname,email,phone,address,country from customer where id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //get the id
        int id = Integer.parseInt(req.getParameter("id"));
        pw.println("<title>Customer Update form</title>");
        pw.println("<link rel='icon' type='image/x-icon' href='./image/logo.ico'>");
        pw.println("<link rel='stylesheet' href='css/customerform.css' />");
       
        //generate the connection
        try{
        	con = dc.dbconnect();
			ps = con.prepareStatement(query);
        	//set value 
            ps.setInt(1, id);
            //resultSet
            ResultSet rs = ps.executeQuery();
            rs.next();
            pw.println("<div class='container'>");
            pw.println("<div class='title'>Fill the Customer Details</div>");
            pw.println("<div class='content'>");
            pw.println("<form action='CustomerUpdate?id="+id+"' method='POST'>");
            pw.println("<div class='user-details'>");
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>First Name</span>");
            pw.println("<input type='text' name='fname' placeholder='Enter your first-name' value='"+rs.getString(1)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Last Name</span>");
            pw.println("<input type='text' name='lname' placeholder='Enter your last-name' value='"+rs.getString(2)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Email</span>");
            pw.println("<input type='email' name='email' placeholder='Enter your email' value='"+rs.getString(3)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Phone No.</span>");
            pw.println("<input type='text' name='phone' placeholder='Enter your phone number' value='"+rs.getString(4)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Address</span>");
            pw.println("<input type='text' name='address' placeholder='Enter your address' value='"+rs.getString(5)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Country</span>");
            pw.println("<input type='text' name='country' placeholder='Enter your country' value='"+rs.getString(6)+"' required>");
            pw.println("</div>");
            
            pw.println("</div>");
            
            pw.println("<div class='button'>");
            pw.println("<input type='submit' value='Update Customer' name='submit'>");
            pw.println("</div>");
            pw.println("</form>");
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("</div>");
        pw.println("</div>");
        //close the stream
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }

}
