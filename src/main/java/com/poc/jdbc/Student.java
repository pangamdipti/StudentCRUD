package com.poc.jdbc;

public class Student {
	
	public String uid;
	public String password;
	public String roll_no;
	public String student_name;
	public String student_contact;
	public String student_course;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_contact() {
		return student_contact;
	}
	public void setStudent_contact(String student_contact) {
		this.student_contact = student_contact;
	}
	public String getStudent_course() {
		return student_course;
	}
	public void setStudent_course(String student_course) {
		this.student_course = student_course;
	}
	public Student(String uid, String password, String roll_no, String student_name, String student_contact,
			String student_course) {
		super();
		this.uid = uid;
		this.password = password;
		this.roll_no = roll_no;
		this.student_name = student_name;
		this.student_contact = student_contact;
		this.student_course = student_course;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
