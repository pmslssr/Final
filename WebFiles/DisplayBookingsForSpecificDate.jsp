<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div class="header"><h3>Hotel Management System</h3></div>
  <div class="page">
 <div class="form1">

	<h1>In update hotel</h1>
	<table border="1" class="trOfHotel">
		<form:form method="POST" modelAttribute="bookingsDto">
		<tr><h2>Booking Details </h2></tr>
			<tr>
				<th>Booking Id</th>
				<th>Hotel Id</th>
				<th>Room Id</th>
				<th>User Id</th>
				<th>Booking From</th>
				<th>Booking To</th>
				<th>No Of Adults</th>
				<th>No Of Children</th>
				<th>Amount</th>
			<tr>


				<c:forEach var="bookingsDto" items="${bookingsDto}">
					<tr>
						<td><c:out value="${bookingsDto.bookingId}" /></td>
						<td><c:out value="${bookingsDto.hotelId}" /></td>
						<td><c:out value="${bookingsDto.roomId}" /></td>
						<td><c:out value="${bookingsDto.userId}" /></td>
						<td><c:out value="${bookingsDto.bookingFrom}" /></td>
						<td><c:out value="${bookingsDto.bookingTo}" /></td>
						<td><c:out value="${bookingsDto.noOfAdults}" /></td>
						<td><c:out value="${bookingsDto.noOfChildren}" /></td>
						<td><c:out value="${bookingsDto.amount}" /></td>
						
				</c:forEach>
		</form:form>
	</table>
	<form action="adminHome">
		<input type="submit" value="Home" class="href1"/>
	</form>
</div></div>
	
</body>
</html>