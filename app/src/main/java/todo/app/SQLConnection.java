package todo.app;

import java.sql.*;

public class SQLConnection {
	
	public static void main(String[] args) {
		getDbConnection();
	}
	
	public static Connection connObj;
	public static String JDBC_URL = 
			"jdbc:sqlserver://localhost\\SQLEXPRESS01:1433;databaseName=ToDoList;"
			+ "integratedSecurity=true";
	
	public static Connection getDbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection(JDBC_URL);
			if(connObj != null) {
				DatabaseMetaData metaObj = (DatabaseMetaData) connObj.getMetaData();
				//System.out.println("Connection Success");
			}
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return connObj;
	}

}