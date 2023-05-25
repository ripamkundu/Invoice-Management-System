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

@WebServlet("/invoiceForm")
public class InvoiceForm extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps1 = null;
	public PreparedStatement ps2 = null;
	public PreparedStatement ps3 = null;
	Dbconnection dc = new Dbconnection();
	private final static String query1 = "select fname,lname from customer";
	private final static String query2 = "select pname,price from product where pname=?";
	private final static String query3 = "select count(*) from invoice";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //get the id
        String pname = req.getParameter("pname");
        pw.println("<title>Invoice Form</title>");
        pw.println("<link rel='icon' type='image/x-icon' href='./image/logo.ico'>");
        pw.println("<link rel='stylesheet' href='css/invoiceform.css' />");
        //generate the connection
        try{
        	con = dc.dbconnect();
			ps1 = con.prepareStatement(query1);
			ps2 = con.prepareStatement(query2);
			ps3 = con.prepareStatement(query3);
        	ps2.setString(1, pname);
            //resultSet
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs3 = ps3.executeQuery();
            pw.println("<div class='container'>");
            pw.println("<div class='title'>Fill the Invoice Details</div>");
            pw.println("<div class='content'>");
            pw.println("<form action='InvoiceInsert' method='POST'>");
            pw.println("<div class='user-details'>");
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Invoice Date</span>");
            pw.println("<input id='invoiceDate' type='date' name='invoiceDate' placeholder='Enter the invoice date' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Due Date</span>");
            pw.println("<input id='dueDate' type='date' name='dueDate' placeholder='Enter the due date' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Invoice Number</span>");
            rs3.next();
            pw.println("<input id='invoiceNo' type='text' name='invoiceNo' value='"+(rs3.getInt(1)+1)+"' placeholder='Enter the invoice number' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Invoice Status</span>");
            pw.println("<select id='invoiceStatus' 'text' name='invoiceStatus' required>");
            pw.println("<option value='open'>Open</option>");
            pw.println("<option value='paid'>Paid</option>");
            pw.println("</select>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Product</span>");
            rs2.next();
            pw.println("<input id='product' type='text' name='product' placeholder='Enter the Product' value='"+rs2.getString(1)+"' required>");
            pw.println("</div>");
             
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Select a Customer</span>");
            pw.println("<select id='customer' type='text' name='customer' required>");
            while (rs1.next()) {
            	pw.println("<option value='"+rs1.getString(1)+" "+rs1.getString(2)+"'>"+rs1.getString(1)+" "+rs1.getString(2)+"</option>");
            }
            pw.println("</select>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Quantity</span>");
            pw.println("<input id='quantity' type='number' min='1' name='quantity' placeholder='Enter the quantity' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Price</span>");
            pw.println("<input id='price' type='number' name='price' placeholder='Price of the Product' value='"+rs2.getString(2)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Discount</span>");
            pw.println("<input id='discount' type='number' name='discount' placeholder='Enter the discount percentage' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Shipping Cost</span>");
            pw.println("<input id='shippingCost' type='number' name='shippingCost' placeholder='Enter the shipping cost' required>");
            pw.println("</div>");
            
//            pw.println("<div class='subtotal' style='margin-top: 1%;'>");
//            pw.println("<div class='sub'>");
//            pw.println("<h4>TAX & VAT :</h4>");
//            pw.println("<p id='tax'></p>");
//            pw.println("</div>");
//            pw.println("<div class='sub'>");
//            pw.println("<h4>SUB TOTAL :</h4>");
//            pw.println("<p id='total'>0 Rupees</p>");
//            pw.println("</div>");
//            pw.println("</div>");
            
            pw.println("</div>");
            
            pw.println("<div class='button'>");
            pw.println("<input id='submit' type='submit' value='Create Invoice' name='submit'>");
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
