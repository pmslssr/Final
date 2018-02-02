<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div class="header"><h3>Hotel Management System</h3></div>
 <div class="page9">
 <div class="form9">
<form:form   modelAttribute="bookingsDto"   action="displayBookingDetails">
<tr><h2>Search  Bookings Details</h2></tr>
<tr>
<td><h3>Enter Booking Id :</h3><form:input path="bookingId" name="bookingId"/>
</td>
</tr>
<tr>
<td><input type="submit" value="Find" class="href1"/>
</td></tr>


</form:form>
	<form action="userHome">
		<input type="submit" value="Back" class="href1"/>
	</form>
</div></div>

</body>
</html>