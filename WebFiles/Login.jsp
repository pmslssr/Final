<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<div class="heading"><h3>Welcome To Hotel Management System</h3></div>
	<div class="login-page">
  <div class="form">


			<form:form method="post" modelAttribute="login"
				action="validateLogin" class="login-form">

				<p class="login">
				<h2>Login Page</h2>
				</p>
				<form:input type="text" placeholder="userName" path="userName"
					id="input" />
				<form:errors path="userName" cssStyle="color:red" />

				<form:input type="password" placeholder="password" path="password"
					id="input" />
				<form:errors path="password" cssStyle="color:red" />

				<input type="submit" value="login" class="button"><br>
				<a href="Register">New to this Site?...Register Now</a>

			</form:form>

		</div>
</div>
</body>
</html>