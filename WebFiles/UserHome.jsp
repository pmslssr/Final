<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div class="header"><h3>Hotel Management System</h3></div>
 <div class="login-page">
 <div class="form">

<a href="searchForHotels" class="href">Search Hotel Rooms</a><br>
<a href="bookHotelRooms" class="href">Book Hotel Rooms</a><br>
<a href="viewBookingDetails" class="href">View Booking Details</a><br>
<a href="Logout" class="href">Logout</a><br>
</div></div>
</body>
</html>