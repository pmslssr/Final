<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>HOTEL ROOMS</title>
</head>
<body>
<div class="header"><h3>Hotel Management System</h3></div>
 <div class="page3">
 <div class="form4">
	<table border=1 class="trOfHotel">
	<tr><h2>All Rooms in Hotel ${hotelId}</h2></tr>
		<tr>
			<th>Hotel Id</th>
			<th>Room Id</th>
			<th>Room Type</th>
			<th>rate per night</th>
			<th>Availability</th>
			<th colspan='2'>Operations</th>
		</tr>
		<c:forEach var="hotelRoomList" items="${bookHotel}">
			<tr>
				<td><c:out value="${hotelRoomList.hotelId}" /></td>
				<td><c:out value="${hotelRoomList.roomId}" /></td>
				<td><c:out value="${hotelRoomList.roomType}" /></td>
				<td><c:out value="${hotelRoomList.perNightRate}" /></td>
				
				<td><c:out value="${hotelRoomList.availability}" /></td>
				



				<c:if test="${hotelRoomList.availability ne 0}" >
				<td><a
					href="bookHotelRoom?hId=${hotelRoomList.hotelId}&rId=${hotelRoomList.roomId}" class="href2">Book</a>
				</c:if>
				</td>
			</tr>

		</c:forEach>

	</table>
	
	<form action="roomManagement">
		<input type="submit" value="Back" class="href1"/>
	</form>
	<form action="home">
		<input type="submit" value="Home" class="href1"/>
	</form>
	</div></div>
	

</body>
</html>