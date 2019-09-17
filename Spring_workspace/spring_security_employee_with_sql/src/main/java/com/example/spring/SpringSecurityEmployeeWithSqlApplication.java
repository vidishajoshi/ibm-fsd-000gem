package com.example.spring;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableTransactionManagement
public class SpringSecurityEmployeeWithSqlApplication {

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfig(DataSource dataSource) {
		return new WebSecurityConfigurerAdapter() {
			@Override
			protected void configure(HttpSecurity http) throws Exception{
				http.authorizeRequests()
				.antMatchers("/").hasAnyRole("ADMIN,EMPLOYEE")
				.and()
				.formLogin().permitAll()
				.and()
				.logout().permitAll();
				http.csrf().disable();
				http.headers().frameOptions().disable();
			}
			
			@Override
			protected void configure(AuthenticationManagerBuilder builder) throws Exception{
				builder.jdbcAuthentication()
				.passwordEncoder(new BCryptPasswordEncoder())
				.dataSource(dataSource);
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityEmployeeWithSqlApplication.class, args);
	}

}
