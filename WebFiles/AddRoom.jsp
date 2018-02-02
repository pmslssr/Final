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
	<div class="page1">
 <div class="form2">
	<table border=1 class="trOfHotel">
		<form:form method="post" modelAttribute="addRoom" action="addRoomData">
		<tr><h2>Add Room</h2></tr>
	<form:hidden path="hotelId" name="hotelId" value="${hotelId}"/>
	
	
			<tr>
				<td>Room Type</td>
				<td><form:input path="roomType" name="roomType" />
				<form:errors
						path="roomType" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>PER NIGHT RATE</td>
				<td><form:input path="perNightRate" name="perNightRate" />
				<form:errors
						path="perNightRate" cssStyle="color:red" /></td>
			</tr>
			<form:hidden path="availability" name="availability" value="1"/>
			
			<tr>
				<td><input type="reset" value="Reset" class="href"/></td>
				<td><input type="submit" value="Add Room" class="href"/></td>
			</tr>
		</form:form>
	</table>
	</div></div>
	
	
	
</body>
</html>