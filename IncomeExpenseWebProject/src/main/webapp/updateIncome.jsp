<%@page import="com.dailyInEx.pojo.Income"%>
<%@page import="com.dailyInEx.pojo.User"%>
<%@page import="com.dailyInEx.dao.UserDAO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Income</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>

<%Income  in1 = (Income )session.getAttribute("incObj"); 
List<User> ulist=new UserDAO().getUserEmailList();
%>

<div id="container">

<%@include file="sidenav.jsp"  %>
<div id="main">
<h2 class="mb-4">Update Income</h2>
<form action="IncomeServlet?action=editForm" method="post">
	<table class="table table-bordered" border="1">
	<tr>
		<td>Id</td>
		<td> <input type="number" name="id" value="<%=in1.getId() %>"></td>
	</tr>
		<tr>
			<td>Income</td>
			<td><input type="number" name="income"  value="<%=in1.getIncome() %>"/></td>
		</tr>
		<tr>
			<td>Income Type:</td>
			<td><select name="incomeType">
			<option value="<%=in1.getIncomeType() %>"><%=in1.getIncomeType() %></option>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
			<option value="D">D</option>
			<option value="E">E</option></select></td>
		</tr>
		<tr>
			<td>Date:</td>
			<td><input type="date" name="incomeDate" value="<%=in1.getIncomeDate() %>"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><textarea  cols="30" rows="3"  name="description"><%=in1.getDescription() %></textarea></td>
		</tr>
		
		<tr>
			<td>User Name:</td>
			<td><select name="uid" >
				 <option value="">----SELECT----</option> 
				<%
				for(User i : ulist){
				%>
				<option value="<%=i.getId() %>"><%=i.getEmail() %></option>
				<%} %>
			</select></td>
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