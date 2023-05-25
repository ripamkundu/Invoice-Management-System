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

@WebServlet("/chooseinvoice")
public class ChooseInvoice extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	private final static String query = "select pname from product";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        pw.println("<title>Choose Product</title>");
        pw.println("<link rel='icon' type='image/x-icon' href='./image/logo.ico'>");
        
        pw.println("<link rel='preconnect' href='https://fonts.googleapis.com'>");
        pw.println("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
        pw.println("<link href='https://fonts.googleapis.com/css2?family=Poppins&display=swap' rel='stylesheet'>");
        pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css' integrity='sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==' crossorigin='anonymous' />");
        pw.println("<link rel='stylesheet' href='css/forget.css' />");
        pw.println("<style>.passInput{color: palevioletred;} .card{height: 36vh;}</style>");
        
        //generate the connection
        try{
        	con = dc.dbconnect();
			ps = con.prepareStatement(query);
            //resultSet
            ResultSet rs = ps.executeQuery();
            
            pw.println("<form class='card' action='invoiceForm' method='POST'>");
            pw.println("<p class='lock-icon'>");
            pw.println("<i class='fas fa-receipt'></i>");
            pw.println("</p>");
            pw.println("<h2>Make Invoice</h2>");
            pw.println("<br>");
            pw.println("<p>Select the Product For making its Invoice</p>");
            pw.println("<br>");
            pw.println("<select class='passInput' name='pname'>");
            while(rs.next()) {
            pw.println("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");
            }
            pw.println("</select>");
            pw.println("<button type='submit' name='submit'>Make Invoice</button>");
            pw.println("</form>");
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        //close the stream
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }

}
