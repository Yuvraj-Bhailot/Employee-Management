<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Details</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<form action="updateDeveloper" method="post">
<fieldset>
<legend> <h2>Update Developer Details</h2> </legend>

ENTER EMPLOYEE ID: <input type="number" name="id"> <br> <br>

<%
String option = request.getParameter("option");
HttpSession formSession = request.getSession();
formSession.setAttribute("option", option);

if(option.equals("updateName")){
%>	
ENTER NEW NAME: <input type="text" name="name"> <br> <br>
<% 
} else if(option.equals("updateEmail")){
%>	
ENTER NEW EMAIL: <input type="text" name="email"> <br> <br>
<% 
} else if(option.equals("updatePhone")){
%>		
ENTER NEW PHONE NUMBER: <input type="tel" name="phone"> <br> <br>
<%
}

%>

<input type="submit" value="Update" class="button"> <br><br>  

</fieldset>
</form>

</body>
</html>