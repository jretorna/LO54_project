<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/projet/app/concentrateur/upreleve" enctype="multipart/form-data">
	
		Fichier : <input type="file" name="file"/>
		<!-- Area Name <input name="areaName" type="text"/>
		Area ID <input name="areaId" type="text"/>
		Sensor <input name="sensorName" type="text"/>
		S Id <input name="sensorIDe" type="text"/>
		Temp <input name="tempVal" type="text"/> -->
		
		<input type="submit" value="Upload">
	</form>
</body>
</html>