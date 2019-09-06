package com.example.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class StudentRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student st=new Student();
		st.setId(rs.getInt(1));
		st.setFname(rs.getString(2));
		st.setLname(rs.getString(3));
		st.setEmail(rs.getString(4));
		st.setCountry(rs.getString(5));
		st.setLang(rs.getString(6));
		st.setOs(rs.getString(7));
		return st;
		
	}
	
}
