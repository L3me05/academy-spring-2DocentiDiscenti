<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8" />
    <title>Gestione Corso</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form-corso.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="<c:url value='/home'/>">Gestione Corsi</a>
            <div class="d-flex">
                <a class="navbar-link" href="<c:url value='/home'/>">Home</a>
                <a class="navbar-link ms-3" href="<c:url value='/docenti/lista'/>">Docenti</a>
                <a class="navbar-link ms-3" href="<c:url value='/discenti/list'/>">Discenti</a>
                <a class="navbar-link ms-3" href="<c:url value='/corsi/list'/>">Corsi</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5 mb-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h1 class="mb-0">Gestione Corso</h1>
            </div>
            <div class="card-body">
                <form:form action="${pageContext.request.contextPath}/corsi" method="post" modelAttribute="corso">
                    <form:hidden path="id" />

                    <div class="mb-3">
                        <form:label path="nome" cssClass="form-label">Nome del Corso</form:label>
                        <form:input path="nome" cssClass="form-control" required="true"/>
                        <form:errors path="nome" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="annoAccademico" cssClass="form-label">Anno Accademico</form:label>
                        <form:input path="annoAccademico" type="number" cssClass="form-control" required="true"/>
                        <form:errors path="annoAccademico" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="docenteId" cssClass="form-label">Docente</form:label>
                        <form:select path="docenteId" cssClass="form-select">
                            <form:option value="" label="-- Seleziona un docente --" />
                            <form:options items="${docenti}" itemValue="id" itemLabel="nome" />
                        </form:select>
                    </div>

                    <div class="mb-3">
                        <form:label path="discenti" cssClass="form-label">Discenti (partecipanti)</form:label>
                        <div class="row">
                            <c:forEach var="d" items="${discenti}">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="discentiIds" value="${d.id}" cssClass="form-check-input" id="discente-${d.id}" />
                                        <label class="form-check-label" for="discente-${d.id}">
                                            ${d.nome} ${d.cognome}
                                        </label>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="mt-4 text-end">
                        <button type="submit" class="btn btn-primary">Salva Corso</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>