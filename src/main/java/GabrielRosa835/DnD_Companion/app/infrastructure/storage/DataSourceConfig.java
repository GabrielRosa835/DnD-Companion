package app.infrastructure.storage;

import org.springframework.boot.jdbc.*;
import org.springframework.context.annotation.*;

import javax.sql.*;

@Configuration
public class DataSourceConfig {
	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://localhost:3306/dnd_companion")
				.username("root")
				.password("root")
				.build();
	}
}