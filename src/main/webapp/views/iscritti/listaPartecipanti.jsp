<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Participants</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body>
<c:if test="${not empty errore}">
	<div class="alert alert-danger" role="alert">
		${errore}
	</div>
</c:if>

<div class="container mt-5">
	<form action="${pageContext.request.contextPath}/iscritti/search" method="GET" class="mb-4 d-flex justify-content-end">
		<div class="input-group" style="width: 30%;">
            <input type="text" name="input" class="form-control form-control-sm" placeholder="Cerca per nome o cognome" required>
            <button type="submit" class="btn btn-primary">Cerca</button>
        </div>
	</form>
	<table  class="table-info table table-hover table-striped">
		<thead>
			<tr>
				<th>Organization name</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Role</th>
				<th>Telephone number</th>
				<th>Email</th>
				<th>Address</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="participant" items="${participants}">
			
				<tr>
					<td>${participant.getOrganizationName()}</td>
					<td>${participant.getName()}</td>
					<td>${participant.getSurname()}</td>
					<td>${participant.getRole()}</td>
					<td>${participant.getNumber()}</td>
					<td>${participant.getEmail()}</td>
					<td>${participant.getAddress()}</td>
					<td><a class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="${pageContext.request.contextPath}/iscritti/deleteParticipants/${participant.getId()}">Delete</a></td>
					<td><a  class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="${pageContext.request.contextPath}/iscritti/preUpdateParticipants/${participant.getId()}">Update</a></td>
				</tr>
			</c:forEach>
		
		
		
		
		</tbody>
	
	</table>
	<button class="btn btn-info"><a href="/admin/logout" style="text-decoration:none; color:white;">Logout</a></button>
	</div>
	 
</body>
</html>