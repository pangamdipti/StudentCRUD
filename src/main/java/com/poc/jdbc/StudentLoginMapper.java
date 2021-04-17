package com.poc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class StudentLoginMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setUid(rs.getString("uid"));
		student.setPassword(rs.getString("password"));
		student.setRoll_no(rs.getString("rollno"));
		student.setStudent_name(rs.getString("name"));
		student.setStudent_contact(rs.getString("contact"));
		student.setStudent_course(rs.getString("course"));
		
		return student;
	}


	

}
