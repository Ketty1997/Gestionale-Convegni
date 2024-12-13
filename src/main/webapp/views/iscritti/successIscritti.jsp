<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iscrizione avvenuta con successo</title>
<link rel="stylesheet" href="/css/successGeneral.css" />
</head>
<body>
	
<div class='content'>
  <div class='symbol'>
  	<img src="/img/check2.jpg">
  </div>
  <div class='title'>Grazie</div>
  <div class='text'>Abbiamo ricevuto la tua iscrizione!</div>
   <a id="buttonIscrizione" href="${pageContext.request.contextPath}/iscritti/preUpdateParticipants/${participantId}">
        Vedi la tua iscrizione
    </a>
</div>
	  
   
</body>
</html>