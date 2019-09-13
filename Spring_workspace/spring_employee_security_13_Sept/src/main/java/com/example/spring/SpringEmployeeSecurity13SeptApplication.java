package com.example.spring;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringEmployeeSecurity13SeptApplication {

	 @Bean
	    public WebSecurityConfigurerAdapter webSecurityConfig(DataSource dataSource) {
	        return new WebSecurityConfigurerAdapter() {
	            @Override
	            protected void configure(HttpSecurity http) throws Exception {
	                http.authorizeRequests()
	                .antMatchers("/").hasAnyRole("ADMIN","EMPLOYEE").
	                and().
	                    formLogin();
	                http.csrf().disable();
	                http.headers().frameOptions().disable();
	               
	            }

	            @Override
	            protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	                builder.jdbcAuthentication()
	                       .passwordEncoder(new BCryptPasswordEncoder())
	                       .dataSource(dataSource);
	            }
	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeSecurity13SeptApplication.class, args);
	}

}
