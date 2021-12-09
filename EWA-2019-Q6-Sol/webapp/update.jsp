<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="student.Student"%>
<%@ page import="student.StudentRegister"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Record</title>
</head>
<body>
	<%
		Student user = new Student();
	%>
	<%
		StudentRegister student = new StudentRegister();
	%>
	<form method="POST" action='StudentServlet' name="frmEditUser">
		<input type="hidden" name="action" value="edit" />
		<%
			String uid = request.getParameter("userId");
			if (!((uid) == null)) {
				int id = Integer.parseInt(uid);
				user = student.getUserById(id);
		%>
		<table>
			<tr>
				<td>User ID</td>
				<td><input type="text" name="userId" readonly="readonly"
					value="<%=user.getS_id()%>"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="Name" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><input type="text" name="Department" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
		<%
} else
out.println("ID Not Found");
%>
	</form>
</body>
</html>