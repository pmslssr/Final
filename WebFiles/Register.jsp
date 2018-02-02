<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet"
	type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h3>Hotel Management System</h3>
	</div>
	<div class="page1">
		<div class="form2">
			<table border=1 class="trOfHotel">
				<form:form modelAttribute="user" action="addUserData">
					<h2>Register</h2>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" name="firstName" /> <form:errors
								path="firstName" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" name="lastName" /> <form:errors
								path="lastName" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>User Name:</td>
						<td><form:input path="userName" name="userName" /> <form:errors
								path="userName" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input type="password" path="password" name="password" /> <form:errors
								path="password" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Email ID</td>
						<td><form:input path="email" name="email" /> <form:errors
								path="email" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Mobile Number</td>
						<td><form:input path="mobileNo" name="mobileNo" /> <form:errors
								path="mobileNo" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td>Alternate Mobile Number</td>
						<td><form:input path="phone" name="phone" /> <form:errors
								path="phone" cssStyle="color:red" /></td>
					</tr>

					<tr>
						<td>Address</td>
						<td><form:textarea path="address" name="address" /> <form:errors
								path="address" cssStyle="color:red" /></td>
					</tr>


					<tr>
						<td>Role:</td>
						<td><form:select path="role" required="true">
								<form:option value="" label="----Please select----" />
								<form:options items="${userList }" />
							</form:select> <form:errors path="role" cssStyle="color:red" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register" class="href" /></td>
						<td><input type="reset" value="Reset" class="href" /></td>
					</tr>
				</form:form>
			</table>
			<form action="login">
				<input type="submit" value="Back" class="href1" />
			</form>
			

		</div>
	</div>
</body>
</html>