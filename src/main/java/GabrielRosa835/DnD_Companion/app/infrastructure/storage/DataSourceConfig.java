package app.infrastructure.storage;

import org.springframework.boot.autoconfigure.orm.jpa.*;
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
	@Bean
	public JpaProperties jpaProperties() {
		JpaProperties jpaProperties = new JpaProperties();
		jpaProperties.setShowSql(true);
		jpaProperties.getProperties().put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.getProperties().put("hibernate.format_sql", "true");
		jpaProperties.getProperties().put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return jpaProperties;
	}
}