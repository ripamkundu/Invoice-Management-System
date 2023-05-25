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

@WebServlet("/editproducturl")
public class EditProductForm extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	private final static String query = "select pname,pdescription,price from product where id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //get the id
        int id = Integer.parseInt(req.getParameter("id"));
        pw.println("<title>Product Update form</title>");
        pw.println("<link rel='icon' type='image/x-icon' href='./image/logo.ico'>");
        pw.println("<link rel='stylesheet' href='css/productform.css' />");
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
            pw.println("<div class='title'>Fill the Product Details</div>");
            pw.println("<div class='content'>");
            pw.println("<form action='ProductUpdate?id="+id+"' method='POST'>");
            pw.println("<div class='user-details'>");
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Product Name</span>");
            pw.println("<input type='text' name='pname' placeholder='Enter Product Name' value='"+rs.getString(1)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Price</span>");
            pw.println("<input type='text' name='price' placeholder='Enter the Price' value='"+rs.getString(3)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box1'>");
            pw.println("<span class='details'>Product Description</span>");
            pw.println("<textarea id= cols='30' rows='10' name='pdescription' required>"+rs.getString(2)+"</textarea>");
            pw.println("</div>");
            
            pw.println("</div>");
            
            pw.println("<div class='button'>");
            pw.println("<input type='submit' value='Update Product' name='submit'>");
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
