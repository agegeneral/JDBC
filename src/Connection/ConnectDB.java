package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class ConnectDB {

	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Jim_DB";
		Connection con = null;
		Properties props = new Properties();
		props.setProperty("user", "jim");
		props.setProperty("password", "123");
		
		try {
			long startTime, endTime;
			startTime = System.currentTimeMillis();
			
			con = DriverManager.getConnection(url, props);
			
			endTime = System.currentTimeMillis();
			
			System.out.println("Connection has been created.");
			System.out.println("連線花了：" + (endTime - startTime) + "毫秒");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
