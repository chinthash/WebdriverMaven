package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javamail.TestConfig;

public class TestJDBCConnection {
	public static void main(String args[]) {

		Connection con;
		try {
			con = DriverManager.getConnection(TestConfig.mysqlurl, TestConfig.mysqluserName, TestConfig.mysqlpassword);

			if (!con.isClosed()) {
				System.out.println("Connection is eshtablished successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection unsuccessfull Please  check the details");
		}
	}
}
