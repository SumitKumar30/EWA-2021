<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<form method="POST" action='StudentServlet' name="frmAddUser">
		<input type="hidden" name="action" value="insert" />
		<p>
			<b>Add New Record</b>
		</p>
		<table>
			<tr>
				<td>User ID</td>
				<td><input type="text" name="userId" /></td>
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
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="StudentServlet?action=listUser">View-All-Records</a>
	</p>
</body>
</html>