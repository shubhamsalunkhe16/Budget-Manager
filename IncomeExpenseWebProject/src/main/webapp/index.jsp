
<%@page import="com.dailyInEx.dao.ExpenseDAO"%>
<%@page import="com.dailyInEx.dao.IncomeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
<div id="container">
<%@include file="sidenav.jsp"  %>
<% User ulog1=(User)session.getAttribute("ulog");
double income=0;
double expense=0;





%>
 <%if (ulog1!=null){
	 income= new IncomeDAO().getIncome(ulog1.getId());
	 expense= new ExpenseDAO().getExpense(ulog1.getId());
	 double totalBalance=income-expense;
	 
	 //response.sendRedirect("HomeServlet");
	 
/*IncomeDAO inc = new IncomeDAO();
ExpenseDAO exd= new ExpenseDAO();
double totalIncome=inc.getIncome(ulog1.getId());
double totalExpense=exd.getExpense(ulog1.getId());
session.setAttribute("totalinc", totalIncome);
session.setAttribute("totalEx", totalExpense);*/
//System.out.println(totalIncome+"  "+totalExpense);
}
%>
<div id="main">
<h2>Daily Income Expense Mangement Application</h2>
<%if (ulog1!=null){ %>
<table class="table table-bordered table-striped table-hover mt-4" style="text-align:center;">
	<tr class="table-dark">
		<td colspan=2 ><h4>Welcome <%=ulog.getEmail() %></h4></td>
		
	</tr>
	<tr>
		<td>Total Income</td>
		<td><%=income %></td>
	</tr>
	<tr>
		<td>Total Expense</td>
		<td><%=expense %> </td>
	</tr>
	<tr>
		<td>Total Balance</td>
		<td><%= income- expense%> </td>
	</tr>
</table>
<%} %>
</div>
</div>
</body>
</html>