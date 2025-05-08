<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Corsi</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/corso-list.css">
</head>
<body>
    <div class="container">
        <div class="nav">
            <a href="<c:url value='/home'/>"><button>Home</button></a>
            <a href="<c:url value='/docenti/lista'/>"><button>Studente</button></a>
            <a href="<c:url value='/discenti/list'/>"><button>Docente</button></a>
            <a href="<c:url value='/corsi/list'/>"><button>Corso</button></a>

        </div>

        <a href="<c:url value='/corsi/new'/>">
                    <button class="btn">Nuovo Corso</button>
        </a>

        <div class="card-container">
            <c:forEach var="corso" items="${corsi}">
                <div class="card">
                    <div class="corso">${corso.id} ${corso.nome} ${corso.annoAccademico} </div>
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