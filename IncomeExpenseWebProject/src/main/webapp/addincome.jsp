<%@page import="com.dailyInEx.pojo.User"%>
<%@page import="com.dailyInEx.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Income</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>
<%List<User> ulist=new UserDAO().getUserEmailList(); 
User ulog1=(User)session.getAttribute("ulog");
%>
<div id="container">

<%@include file="sidenav.jsp"  %>
<div id="main">
<h2 class="mb-4">Add Income</h2>
<form action="IncomeServlet" method="post">
	<table class="table table-bordered" border="1">
		<tr>
			<td>Income:</td>
			<td><input type="number" name="income" /></td>
		</tr>
		<tr>
			<td>Income Type:</td>
			<td><select name="incomeType">
			<option value="a">A</option>
			<option value="b">B</option>
			<option value="c">C</option>
			<option value="d">D</option>
			<option value="e">E</option></select></td>
		</tr>
		<tr>
			<td>Date:</td>
			<td><input type="date" name="incomeDate" /></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><textarea  cols="30" rows="3"  name="description"></textarea></td>
		</tr>
		
		<tr>
			<td>User Name:</td>
			<td><input type="text"  value="<%=ulog1.getEmail() %>"></td>
			<input type="hidden" name="uid" value="<%=ulog1.getId() %>" />
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" class="btn btn-primary"/>&nbsp;&nbsp;<input type="reset" class="btn btn-primary"  /></td>
		</tr>
	</table>
</form>

</div>
</div>
</body>
</html>