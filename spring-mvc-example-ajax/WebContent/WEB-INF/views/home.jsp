<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">  
   function doAjaxPost() {  
	var name=document.getElementById('ff').value; 
    $.ajax({  
     type : "POST",   
     url : "${pageContext.request.contextPath}/home",   
     data : "name=" + name,  
     success : function(data) {  
      alert(data);   
     },  
     error : function(e) {  
      //alert('chaitanya: ' + e);   
     }  
    });  
   }  
  </script> 
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<form action="user" method="post">

		<form:select path="fruit" name="ff" id="ff">
			<form:option value="apple" label="Apple" />
			<form:option value="orange" label="Orange" />
			<input type="submit" value="Ajax call" onclick="doAjaxPost();">

		</form:select>
	</form>
</body>
</html>