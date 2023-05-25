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

@WebServlet("/editinvoicerurl")
public class EditInvoiceForm extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	private final static String query = "select invoiceDate,dueDate,invoiceNo,invoiceStatus,product,customer,quantity,price,discount,shippingCost from invoice where id=?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //get the id
        int id = Integer.parseInt(req.getParameter("id"));
        pw.println("<title>Invoice Update form</title>");
        pw.println("<link rel='icon' type='image/x-icon' href='./image/logo.ico'>");
        pw.println("<link rel='stylesheet' href='css/invoiceform.css' />");
        
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
            pw.println("<div class='title'>Fill the Invoice Details</div>");
            pw.println("<div class='content'>");
            pw.println("<form action='InvoiceUpdate?id="+id+"' method='POST'>");
            pw.println("<div class='user-details'>");
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Invoice Date</span>");
            pw.println("<input id='invoiceDate' type='date' name='invoiceDate' placeholder='Enter the invoice date' value='"+rs.getString(1)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Due Date</span>");
            pw.println("<input id='dueDate' type='date' name='dueDate' placeholder='Enter the due date' value='"+rs.getString(2)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Invoice Number</span>");
            pw.println("<input id='invoiceNo' type='text' name='invoiceNo' value='"+rs.getInt(3)+"' placeholder='Enter the invoice number' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Invoice Status</span>");
            pw.println("<input id='invoiceStatus' type='text' name='invoiceStatus' placeholder='Enter the Invoice Status' value='"+rs.getString(4)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Product</span>");
            pw.println("<input id='product' type='text' name='product' placeholder='Enter the Product' value='"+rs.getString(5)+"' required>");
            pw.println("</div>");
             
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Select a Customer</span>");
            pw.println("<input id='customer' type='text' name='customer' placeholder='Enter the Customer Name' value='"+rs.getString(6)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Quantity</span>");
            pw.println("<input id='quantity' type='number' min='1' name='quantity' placeholder='Enter the quantity' value='"+rs.getString(7)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Price</span>");
            pw.println("<input id='price' type='number' name='price' placeholder='Price of the Product' value='"+rs.getInt(8)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Discount</span>");
            pw.println("<input id='discount' type='number' name='discount' placeholder='Enter the discount percentage' value='"+rs.getString(9)+"' required>");
            pw.println("</div>");
            
            pw.println("<div class='input-box'>");
            pw.println("<span class='details'>Shipping Cost</span>");
            pw.println("<input id='shippingCost' type='number' name='shippingCost' placeholder='Enter the shipping cost' value='"+rs.getString(10)+"' required>");
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
            pw.println("<input id='submit' type='submit' value='Update Invoice' name='submit'>");
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
