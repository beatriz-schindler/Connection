package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;
	
	public static Connection getConnection() {
	
		if(connection == null) {
			try {	
				
				// necessário para aplicações web
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				connection = DriverManager.getConnection("jdbc:mysql://localhost/topicos_especiais", "root", "Biatriz@2003");
				
			} catch (SQLException e) {
				
				throw new RuntimeException(e);
			}
		} 
			return connection;

	
	}	
}