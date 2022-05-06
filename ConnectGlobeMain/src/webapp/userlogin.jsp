<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<form action =".../userlogin" method="POST" modelAttribute="UserLogin">
<input type="text" name="user_id"/>
<input type="password" name="password"/>
<input type="submit" value="Login"/>
</form>
</body>
</html>