package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)
public class MySecurityConfig {

	@Autowired
	HttpSecurity httpSecurity;

	@Bean
	public InMemoryUserDetailsManager setUpUsers() {
		UserDetails user1 = User.withUsername("Rohith").password("rohith").roles("admin", "user").build();
		return new InMemoryUserDetailsManager(user1);
	}

	@Bean
	PasswordEncoder passwordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	SecurityFilterChain settingUpHttpSecurity() throws Exception {

	      httpSecurity.authorizeHttpRequests(customizer -> {
	            customizer.requestMatchers("/helloWorld", "/hello").authenticated()
	                      .requestMatchers("/process-registration").permitAll()
	                      .anyRequest().authenticated();
	        });
	    httpSecurity.csrf(Customizer.withDefaults());
	    httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.formLogin(Customizer.withDefaults());
		
		return httpSecurity.build();
	}

	@Bean(name = "mvcHandlerMappingIntrospector")
	public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Bean
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/employee_isigntech");
//		dataSource.setUsername("root");
//		dataSource.setPassword("Rohithsmv369");
//		return dataSource;
//	}
//	
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
//
//	
//	@Bean
//	public JdbcUserDetailsManager jdbcUserDetailsManager() {
//		return new JdbcUserDetailsManager(dataSource());
//	}


	
}
