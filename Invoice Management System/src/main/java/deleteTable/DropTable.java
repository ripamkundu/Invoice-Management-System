/**
 * 
 */
package deleteTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Rupayan Dirghangi
 *
 */
public class DropTable {
	static final String db_url="jdbc:mysql://localhost:3306/ims";
	static final String user="root";
	static final String password="";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection conn = DriverManager.getConnection(db_url,user,password);
				Statement stmt = conn.createStatement();
				)
		{
			String sql="DROP TABLE students";
			stmt.executeUpdate(sql);
			System.out.println("Table Deleted");
		}
		catch(SQLException e)
		{
			System.out.println("Error deleting the table");
			e.printStackTrace();
		}

	}

}
