package app.storage.mysql;

import org.springframework.context.annotation.*;

import java.sql.*;

@Configuration
public class MySQLConfig {

	private static final String connectionURL = "jdbc:mysql://localhost:3306/dnd_companion";
	private static final String connectionUser = "root";
	private static final String connectionPassword = "root";

	@Bean
	public Connection connection () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
