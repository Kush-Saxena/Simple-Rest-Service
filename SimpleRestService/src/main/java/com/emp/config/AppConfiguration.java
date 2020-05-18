package com.emp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.emp" }) // packages where spring will scan for components
@PropertySource(value = { "classpath:dbconnection.properties" }) // properties file from where spring will read data.
public class AppConfiguration {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String dbUserName;

	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Value("${spring.datasource.driver}")
	private String dbDriver;

	// Here custom beans can be added based on need,
	// by default working using component scanning of all packages.

	@Bean
	public DriverManagerDataSource datasouce() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(dbUrl);
		ds.setUsername(dbUserName);
		ds.setPassword(dbPassword);
		ds.setDriverClassName(dbDriver);

		return ds;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(datasouce());
		return template;
	}

}