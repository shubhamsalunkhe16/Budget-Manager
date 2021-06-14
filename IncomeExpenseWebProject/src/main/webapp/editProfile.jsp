<%@page import="com.dailyInEx.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>
<div id="container">

<%
User ulog2=(User)session.getAttribute("ulog");
User allData =(User)session.getAttribute("allData");

 %>

<%@include file="sidenav.jsp"  %>
<div id="main">
<h2 class="mb-4">Edit Profile</h2>
<form action="UserServlet?action=edit" method="post">
<input type="hidden" name="id" value="<%=ulog2.getId() %>" />
	<table class="table table-bordered" border="1">
	
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="fname" value="<%=allData.getFname()%>"/></td>
				
		</tr>
		
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lname" value="<%=allData.getLname()%>"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" value="<%=allData.getEmail()%>" readonly/></td>
		</tr>
		<tr>
			<td>Contact:</td>
			<td><input type="number" name="contact" value="<%=allData.getContact()%>"/></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><select name="gender">
			<option value="<%=allData.getGender()%>"><%=allData.getGender()%></option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
			</select></td>
		</tr>
		<tr>
			<td>Age:</td>
			<td><input type="number" name="age" value="<%=allData.getAge()%>"/></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><textarea  cols="30" rows="3"  name="address" ><%=allData.getAddress()%></textarea></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Update" class="btn btn-primary"/></td>
		</tr>
	</table>
</form>

</div>
</div>

</body>
</html>