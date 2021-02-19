package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javamail.TestConfig;

public class TestDBQuery {
	static Connection con;

	public static void main(String[] args) throws SQLException {

		try {
			con = DriverManager.getConnection(TestConfig.mysqlurl, TestConfig.mysqluserName, TestConfig.mysqlpassword);
			if (!con.isClosed()) {
				System.out.println("Connection Eshtablished");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection is not successfull");
		}
		getquery();

	}

	public static void getquery() throws SQLException {
		String query = "select * from a_schema_version";
		Statement st;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<String> values = new ArrayList<String>();
		while (rs.next()) {
			values.add(rs.getString(1));
		}
		System.out.println(values);
	}

}
