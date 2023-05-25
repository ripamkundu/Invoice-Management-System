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

@WebServlet("/showcustomerdata")
public class ShowCustomer extends HttpServlet {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	private final static String query = "select id,fname,lname,email,phone from customer";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// link the bootstrap
		pw.println("<title>Manage Customer</title>");
		pw.println("<link rel='icon' type='image/x-icon' href='./image/logo.ico'>");
		pw.println(
				"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		pw.println(
				"<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>");
		pw.println(
				"<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>");
		pw.println(
				"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
		pw.println(
				"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\" />");
		pw.println("<link rel='stylesheet' href='css/manage.css' />");
		pw.println("<script src='js/tooltip.js'></script>");
//		pw.println("<marquee><h2 class='text-primary'>List of Customers</h2></marquee>");

		// generate the connection
		try {
			con = dc.dbconnect();
			ps = con.prepareStatement(query);
			// resultSet
			ResultSet rs = ps.executeQuery();
			pw.println("<div class='main-div'>");
			pw.println("<h2>List of Customers</h2>");
			pw.println("<div class='center-div'>");
			pw.println("<div class='table-responsive'>");
			pw.println("<table>");
			pw.println("<thead>");
			pw.println("<tr>");
			pw.println("<th>First Name</th>");
			pw.println("<th>Last Name</th>");
			pw.println("<th>Email</th>");
			pw.println("<th>Phone No</th>");
			pw.println("<th colspan='2'>Actions</th>");
			pw.println("</tr>");
			pw.println("</thead>");
			while (rs.next()) {
				pw.println("<tbody>");
				pw.println("<tr>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getString(4) + "</td>");
				pw.println("<td>" + rs.getString(5) + "</td>");
				pw.println(
						"<td><a style='color: black;' data-toggle='tooltip' data-placement='bottom' title='UPDATE' href='editcustomerurl?id="
								+ rs.getInt(1) + "'><i class='fa-regular fa-pen-to-square'></i></a></td>");
				pw.println(
						"<td><a style='color: black;' data-toggle='tooltip' data-placement='bottom' title='DELETE' href='customerDelete?id="
								+ rs.getInt(1) + "'><i class='fa-solid fa-trash'></i></a></td>");
				pw.println("</tr>");
				pw.println("</tbody>");
			}
			pw.println("</table>");
		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</div>");
		// close the stream
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
