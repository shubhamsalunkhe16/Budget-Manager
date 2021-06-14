<%@page import="com.dailyInEx.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sidenav</title>

</head>
<body>

<%User ulog=(User)session.getAttribute("ulog"); 
 %>
<div id="sidenav">
<h3><a href="index.jsp">Home</a></h3>
<h3><a href="aboutUs.jsp">About Us</a></h3>
<%if (ulog!=null){ %>
 
<h3><a href="addincome.jsp">Add Income</a></h3>
<h3><a href="ExpenseServlet">Add Expense</a></h3>
<h3><a href="IncomeServlet">Income List</a></h3>
<h3><a href="ExpenseServlet?action=getlist">Expense List</a></h3>
<h3><a href="UserServlet">Edit Profile</a></h3>
<h3><a href="LogOutServlet">LogOut</a></h3>


<%} else{%>

<h3><a href="adduser.jsp">Registeration</a></h3>
<h3><a href="login.jsp">LogIn</a></h3>


<%} %>



</div>

</body>
</html>