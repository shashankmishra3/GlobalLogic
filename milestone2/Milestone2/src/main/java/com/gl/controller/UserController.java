package com.gl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gl.service.AdminService;
import com.gl.service.StudentService;
import com.gl.service.TeacherService;

import com.gl.to.Admin;
import com.gl.to.Student;
import com.gl.to.Teacher;


@WebServlet("/user")
public class UserController extends HttpServlet {

	StudentService studentService = new StudentService();
	TeacherService teacherService = new TeacherService();
	AdminService adminService = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		Student student = null;
		Teacher teacher = null;
		Admin admin = null;

		RequestDispatcher dispatcher = null;

		switch (action) {
		case "register":
			// register for student
			if (role.equalsIgnoreCase("0")) {
//				name, password,  className, section, studentRollNo,  role
				String className = request.getParameter("className");
				String section = request.getParameter("section");
				String studentRollNo = request.getParameter("studentRollNo");
				System.out.println(username + ", " + password + ", " + className + ", " + section + ", " + studentRollNo
						+ ", " + role);
				student = new Student(username, password, className, section, studentRollNo, role, "block");
				studentService.register(student);
				request.setAttribute("register_success", "Your details have been taken successfully");
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}

			// register for teacher
			else if (role.equalsIgnoreCase("1")) {
//				name, password,  teacherID, subject, role
				String teacherID = request.getParameter("teacherID");
				String subject = request.getParameter("subject");
				System.out.println(username + ", " + password + ", " + teacherID + ", " + subject + ", " + role);
				teacher = new Teacher(username, password, teacherID, subject, role, "block");
				teacherService.register(teacher);
				request.setAttribute("register_success", "Your details have been taken successfully");
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			}
			
			//register for admin
			else {
//				name, password, adminID,  role
				String adminID = request.getParameter("adminID");
				System.out.println(username + ", " + password + ", " + adminID + ", " + role);
				admin = new Admin(username, password, adminID, role);
				adminService.register(admin);
				request.setAttribute("register_success", "Your details have been taken successfully");
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}



			break;

		case "login":

			System.out.println(username + ", " + password + ", " + role);

			// login for student
			if (role.equalsIgnoreCase("0")) {
				student = studentService.login(username, password);
				if (student != null) {
					HttpSession session = request.getSession();
	                
	                StudentService studentService = new StudentService();
	                List<Student> students =  studentService.getAllStudents();
	                
	                session.setAttribute("username", username);
	                session.setAttribute("role", role);
	                session.setAttribute("students", students);
	                
					dispatcher = request.getRequestDispatcher("StudentDashboard.jsp");
					dispatcher.forward(request, response);
				} else {

					request.setAttribute("errorMessage", "Wrong Credentials, please try again!!");

					dispatcher = request.getRequestDispatcher("index.jsp");

					dispatcher.forward(request, response);
				}

			}

			// login for teacher
			else if (role.equalsIgnoreCase("1")) {
				teacher = teacherService.login(username, password);
				if (teacher != null) {
					
					HttpSession session = request.getSession();
	                
	                StudentService studentService = new StudentService();
	                List<Student> students =  studentService.getAllStudents();
	                
	                TeacherService teacherService = new TeacherService();
	                List<Teacher> teachers = teacherService.getAllTeachers();
	                
	                session.setAttribute("username", username);
	                session.setAttribute("role", role);
	                session.setAttribute("students", students);
	                session.setAttribute("teachers", teachers);
					
					dispatcher = request.getRequestDispatcher("TeacherDashboard.jsp");
					dispatcher.forward(request, response);
				} else {

					request.setAttribute("errorMessage", "Wrong Credentials, please try again!!");

					dispatcher = request.getRequestDispatcher("index.jsp");

					dispatcher.forward(request, response);
				}

			}

			// login for admin
			else if (role.equalsIgnoreCase("2")) {

				admin = adminService.login(username, password);
				if (admin != null) {
					HttpSession session = request.getSession();
	                
//	                dispatcher = request.getRequestDispatcher("welcome.jsp");
	                
	                StudentService studentService = new StudentService();
	                List<Student> students =  studentService.getAllStudents();
	                
	                TeacherService teacherService = new TeacherService();
	                List<Teacher> teachers = teacherService.getAllTeachers();
	                
	                AdminService adminService = new AdminService();
	                List<Admin> admins = adminService.getAllAdmin();
	                
	                session.setAttribute("username", username);
	                session.setAttribute("role", role);
	                session.setAttribute("students", students);
	                session.setAttribute("teachers", teachers);
	                session.setAttribute("admins", admins);
					dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
					dispatcher.forward(request, response);
				} else {

					request.setAttribute("errorMessage", "Wrong Credentials, please try again!!");

					dispatcher = request.getRequestDispatcher("index.jsp");

					dispatcher.forward(request, response);
				}
			}

			else {

				request.setAttribute("errorMessage", "Wrong Credentials, please try again!!");

				dispatcher = request.getRequestDispatcher("index.jsp");

				dispatcher.forward(request, response);
			}
			break;
		case "logout":
			request.setAttribute("logoutMsg", "You have been Logout Successfully");

			dispatcher = request.getRequestDispatcher("index.jsp");

			dispatcher.forward(request, response);
		default:
			break;
		}

	}

}