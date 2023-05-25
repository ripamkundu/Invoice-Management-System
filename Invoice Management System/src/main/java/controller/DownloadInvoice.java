package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbconnection.Dbconnection;

/**
 * Servlet implementation class DownloadInvoice
 */
@WebServlet("/DownloadInvoice")
public class DownloadInvoice extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	private final static String query = "select id,invoiceNo,customer,product,price,invoiceDate,dueDate,invoiceStatus,quantity,discount,shippingCost from invoice where id=?";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("application/pdf");
		 
        response.setHeader(
            "Content-disposition",
            "inline; filename='Download Invoice.pdf'");
  
        try{
        	con = dc.dbconnect();
			ps = con.prepareStatement(query);
        	ps.setInt(1, id);
        	ResultSet rs = ps.executeQuery();
        	rs.next();
        	int price=Integer.parseInt(rs.getString(5));
        	int quantity=Integer.parseInt(rs.getString(9));
        	int discount=Integer.parseInt(rs.getString(10));
        	int shippingCost=Integer.parseInt(rs.getString(11));
        	
        	double total=((price*quantity)-((price*quantity)*discount)/100)+shippingCost;
  
            Document document = new Document();
  
            PdfWriter.getInstance(
                document, response.getOutputStream());
  
            document.open();
  
            document.add(new Paragraph(
                    "This is Your Invoice , Please Download it"));
            document.add(new Paragraph("Invoice Id :"+rs.getInt(1)));
            document.add(new Paragraph("Invoice Number :"+rs.getString(2)));
            document.add(new Paragraph("Customer Name :"+rs.getString(3)));
            document.add(new Paragraph("Product Name :"+rs.getString(4)));
            document.add(new Paragraph("Price of the Product :"+rs.getString(5)));
            document.add(new Paragraph("Invoice Date :"+rs.getString(6)));
            document.add(new Paragraph("Due Date :"+rs.getString(7)));
            document.add(new Paragraph("Invoice Status :"+rs.getString(8)));
            document.add(new Paragraph("Quantity :"+rs.getString(9)));
            document.add(new Paragraph("Discount :"+rs.getString(10)+"%"));
            document.add(new Paragraph("Shipping Cost :"+rs.getString(11)+" inr"));
            document.add(new Paragraph("You have to pay :"+total+" inr"));
            
  
            document.close();
        }
        catch (DocumentException de) {
            throw new IOException(de.getMessage());
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
