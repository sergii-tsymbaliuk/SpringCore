<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person info</title>
</head>
<body>
	<!--  <b>${person}</b>-->
	${test} <br>
	<b>id : </b>${person.id} <br> 
	<b>	<s:message code="name" /> : </b>${person.name}<br>
	<b> <s:message code="age" /> : </b>${person.age}	<br>
	<b>Date : </b>${person.createDate}	<br>	
	<a href='<c:url value="/person/edit?id=${person.id}"/>'>edit</a><br>	
	<a href='<c:url value="/person/add?"/>'"person/add">add</a>	
		
	<form action="delete?id=${person.id}" method="post">
		<input type="submit" value="DELETE">  	
	</form>	
</body>
</html>