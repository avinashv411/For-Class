<%@page import="com.assingment.test.dto.GeocodeResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google Maps Results</title>
<% GeocodeResponse geocodeResponse = (GeocodeResponse)request.getAttribute("GeoCodeData"); %>
</head>
<body>
	<fieldset>
	<legend>GeoCode Results</legend>
		<table border="1" width="100%">
			<tr>
				<th>Type</th>
				<th>Formatted Address</th>
				<th>Latitude</th>
				<th>Longitude</th>
			</tr>
			<tr>
				<td><%= geocodeResponse.getResult().getType() %></td>
				<td><%= geocodeResponse.getResult().getFormattedAddress() %></td>
				<td><%= geocodeResponse.getResult().getGeometry().getLocation().getLat() %></td>
				<td><%= geocodeResponse.getResult().getGeometry().getLocation().getLng() %></td>
				
			</tr>

		</table>
	</fieldset>
</body>
</html>