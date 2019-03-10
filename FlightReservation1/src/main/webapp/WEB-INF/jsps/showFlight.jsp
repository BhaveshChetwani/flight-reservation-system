<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Flight</title>
</head>
<body>
		<c:if test="${flight ne null }">
			<table>
				<tr>
					<td>Flight number</td>
					<td>${flight.id}</td>

				</tr>
				<tr>
					<td>Airlines</td>
					<td>${flight.operatingAirlines }</td>
				</tr>
				<tr>
					<td>From</td>
					<td>${flight.depCity }</td>
				</tr>
				<tr>
					<td>To</td>
					<td>${flight.arrCity }</td>
				</tr>
				<tr>
					<td>Departure Time</td>
					<td>${flight.estDepTime }</td>
				</tr>
				<tr>
					<td colspan=2><a href="bookFlight?id=${flight.id }"><button>Book this flight</button></a></td>
			</table>
		</c:if>
</body>
</html>