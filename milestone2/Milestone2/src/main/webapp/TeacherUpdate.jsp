<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Updation Form</title>
</head>
<body>

<center>
<h1>Teacher Updation Form</h1>
<form action="teachercontrol?action=updateTeacher" method="post">
	<label>Username</label>
	<input type="text" name="username" value="<%= request.getParameter("username") %>" readonly="readonly"><br><br>
	<label>Password</label>
	<input type="password" name="password"><br><br>
	<label>Teacher ID</label>
	<input type="text" name="teacherID"><br><br>
	<label>Subject</label>
	<input type="text" name="subject"><br><br>
	
	<input type="radio" name="role" value=1>
	<label for="teacher">Teacher</label>
	<br><br>
	
	
	<br><button>Update</button>
	
</form>
</center>

</body>
</html>