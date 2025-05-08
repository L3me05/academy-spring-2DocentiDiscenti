<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Corsi</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/corso-list.css">
</head>
<body>

<nav class="navbar">
    <div class="navbar-container">
        <a class="navbar-brand" href="<c:url value='/home'/>">Gestione Corsi</a>
        <div class="navbar-links">
            <a href="<c:url value='/home'/>">Home</a>
            <a href="<c:url value='/discenti/list'/>">Lista Discenti</a>
            <a href="<c:url value='/docenti/lista'/>">Lista Docenti</a>
            <a href="<c:url value='/corsi/list'/>">Lista Corsi</a>
            <a href="<c:url value='/corsi/new'/>">Nuovo Corso</a>
        </div>
    </div>
</nav>

<div class="container">


    <div class="card-container">
        <c:forEach var="corso" items="${corsi}">
            <div class="card">
                <div class="corso">${corso.id} ${corso.nome} ${corso.annoAccademico}</div>
                <div class="docente">
                    <c:if test="${not empty corso.docente}">
                        <h5>Docente:<br></h5>
                        ${corso.docente.nome} ${corso.docente.cognome}
                    </c:if>
                </div>
                <div class="studenti">
                    <h5>Partecipanti al corso:<br></h5>
                    <c:forEach var="discente" items="${corso.discenti}">
                        ${discente.nome} ${discente.cognome}<br/>
                    </c:forEach>
                </div>
                <div class="opzioni">
                    <a href="<c:url value='/corsi/${corso.id}/edit'/>">
                        <div class="modifica">Modifica</div>
                    </a>
                    <a href="<c:url value='/corsi/${corso.id}/delete'/>" onclick="return confirm('Sei sicuro?')">
                        <div class="elimina">Elimina</div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
