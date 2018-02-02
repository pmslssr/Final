<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div class="header"><h3>Hotel Management System</h3></div>
 <div class="page4">
 <div class="form5">
<h2>  BookingSuccess </h2><br><br>

<h3>Your Booking Id : ${booked}</h3>

	<form action="userHome">
		<input type="submit" value="Home" class="href1"/>
	</form>
</div></div>
</body>
</html>