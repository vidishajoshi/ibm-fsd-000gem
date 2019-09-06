package com.example.bean.connection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component("jdbc1")
public class MyJdbcTemplate extends JdbcTemplate {
@Autowired
private MyDataSource dataSource;
@PostConstruct
public void init() {
	setDataSource((DataSource) dataSource);
}
}
