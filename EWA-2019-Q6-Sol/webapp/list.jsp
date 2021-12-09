<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="student.Student"%>
<%@ page import="student.StudentRegister"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//UserBean user = new UserBean();
		StudentRegister stud = new StudentRegister();
		List<Student> userList = stud.getAllUsers();
		//Iterator<UserBean> itr = userList.iterator();
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Department</th>
		</tr>
		<tr>
			<%
				/*while(itr.hasNext())
				{
				System.out.println(user.getId());*/
				for (Student user : userList) {
			%>
			<td><%=user.getS_id()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getDepartment()%></td>
			<td><a
				href="StudentServlet?action=editform&userId=<%=user.getS_id()%>">Update</a></td>
			<td><a href="StudentServlet?action=delete&userId=<%=user.getS_id()%>">Delete</a></td>

		</tr>
		<%
			}
			//}
		%>
	</table>
	<p>
		<a href="StudentServlet?action=insert">Add User</a>
	</p>
</body>
</html>