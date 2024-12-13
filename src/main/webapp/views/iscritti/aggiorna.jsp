<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiorna</title>
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
	<f:form class="login-form" modelAttribute="updateForm" method="post" action="/iscritti/updateParticipants">
		<f:input path="id" type="hidden"/>
		<f:label class="text-label" path="organizationName">Nome dell'organizzazione</f:label>
		<f:input path="organizationName"/>
		<f:label class="text-label" path="name">Nome</f:label>
		<f:input path="name"/>
		<f:label class="text-label" path="surname">Cognome</f:label>
		<f:input path="surname"/>
		<f:label class="text-label" path="role">Ruolo</f:label>
		<f:input path="role"/>
		<f:label class="text-label" path="number">Numero di telefono</f:label>
		<f:input path="number"/>
		<f:label class="text-label" path="email">E-mail</f:label>
		<f:input path="email"/>
		<f:label class="text-label" path="address">Indirizzo</f:label>
		<f:input path="address"/>
		<br><br>
		<input id="buttonAgg" type="submit" value="Aggiorna">
		<a id="buttonDelete" href="${pageContext.request.contextPath}/iscritti/deleteParticipants/${updateForm.id}">Elimina</a>
		<br>
		<a id="buttonHome" href ="/iscritti/preInsertParticipants">Torna alla pagina di iscrizione</a>
	
	</f:form>
</div>
</div>
	
	<!-- ${pageContext.request.contextPath}: Questo assicura che l'URL inizi sempre dal contesto dell'applicazione, indipendentemente da dove ti trovi nella gerarchia delle pagine. -->
</body>
</html>