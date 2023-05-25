/**
 * 
 */
package createTable;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Rupayan Dirghangi
 *
 */
public class CreateTable {
	static final String DB_URL="jdbc:mysql://localhost:3306/ims";
	static final String USER="root";
	static final String PASS="";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt = conn.createStatement();
				) {
			String sql = "CREATE TABLE invoice "+
				"(id INTEGER not NULL AUTO_INCREMENT,"+
					"invoiceDate VARCHAR(200),"+
					"dueDate VARCHAR(200),"+
					"invoiceNo VARCHAR(200),"+
					"invoiceStatus VARCHAR(200),"+
					"product VARCHAR(200),"+
					"customer VARCHAR(200),"+
					"quantity VARCHAR(200),"+
					"price VARCHAR(200),"+
					"discount VARCHAR(200),"+
					"shippingCost VARCHAR(200),"+
					"PRIMARY KEY(id))";
			stmt.executeUpdate(sql);
			System.out.println("Table Generated in the Database");
		}
		catch(SQLException e)
		{
			System.out.println("Error Generating Table");
			e.printStackTrace();
		}


	}

}
