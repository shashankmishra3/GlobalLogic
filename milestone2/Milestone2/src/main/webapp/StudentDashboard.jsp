<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.gl.to.Student, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
</head>

<%
List<Student> students = (List<Student>) session.getAttribute("students");
String username=(String) session.getAttribute("username");
%>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="StudentDashboard.jsp">Home</a></li>
				</ul>
				</li>
				<form action="user?action=logout" method="post">
					<li class="nav-item"><button>
							<a>Logout</a>
						</button></li>
				</form>

				</ul>

			</div>
		</div>
	</nav>
	
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
                <th scope="col">Update</th>
            </tr>
        </thead>
        <tbody>
            <%
  for(int i = 0; i < students.size(); i++) {
  %>
  				<%if(students.get(i).getName().equals(username)){ %>
            <tr>
                <th scope="row"><%= i+1 %></th>
                <td><%= students.get(i).getName() %></td>
                <td><%= students.get(i).getPassword() %></td>
                <td><%= students.get(i).getClassName() %></td>
                <td><%= students.get(i).getSection() %></td> 
                <td><%= students.get(i).getStudentRollNo() %></td> 
                <td><%= students.get(i).getRole() %></td> 
                <td><a href="studentcontrol?action=updateStudent&studentname=<%= students.get(i).getName() %>">update</a></td>
                
            </tr>
            <%} %>
            <%} %>
        </tbody>
    </table>
</body>
</html>