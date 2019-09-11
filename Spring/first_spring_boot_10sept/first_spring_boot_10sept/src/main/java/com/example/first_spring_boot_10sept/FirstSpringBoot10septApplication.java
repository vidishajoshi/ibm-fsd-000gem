package com.example.first_spring_boot_10sept;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableTransactionManagement
public class FirstSpringBoot10septApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBoot10septApplication.class, args);
	}

}
