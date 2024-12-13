<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/inserisci.css" />
</head>
<body>
<c:if test="${not empty errori}">
    <div class="alert-danger alert">
        <ul>
            <c:forEach var="errore" items="${errori}">
                <li>${errore}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<div class="login-page">
<div class="form">
	<f:form class="login-form" modelAttribute="insertForm" method="post" action="insertParticipants">
		<f:input path="organizationName" placeholder="Nome dell'organizzazione"/>
		<f:input path="name" placeholder="Nome"/>
		<f:input path="surname" placeholder="Cognome"/>
		<f:input path="role" placeholder="Ruolo"/>
		<f:input path="number" placeholder="Numero"/>
		<f:input path="email" placeholder="E-mail"/>
		<f:input path="address" placeholder="Indirizzo"/>
	
		<input id="button" type="submit" value="Iscriviti">
	</f:form>
</div>
</div>

	
</body>
</html>