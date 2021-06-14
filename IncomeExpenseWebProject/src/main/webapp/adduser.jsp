<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>
<div id="container">

<%@include file="sidenav.jsp"  %>
<div id="main">

<h2 class="mb-4">Registeration</h2>
<form action="UserServlet?action=register" method="post">
	<table class="table table-bordered" >
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="pass" /></td>
		</tr>
		<tr>
			<td>Confirm Password:</td>
			<td><input type="password" name="cpass" /></td>
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