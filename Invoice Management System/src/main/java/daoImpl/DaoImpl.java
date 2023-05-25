/**
 * 
 */
package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconnection.Dbconnection;
import vo.ResultVO;
import vo.UserVO;
import vo.CustomerVO;
import vo.ProductVO;
import vo.InvoiceVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rupayan Dirghangi
 *
 */
public class DaoImpl {
	public Connection con = null;
	public PreparedStatement ps = null;
	Dbconnection dc = new Dbconnection();
	ResultVO rvo = new ResultVO();
	boolean status = false;

	/**
	 * @param args
	 */
	public ResultVO dataInsert(UserVO uvo) {
		try {
			String username = uvo.getUsername();
			String password = uvo.getPassword();

			con = dc.dbconnect();

			String insertQuery = "insert into registration values(DEFAULT, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, username);
			ps.setString(2, password);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
//	public ResultVO userDelete(UserVO uvo) {
//		try {
//			String email = uvo.getEmail();
//			
//			con = dc.dbconnect();
//			
//			String deleteQuery = "delete from user where email=?";
//			ps = con.prepareStatement(deleteQuery);
//			ps.setString(1, email);
//			
//			int i = ps.executeUpdate();
//			if (i>0) {
//				System.out.println("Data Deleted");
//			}
//			else {
//				System.out.println("Failed");
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return rvo;
//		
//	}

	public ResultVO passwordUpdate(UserVO uvo) {
		try {
			String username = uvo.getUsername();
			String password = uvo.getPassword();
			
			con = dc.dbconnect();
			
			String updateQuery = "update registration set password=? where username=?";
			ps= con.prepareStatement(updateQuery);
			ps.setString(1, password);
			ps.setString(2, username);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}
	public String Login(UserVO uvo) {
		try {

			String username = uvo.getUsername();
			String password = uvo.getPassword();

			con = dc.dbconnect();

			String loginQuery = "select * from registration where username=? and password=?";
			ps = con.prepareStatement(loginQuery);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if(status) {
				return "true";
			}
			else {
				return "false";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

//	Customer details
	public ResultVO customerInsert(CustomerVO cvo) {
		try {
			String fname = cvo.getFirstname();
			String lname = cvo.getLastname();
			String email = cvo.getEmail();
			String phone = cvo.getPhone();
			String address = cvo.getAddress();
			String country = cvo.getCountry();

			con = dc.dbconnect();

			String insertQuery = "insert into customer values(DEFAULT, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setString(6, country);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
	
	public ResultVO customerUpdate(CustomerVO cvo) {
		try {
			String fname = cvo.getFirstname();
			String lname = cvo.getLastname();
			String email = cvo.getEmail();
			String phone = cvo.getPhone();
			String address = cvo.getAddress();
			String country = cvo.getCountry();
			int id = cvo.getId();
			
			con = dc.dbconnect();
			
			String updateQuery = "update customer set fname=?,lname=?,email=?,phone=?,address=?,country=? where id=?";
			ps= con.prepareStatement(updateQuery);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.setString(6, country);
			ps.setInt(7, id);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}
	
	public ResultVO customerDelete(CustomerVO cvo) {
		try {
			int id = cvo.getId();
			
			con = dc.dbconnect();
			
			String deleteQuery = "delete from customer where id=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Deleted");
			}
			else {
				System.out.println("Failed");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rvo;
		
	}
	

//	Product details
	public ResultVO productInsert(ProductVO pvo) {
		try {
			String pname = pvo.getProductname();
			String price = pvo.getPrice();
			String pdescription = pvo.getPdescription();

			con = dc.dbconnect();

			String insertQuery = "insert into product values(DEFAULT, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, pname);
			ps.setString(2, price);
			ps.setString(3, pdescription);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
	
	public ResultVO productUpdate(ProductVO pvo) {
		try {
			String pname = pvo.getProductname();
			String price = pvo.getPrice();
			String pdescription = pvo.getPdescription();
			int id = pvo.getId();
			
			con = dc.dbconnect();
			
			String updateQuery = "update product set pname=?,price=?,pdescription=? where id=?";
			ps= con.prepareStatement(updateQuery);
			ps.setString(1, pname);
			ps.setString(2, price);
			ps.setString(3, pdescription);
			ps.setInt(4, id);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}
	
	public ResultVO productDelete(ProductVO pvo) {
		try {
			int id = pvo.getId();
			
			con = dc.dbconnect();
			
			String deleteQuery = "delete from product where id=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Deleted");
			}
			else {
				System.out.println("Failed");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rvo;
		
	}
	//Invoice Section
	public ResultVO invoiceInsert(InvoiceVO ivo) {
		try {
			String invoiceDate = ivo.getInvoiceDate();
			String dueDate = ivo.getDueDate();
			String invoiceNo = ivo.getInvoiceNo();
			String invoiceStatus = ivo.getInvoiceStatus();
			String product = ivo.getProduct();
			String customer = ivo.getCustomer();
			String quantity = ivo.getQuantity();
			String price = ivo.getPrice();
			String discount = ivo.getDiscount();
			String shippingCost = ivo.getShippingCost();

			con = dc.dbconnect();

			String insertQuery = "insert into invoice values(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, invoiceDate);
			ps.setString(2, dueDate);
			ps.setString(3, invoiceNo);
			ps.setString(4, invoiceStatus);
			ps.setString(5, product);
			ps.setString(6, customer);
			ps.setString(7, quantity);
			ps.setString(8, price);
			ps.setString(9, discount);
			ps.setString(10, shippingCost);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rvo;

	}
	
	public ResultVO invoiceUpdate(InvoiceVO ivo) {
		try {
			String invoiceDate = ivo.getInvoiceDate();
			String dueDate = ivo.getDueDate();
			String invoiceNo = ivo.getInvoiceNo();
			String invoiceStatus = ivo.getInvoiceStatus();
			String product = ivo.getProduct();
			String customer = ivo.getCustomer();
			String quantity = ivo.getQuantity();
			String price = ivo.getPrice();
			String discount = ivo.getDiscount();
			String shippingCost = ivo.getShippingCost();
			int id = ivo.getId();
			
			con = dc.dbconnect();
			
			String updateQuery = "update invoice set invoiceDate=?,dueDate=?,invoiceNo=?,invoiceStatus=?,product=?,customer=?,quantity=?,price=?,discount=?,shippingCost=? where id=?";
			ps= con.prepareStatement(updateQuery);
			ps.setString(1, invoiceDate);
			ps.setString(2, dueDate);
			ps.setString(3, invoiceNo);
			ps.setString(4, invoiceStatus);
			ps.setString(5, product);
			ps.setString(6, customer);
			ps.setString(7, quantity);
			ps.setString(8, price);
			ps.setString(9, discount);
			ps.setString(10, shippingCost);
			ps.setInt(11, id);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rvo;
	}
	
	
	public ResultVO invoiceDelete(InvoiceVO ivo) {
		try {
			int id = ivo.getId();
			
			con = dc.dbconnect();
			
			String deleteQuery = "delete from invoice where id=?";
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("Data Deleted");
			}
			else {
				System.out.println("Failed");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rvo;
		
	}
}
