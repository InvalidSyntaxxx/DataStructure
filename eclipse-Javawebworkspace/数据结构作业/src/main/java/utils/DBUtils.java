package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	// 加载驱动
	public static void main(String Args[]) {
   	 try {
   
   		 Class.forName("com.mysql.jdbc.Driver");
   		 System.out.println("Success loading mysql driver");
   	 } catch (Exception e) {
   		 System.out.println("Error loading mysql Driver");
   		 e.printStackTrace();
   		 }
	}	 
   	 public static Connection getConnection() throws SQLException {

		String url ="jdbc:mysql://localhost:3306/javaweb";
		String root ="root";
		String password="WANGchen0809.";
		Connection connection = DriverManager.getConnection(url,root,password);
		 System.out.println("Success connect mysql datebase ");
		return connection;
	}

	// 关闭资源
	public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {

		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}

	}
}


