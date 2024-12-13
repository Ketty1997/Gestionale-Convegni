<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/login.css" />
</head>
<body>
	  
	
	<div class="login-box">
		<form action="/admin/login" method="POST">
			  <div class="user-box">
				  <input type="email" name="emailAdmin" required/>
				  <label for="email">Email</label>
			 </div>
			 <div class="user-box">
				<input type="password" name="password" required />
				<label for="password">Password</label>
			</div>
			<div class="d-flex justify-content-center">
			<button id="button" class="btn text-center" type="submit">Login</button>
			</div>
		</form>
		<c:if test="${not empty errore}">
        <p style="color: red; text-align: center; margin-top:15px;">${errore}</p>
    	</c:if>
		</div>

  
	

</body>
</html>