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


import com.gl.service.TeacherService;

import com.gl.to.Teacher;


@WebServlet("/teachercontrol")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService teacherService = new TeacherService();  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside Master Controller...");
        
        String action = request.getParameter("action");
        
        System.out.println(action);
        switch (action) {
        case "deleteTeacher":
        	HttpSession session = request.getSession();
            String name = request.getParameter("teacher");
            System.out.println("inside delete " + name);

            teacherService.removeTeacher(name);

            TeacherService teacherService = new TeacherService();
            List<Teacher> teachers = teacherService.getAllTeachers();
            session.setAttribute("teachers", teachers);


            RequestDispatcher dispatcher1 = request.getRequestDispatcher("AdminDashboard.jsp");
            dispatcher1.forward(request, response);
            break;
            
        	
        }

        }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
