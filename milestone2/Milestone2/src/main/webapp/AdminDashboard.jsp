<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.gl.to.Student, com.gl.to.Teacher, com.gl.to.Admin, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
</head>
<%
List<Student> students = (List<Student>) session.getAttribute("students");
List<Teacher> teachers = (List<Teacher>) session.getAttribute("teachers");
List<Admin> admins = (List<Admin>) session.getAttribute("admins");
String username=(String) session.getAttribute("username");
%>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="AdminDashboard.jsp">Home</a></li>
						</ul></li>
						<form  action="user?action=logout" method="post">
						<li class="nav-item"><button><a>Logout</a></button></li>
						</form>
					
				</ul>
				
			</div>
		</div>
	</nav>


<h4>Admin Data : </h4>
    
    
    <table class="table">
        <thead>
            <tr>
            
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Password</th>
                <th scope="col">Admin ID</th>
                <th scope="col">Role</th>
            </tr>
        </thead>
        <tbody>
            <%
  for(int i = 0; i < admins.size(); i++) {
  %>
  	
  	<%if(admins.get(i).getName().equals(username)){ %>
            <tr>
                <th scope="row"><%= i+1 %></th>
                <td><%= admins.get(i).getName() %></td>
                <td><%= admins.get(i).getPassword() %></td>
                <td><%= admins.get(i).getAdminID() %></td>
                <td><%= admins.get(i).getRole() %></td>
            </tr>
            <%} %>
            <%} %>
        </tbody>
    </table>





<h4>Teachers Data : </h4>
    
    
    <table class="table">
        <thead>
            <tr>
            
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Password</th>
                <th scope="col">Teacher ID</th>
                <th scope="col">Subject</th>
                <th scope="col">Role</th>
                <th scope="col">Status</th>
                <th scope="col">Delete</th>
                <th scope="col">Update</th>
            </tr>
        </thead>
        <tbody>
            <%
  for(int i = 0; i < teachers.size(); i++) {
  %>
            <tr>
                <th scope="row"><%= i+1 %></th>
                <td><%= teachers.get(i).getName() %></td>
                <td><%= teachers.get(i).getPassword() %></td>
                <td><%= teachers.get(i).getTeacherID() %></td>
                <td><%= teachers.get(i).getSubject() %></td>
                <td><%= teachers.get(i).getRole() %></td>
                <td><%= teachers.get(i).getStatus() %></td>
                <td><a href="teachercontrol?action=deleteTeacher&teacher=<%= teachers.get(i).getName() %>">delete</a></td>
                <td><a href="teachercontrol?action=updateTeacher&teacher=<%= teachers.get(i).getName() %>">update</a></td>
                
            </tr>
            <%} %>
        </tbody>
    </table>
    
    <h4>Students Data : </h4>
    
    <table class="table">
        <thead>
            <tr>
            
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Password</th>
                <th scope="col">Class Name</th>
                <th scope="col">Section</th>
                <th scope="col">Student Roll Number</th>
                <th scope="col">Role</th>
                <th scope="col">Status</th>
                <th scope="col">Delete</th>
                <th scope="col">Update</th>
            </tr>
        </thead>
        <tbody>
            <%
  for(int i = 0; i < students.size(); i++) {
  %>
            <tr>
                <th scope="row"><%= i+1 %></th>
                <td><%= students.get(i).getName() %></td>
                <td><%= students.get(i).getPassword() %></td>
                <td><%= students.get(i).getClassName() %></td>
                <td><%= students.get(i).getSection() %></td> 
                <td><%= students.get(i).getStudentRollNo() %></td> 
                <td><%= students.get(i).getRole() %></td> 
                <td><%= students.get(i).getStatus() %></td> 
                <td><a href="studentcontrol?action=deleteStudent&studentname=<%= students.get(i).getName() %>">delete</a></td>
                <td><a href="studentcontrol?action=updateStudent&studentname=<%= students.get(i).getName() %>">update</a></td>
                
            </tr>
            <%} %>
        </tbody>
    </table>
</body>
</html>