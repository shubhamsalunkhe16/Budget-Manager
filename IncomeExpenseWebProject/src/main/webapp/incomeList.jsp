<%@page import="com.dailyInEx.pojo.Income"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Income Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>
<%List<Income> inli= (List<Income>)session.getAttribute("incomeList");%>
<div id="container">

<%@include file="sidenav.jsp"  %>
<div id="main">
<h2 class="mb-4">All Income Information</h2>
<table class="table table-bordered table-striped table-hover" border="1" cellspacing="10">
	<tr class="table-dark">
		<td>Id</td>
		<td>Income</td>
		<td>Income Type</td>
		<td>Income Date</td>
		<td>Description</td>
		<td>UserId</td>
		<td colspan=2>Action</td>
	</tr>
	<%for(Income i:inli){ %>
	<tr>
		<td><%=i.getId() %></td>
		<td><%=i.getIncome() %></td>
		<td><%=i.getIncomeType() %></td>
		<td><%=i.getIncomeDate() %></td>
		<td><%=i.getDescription() %></td>
		<td><%=i.getUserId() %></td>
		<td><a href="IncomeServlet?action=edit&id=<%=i.getId() %>">Edit</a></td>
		<td><a href="IncomeServlet?action=delete&id=<%=i.getId() %>">Delete</a></td>
	</tr>
	<%} %>
</table>
</div>
</div>


</body>
</html>