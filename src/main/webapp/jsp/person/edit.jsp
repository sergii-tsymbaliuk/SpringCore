<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action='<c:url value="/person/edit?id=${person.id}"/>' method="post">
	<s:message code="name" /> : <input name="name" value ="${person.name}"> </input><br>
  	<s:message code="age" /> : <input name="age" value ="${person.age}"> </input> <br>
  	<s:message code="login" /> : <input name="login" value ="${person.login}"> </input> <br>
  	<s:message code="password" /> : <input name="password" value ="${person.password}"> </input> <br>
<%--   	<s:message code="roles" /> : <input name="roles" value ="${person.roles}"> </input> <br>  	  	  	 --%>
	<input type="submit" name="save">  	
</form>
</body>
</html>