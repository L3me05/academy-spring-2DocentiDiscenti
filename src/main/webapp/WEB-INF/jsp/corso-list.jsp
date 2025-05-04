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
    <div class="conteiner">
        <div class="nav">
            <button>Home</button>
            <button>Studente</button>
            <button>Docente</button>
            <button>Corso</button>
        </div>


        <div class="card-container">
            <c:forEach var="corso" items="${corsi}">
                <div class="card">
                    <div class="corso">${corso.id} ${corso.nome} ${corso.annoAccademico} </div>
                    <div class="docente">
                        <c:if test="${not empty corso.docente}">
                            ${corso.docente.nome} ${corso.docente.cognome}
                        </c:if>
                    </div>
                    <div class="studenti">
                        <c:forEach var="discente" items="${corso.discenti}">
                            ${discente.nome} ${discente.cognome}<br/>
                        </c:forEach>
                    </div>
                    <div class="opzioni">
                        <div class="modifica">Modifica</div>
                        <div class="elimina">Elimina</div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <button class="btn">Nuovo</button>
    </div>



</body>
</html>