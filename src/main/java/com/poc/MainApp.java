package com.poc;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poc.jdbc.*;
import com.poc.jdbc.Student;

public class MainApp {

	Map<String, Student> studentMap;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentJDBCTemplate StudentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		int choice1, choice2;
		String uid, password, repPassword, rollno;
		Student Student;

		String stid, stpass, stroll;
		String name, course, contact;

		Scanner sc = new Scanner(System.in);

		outer: while (true) {
			System.out.println("\nPlease login or Register");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice1 = sc.nextInt();

			switch (choice1) {
			case 1: // register
				System.out.print("Enter uid: ");
				uid = sc.next();

				Student = StudentJDBCTemplate.showStudent(uid);

				// stid = StudentJDBCTemplate.getUserId(uid);
				if (uid.equals(Student.getUid())) {

					System.out.println("User already exists");
					continue outer;
				} else {
					System.out.print("Enter password: ");
					password = sc.next();
					System.out.print("Repeat password: ");
					repPassword = sc.next();
					if (password.equals(repPassword)) {
						StudentJDBCTemplate.addLogin(uid, password);
						System.out.println("User registered");
						break;
					} else {
						System.out.println("Invalid password");
					}
				}
				break;

			case 2: // login
				System.out.print("Enter uid: ");
				uid = sc.next();
				stid = StudentJDBCTemplate.getUserId(uid);
				if (stid.equals(uid)) {
					System.out.print("Enter password: ");
					password = sc.next();
					Student = StudentJDBCTemplate.showStudent(uid);

					if (password.equals(Student.getPassword())) {
						while (true) {
							System.out.println("\nSelect any operation to perform");
							System.out.println("1. Add");
							System.out.println("2. Delete");
							System.out.println("3. Update");
							System.out.println("4. Show");
							System.out.println("5. Show all students");
							System.out.println("6. Logout");
							System.out.print("Enter your choice: ");
							choice2 = sc.nextInt();

							switch (choice2) {

							case 1: // add
								System.out.print("Enter your roll no: ");
								rollno = sc.next();
								System.out.print("Enter your name: ");
								name = sc.next();
								System.out.print("Enter your contact number: ");
								contact = sc.next();
								System.out.print("Enter your course: ");
								course = sc.next();
								StudentJDBCTemplate.addData(uid, rollno, name, contact, course);
								System.out.println("Data added successfuully");
								break;

							case 2: // delete
								System.out.print("Enter your roll no to delete : ");
								rollno = sc.next();

								stroll = StudentJDBCTemplate.getRoll(rollno);
								if (rollno.equals(stroll)) {
									StudentJDBCTemplate.deleteStudent(rollno);

								} else {
									System.out.println("Roll no is invalid !!");
								}
								break;

							case 3: // update
								System.out.print("Enter your roll no to update contact : ");
								rollno = sc.next();

								System.out.print("Enter your contact to update: ");
								contact = sc.next();

								stroll = StudentJDBCTemplate.getRoll(rollno);
								if (rollno.equals(stroll)) {
									StudentJDBCTemplate.updateStudent(rollno, contact);

								} else {
									System.out.println("Roll no is invalid !!");
								}
								break;

							case 4: // display
								System.out.print("Enter your roll no to show details : ");
								rollno = sc.next();

								stroll = StudentJDBCTemplate.getRoll(rollno);
								if (rollno.equals(stroll)) {
									Student = StudentJDBCTemplate.showStudentByRollNo(rollno);
									System.out.print("Student uid: " + Student.getUid());
									System.out.print(", rollno: " + Student.getRoll_no());
									System.out.print(", name: " + Student.getStudent_name());
									System.out.print(", contact no: " + Student.getStudent_contact());
									System.out.print(", course: " + Student.getStudent_course());
									System.out.println();
								} else {
									System.out.println("Roll no is invalid !!");
								}
								break;

							case 5: // display all

								List<Student> Students = StudentJDBCTemplate.showStudents();
								for (Student st : Students) {
									System.out.print("Student uid: " + st.getUid());
									System.out.print(", rollno: " + st.getRoll_no());
									System.out.print(", name: " + st.getStudent_name());
									System.out.print(", contact no: " + st.getStudent_contact());
									System.out.print(", course: " + st.getStudent_course());
									System.out.println();
								}
								break;

							case 6: // logout
								continue outer;
							}
						}

					} else {
						System.out.println("Incorrect password");
					}

				} else {
					System.out.println("Invalid user");
				}
				break;
			case 3:
				System.out.println("Thank You !!");
				System.exit(1);

			}

		}

	}

}
