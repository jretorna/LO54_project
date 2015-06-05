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
	<h1><c:out value="${view}" /></h1>
	<table>
	<tr>
		<th>Area</th>
		<th>Station</th>
		<th>Sensor</th>
		<th>Temperature</th>
	</tr>
	
	<c:if test="${view == 1 }">
		
		<c:forEach items="${releves}" var="releve">
			<tr>
				<td><c:out value="${releve.getAreaName()}" /></td>
				<td><c:out value="${releve.getStaLabel()}" /></td>
				<td><c:out value="${releve.getSensorName()}" /></td>
				<td><c:out value="${releve.getTempVal()}" /></td>
			</tr>
		</c:forEach>
	
	</c:if>
	
	<c:if test="${view == 2}">
		<c:forEach items="${releves}" var="releve">
			<tr>
				<td><c:out value="${releve.getArea().getAreId()}" /></td>
				<%-- <td><c:out value="${releve.getStaLabel()}" /></td>
				<td><c:out value="${releve.getSensorName()}" /></td>
				<td><c:out value="${releve.getTempVal()}" /></td> --%>
			</tr>
		</c:forEach>
	</c:if>
	
	</table>
	
</body>
</html>