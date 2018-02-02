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
 <div class="page">
 <div class="form1">
 <form:form action="addHotel" method="post">

<table border=1 class="trOfHotel">
<tr><h2>All Hotels</h2></tr>
<tr>
<th>Hotel Id</th>
<th>City</th>
<th>Hotel Name</th>
<th>Address</th>
<th>description</th>
<th>Average rate per night</th>
<th>Phone Number1</th>
<th>Phone Number2</th>
<th>Rating</th>
<th>Hotel Email</th>
<th>Hotel Fax</th>
<th colspan='2'>Operations</th>
</tr>
<c:forEach var="hotelList" items="${hotelList}">
<tr>
<td>
 <c:out value="${hotelList.hotelId}"/>
 </td>
 <td>
  <c:out value="${hotelList.city}"/>
  </td>
  <td>
  <c:out value="${hotelList.hotelName}"/>
  </td>
  <td>
  <c:out value="${hotelList.hotelAddress}"/>
  </td>
  <td>
  <c:out value="${hotelList.description}"/>
  </td>
  <td>
  <c:out value="${hotelList.avgRatePerNight}"/>
  </td>
  <td>
  <c:out value="${hotelList.phoneNo1}"/>
  </td>
  <td>
  <c:out value="${hotelList.phoneNo2}"/>
  </td>
  <td>
  <c:out value="${hotelList.rating}"/>
 
  </td>
  <td>
  <c:out value="${hotelList.hotelEmail}"/>
  </td>
  <td>
  <c:out value="${hotelList.fax}"/>
  </td>
  
  
  
  
  
  <td>
    <a href="deleteHotel?hId=${hotelList.hotelId}" class="href2">Delete</a>
   
    </td>
    <td>
    <a href="updateHotel?hId=${hotelList.hotelId}" class="href2">Update</a>
    </td>
  </tr>
 </c:forEach>
  



</table>
<input type="submit" value="Add Hotel" class="href1"/>
</form:form>

<form action="adminHome">
<input type="submit" value="Home" class="href1"/>
</form>
</div></div>

</body>
</html>