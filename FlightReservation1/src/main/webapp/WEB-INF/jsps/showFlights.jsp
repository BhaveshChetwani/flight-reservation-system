<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/format" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights</title>
</head>
<body>
	<h2>Check flights</h2>
	<form action="showFlight" method="post">
	<input type="text" name="from" title="From" />
	<input type="text" name="to" title="To" />
	<input type="date" name="depDate" title="On" />
	<input type="submit" value="Check Flights">
	</form>
	<table>
		<c:forEach items="${flightList }" var="flights">
			<tr>
			<td><a href="showFlight?depCity=${flight.depCity }">${flights.depCity }</a></td>
			<td><a href="showFlight?arrCity=${flight.arrCity }">${flights.arrCity }</a></td>
			<td><a href="showFlight?depDate=${fn:substring(flight.dateOfDeparture, 0, 9) }">${fn:substring(flights.dateOfDeparture,0,9) }</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>