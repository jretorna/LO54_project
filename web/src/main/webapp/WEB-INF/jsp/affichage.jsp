<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<%=request.getContextPath()%>/css/style.css"  rel="stylesheet" />
</head>
<body>
	<h1>Concentrateur collecte de données</h1>
	<h2>${message}</h2>
	<h2>Dernière collecte</h2>
	
	<div id="configuration">
	
	
	<div id="filter">
		<h1>Filtrer</h1>
				<form action="/projet/app/concentrateur/filter" method="post">
				<table>
					<tr>
						<td>T°C Min</td>
						<td><input name="flt_tc_min" /></td>
					</tr>
					<tr>
						<td>T°C Max</td>
						<td><input name="flt_tc_max" /></td>
					</tr>
					
					<tr>
						<td>Date</td>
						<td><input name="flt_date_deb" /> et <input name="flt_date_fin" /></td>
					</tr>
					<tr>
						<td>Station</td>
						<td><input name="flt_station" /></td>
					</tr>
					
					<tr>
						<td>Area</td>
						<td><input name="flt_area" /></td>
					</tr>
					
					<tr>
						<td>Capteur</td>
						<td><input name="flt_capteur" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><button type="submit">Filtrer</button></td>
					</tr>
					
				</table>
				</form>
	</div>
	
	<div id="parameter">
		<h1>Paramètres</h1>
				<form action="/projet/app/concentrateur/param" method="post">
				<table>
					<tr>
						<td>T°C Min</td>
						<td><input name="pr_tc_min" /></td>
					</tr>
					<tr>
						<td>T°C Max</td>
						<td><input name="pr_tc_max" /></td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit">Parametrer</button></td>
					</tr>
				</table>
				</form>
	</div>
	
	
	
	<div id="releveTab">
	
	<h1><c:out value="${view}" /></h1>
	
	<table id="tableReleve">
	
	<tr id="t">
		<th>Area</th>
		<th>Station</th>
		<th>Sensor</th>
		<th>Temperature</th>
	</tr>
	
	<c:if test="${view == 1 }">
		
		<c:forEach items="${releves}" var="releve">
			<tr id="t">
				<td id="t"><c:out value="${releve.getAreaName()}" /></td>
				<td id="t"><c:out value="${releve.getStaLabel()}" /></td>
				<td id="t"><c:out value="${releve.getSensorName()}" /></td>
				<td id="t"><c:out value="${releve.getTempVal()}" /></td>
			</tr>
		</c:forEach>
	
	</c:if>
	
	<c:if test="${view == 2}">
		<c:forEach items="${releves}" var="releve">
			<tr id="t">
				<td id="t"><c:out value="${releve.getArea().getAreId()}" /></td>
				<%-- <td><c:out value="${releve.getStaLabel()}" /></td>
				<td><c:out value="${releve.getSensorName()}" /></td>
				<td><c:out value="${releve.getTempVal()}" /></td> --%>
			</tr>
		</c:forEach>
	</c:if>
	
	</table>
	
	
	</div>
	
	
	</div>
	
	
</body>
</html>