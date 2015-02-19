<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person info</title>
</head>
<body>
	<!--  <b>${person}</b>-->
	<b>id : </b>${person.id} <br> 
	<b>Name : </b>${person.name}<br>
	<b>Age : </b>${person.age}	<br>
	<b>Date : </b>${person.createDate}	<br>	
	<a href="person/edit?id=${person.id}">edit</a>	
	<a href="person/add">add</a>	
</body>
</html>