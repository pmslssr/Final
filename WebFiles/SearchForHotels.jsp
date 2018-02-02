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
<form:form action="viewAllHotelsByCity" name = "frm" modelAttribute="hotelInfo">
		<table border=1 class="trOfHotel" align="center">
			<tbody>
				<tr>
					<td>City</td>
					<td><form:select id="city" path="city" required="true">
							<form:option value="">--Please Select--</form:option>
							<form:options items="${cityList}" />
					</form:select></td>
					<td><form:errors path="city"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<button type="submit" name="btnsub">Submit</button>
						<button type="reset" name="btnreset">Reset</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
	<form action="userHome">
		<input type="submit" value="Back" class="href1"/>
	</form>
	</div>
	</div>
</body>
</html>