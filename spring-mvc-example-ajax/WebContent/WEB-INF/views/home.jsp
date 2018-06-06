<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<form action="user" method="post">

		Username:<input type="text" name="username"/><br>
		Password:<input type="password" name="password"><br> 
			<input type="submit" value="Ajax call">

		
	</form>
</body>
</html>