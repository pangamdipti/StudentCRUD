package com.poc.jdbc;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource ds);
	
	public void addLogin(String uid, String password);
	
	public String getUserId(String uid);

	public String getUserPassword(String uid);

	public Student showStudent(String uid);

	public void addData(String uid, String rollno, String name, String contact, String course);

	public void deleteStudent(String rollno);

	public String getRoll(String rollno);

	public void updateStudent(String rollno, String contact);

	public Student showStudentByRollNo(String rollno);

	public List<Student> showStudents();
	

}
