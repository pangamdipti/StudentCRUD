package com.poc.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public void addLogin(String uid, String password) {
		String SQL = "insert into login(uid, password) values(?,?)";
		jdbcTemplateObject.update(SQL, uid, password);
		System.out.println("Record created");

	}

	@Override
	public String getUserId(String uid) {
		try {
			String SQL = "select uid from login where uid=?";
			String suid = jdbcTemplateObject.queryForObject(SQL,new Object[] {uid},
					String.class);
			return suid;
		}
		catch(EmptyResultDataAccessException e) {
			return "0";
		}
		catch(IncorrectResultSizeDataAccessException e) {
			return "0";
		}
		
	}
	
	@Override
	public String getUserPassword(String uid) {
		
			String SQL = "select password from login where uid=?";		
			String spass = jdbcTemplateObject.queryForObject(SQL,new Object[] {uid},
					String.class);
			return spass;
		
		
		
	}

	@Override
	public void addData(String uid,String rollno, String name, String contact, String course) {
		String SQL = "update login set rollno=?, name=?, contact=?, course=? where uid=? ";
		jdbcTemplateObject.update(SQL, rollno, name, contact, course, uid);
		System.out.println("Record created");
		
	}
	
	@Override
	public Student showStudent(String uid) {
		try {
			String SQL ="select * from login where uid=?";
			Student Student = jdbcTemplateObject.queryForObject(SQL, new Object[] {uid}, new StudentLoginMapper());
			return Student;
		}
		catch(EmptyResultDataAccessException e) {
			Student student = new Student("0", "0", "0", "0", "0", "0");
			return student;
		}
		catch(IncorrectResultSizeDataAccessException e) {
			Student student = new Student("0", "0", "0", "0", "0", "0");
			return student;
		}
		
		
	}

	@Override
	public void deleteStudent(String rollno) {
		String SQL = "delete from login where rollno=?";
		jdbcTemplateObject.update(SQL, rollno);
		System.out.println("student deleted");
		
	}

	@Override
	public String getRoll(String rollno) {
		try {
			String SQL = "select rollno from login where rollno=?";
			String roll = jdbcTemplateObject.queryForObject(SQL,new Object[] {rollno},
					String.class);
			return roll;
		}
		catch(EmptyResultDataAccessException e) {
			return "0";
		}
		catch(IncorrectResultSizeDataAccessException e) {
			return "0";
		}
	}

	@Override
	public void updateStudent(String rollno, String contact) {
		String SQL = "update login set contact=? where rollno=? ";
		jdbcTemplateObject.update(SQL, contact, rollno);
		System.out.println("Record updated");
		
	}

	@Override
	public Student showStudentByRollNo(String rollno) {
		try {
			String SQL ="select * from login where rollno=?";
			Student Student = jdbcTemplateObject.queryForObject(SQL, new Object[] {rollno}, new StudentLoginMapper());
			return Student;
		}
		catch(EmptyResultDataAccessException e) {
			Student student = new Student("0", "0", "0", "0", "0", "0");
			return student;
		}
		catch(IncorrectResultSizeDataAccessException e) {
			Student student = new Student("0", "0", "0", "0", "0", "0");
			return student;
		}
		
	}

	@Override
	public List<Student> showStudents() {
		String SQL = "select * from login";
		List <Student> Students = jdbcTemplateObject.query(SQL, new StudentLoginMapper());
		return Students;
	}

	

}
