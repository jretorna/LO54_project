<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<h1>Concentrateur collecte de données</h1>
	<h2>${message}</h2>
	<h2>Dernière collecte</h2>
	<ul>
		
	</ul>
	<table>
		<tr>
			<th>Area</th>
			<th>Station</th>
			<th>Sensor</th>
			<th>Temperature</th>
		</tr>
		<c:forEach items="${releves}" var="releve">
			<tr>
				<td><c:out value="${releve.areaName}" /></td>
				<td><c:out value="${releve.staLabel}" /></td>
				<td><c:out value="${releve.sensorName}" /></td>
				<td><c:out value="${releve.tempVal}" /></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>