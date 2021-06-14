<%@page import="com.dailyInEx.pojo.Expense"%>
<%@page import="com.dailyInEx.pojo.User"%>
<%@page import="com.dailyInEx.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>

<%List<User> ul =(List<User>) session.getAttribute("ulist");

Expense ex =(Expense) session.getAttribute("expObj");
%>

<div id="container">

<%@include file="sidenav.jsp"  %>
<div id="main">
<h2 class="mb-4">Update Expense</h2>
<form action="ExpenseServlet?action=editForm"  method="post">
	<table class="table table-bordered" border="1">
	<tr>
		<td>Id:</td>
		<td> <input type="number" name="id" value="<%=ex.getId()%>"></td>
	</tr>
		<tr>
			<td>Expense:</td>
			<td><input type="number" name="expense" value="<%=ex.getExpense() %>" /></td>
		</tr>
		<tr>
			<td>Expense Type:</td>
			<td><select name="expenseType">
			<option ><%=ex.getExpenseType() %></option>
			<option >A</option>
			<option >B</option>
			<option >C</option>
			<option >D</option>
			<option >E</option></select></td>
		</tr>
		<tr>
			<td>Expense Date:</td>
			<td><input type="date" name="expenseDate" value="<%=ex.getExpenseDate() %>" /></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><textarea  cols="30" rows="3"  name="description" ><%=ex.getDescription() %></textarea></td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td>  <select name="uid">
			<option value="">---SELECT---</option>
			<%for(User i: ul ){ %>
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