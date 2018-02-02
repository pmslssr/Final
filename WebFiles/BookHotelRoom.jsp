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
<form:form action="insertIntoBooking" name = "frm" modelAttribute="room">
		<table border=1 class="trOfHotel">
			<tbody>
			
				<tr>
					<td>User Id</td>
					<td><form:input type="text" id="userId" path="userId" required="true"/></td>
					<form:errors path="userId"/></td>
				</tr>
				<tr>
					<td>Hotel Id</td>
					<td><form:input type="text" id="hotelId" path="hotelId" value = "${roomDto.hotelId }" readonly="true"/></td>
					<form:errors path="hotelId"/></td>
				</tr>
				<tr>
					<td>Room Id</td>
					<td><form:input type="text" id="roomId" path="roomId" value = "${roomDto.roomId }" readonly="true"/></td>
					<td><form:errors path="roomId"/></td>
				</tr>
				<tr>
					<td>Check In</td>
					<td><form:input type="date" id="myDate" path="bookingFrom" min="${minDate}" max="${maxDate}" required="true"/></td>
					<td><form:errors path="bookingFrom"/></td>
				</tr>
				<tr>
					<td>Check Out</td>
					<td><form:input type="date" id="myDate" path="bookingTo" min="${minDate}" max="${maxDate}" required="true"/></td>
					<td><form:errors path="bookingTo"/></td>
				</tr>
				<tr>    
                    <td>Number of Adults</td>
					<td><form:select path="noOfAdults">
							<form:option value="1" >1
							</form:option>
							<form:option value="2" >2
							</form:option>
							<form:option value="3" >3
							</form:option>
							<form:option value="4" >4
							</form:option>
							<form:option value="5" >5
							</form:option>
							<form:option value="6" >6
							</form:option>
					</form:select></td>
				</tr>
				<tr>    
                    <td>Number of Children</td>
					<td><form:select path="noOfChildren">
							<form:option value="0" >0
							</form:option>
							<form:option value="1" >1
							</form:option>
							<form:option value="2" >2
							</form:option>
							<form:option value="3" >3
							</form:option>
							<form:option value="4" >4
							</form:option>
							<form:option value="5" >5
							</form:option>
							<form:option value="6" >6
							</form:option>
					</form:select></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<button type="submit" name="btnsub">Book</button>
						<button type="reset" name="btnreset">Reset</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
	</div>
	</div>
</body>
</html>