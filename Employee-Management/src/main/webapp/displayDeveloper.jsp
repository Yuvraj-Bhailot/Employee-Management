<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Developer</title>
<link rel="stylesheet" href="style.css">
<style type="text/css">
table {
	width: 80%;
	background-color: beige;
	border: solid 2px;
}
tr {
	height: 35px;
}
th {
	background-color: orange;
}
td {
	padding: 0 10px;	
}
</style>
</head>
<body>

<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PASSWORD</th>
<th>PHONE NUMBER</th>
<th>SALARY</th>
<th>ROLE</th>
</tr>

<% 
ResultSet resultSet = (ResultSet)request.getAttribute("developerList"); 
while(resultSet.next()){
	int id = resultSet.getInt(1);
	String name = resultSet.getString(2);
	String email = resultSet.getString(3);
	String password = resultSet.getString(4);
	long phone = resultSet.getLong(5);
	double salary = resultSet.getDouble(6);
	String role = resultSet.getString(7);
	%>
	<tr>
	<td> <%= id %> </td>
	<td> <%= name %> </td>
	<td> <%= email %> </td>
	<td> <%= password %> </td>
	<td> <%= phone %> </td>
	<td> <%= salary %> </td>
	<td> <%= role %> </td>
	</tr>
	<%
	}
%>

</table>

</body>
</html>