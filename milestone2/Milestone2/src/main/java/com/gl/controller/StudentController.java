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

import com.gl.service.StudentService;

import com.gl.to.Student;


@WebServlet("/studentcontrol")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentService studentService = new StudentService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside Master Controller...");

        

        String action = request.getParameter("action");
        
        System.out.println(action);
        switch (action) {
            
        case "deleteStudent":
        	HttpSession session1 = request.getSession();
            String studentname = request.getParameter("studentname");
            System.out.println("inside delete " + studentname);

            studentService.removeStudent(studentname);

            StudentService studentService = new StudentService();
            List<Student> students = studentService.getAllStudents();
            session1.setAttribute("students", students);


            RequestDispatcher dispatcher2 = request.getRequestDispatcher("AdminDashboard.jsp");
            dispatcher2.forward(request, response);
            break;
            
        case "updateStudent":
        	String updatingUser = request.getParameter("studentname");

//			Student user1 = studentService.findByStudentName(updatingUser);
//
//			request.setAttribute("updatingUser", user1);
			
			
			

			RequestDispatcher dispatcher1 = request.getRequestDispatcher("StudentUpdate.jsp");
			dispatcher1.include(request, response);
			break;
        	
        }

	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			switch (action) {
			
			}
	}

}
