/**
 * 
 */
package dbconnection;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 * @author Ripam Kundu
 *
 */
public class Dbconnection {
	public Connection con = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dbconnection dc = new Dbconnection();
		dc.dbconnect();

	}
	public Connection dbconnect() {
		try {
			System.out.println("Connecting.....!");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims","root","");
			System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println("CONNECTION ERROR");
			e.printStackTrace(); //printStackTrace is used to print the java sql exception
		}
		return con;
	}

}
