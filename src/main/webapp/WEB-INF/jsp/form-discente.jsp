<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8" />
    <title>Crea Studente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form-discente.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="<c:url value='/home'/>">Gestione Studenti</a>
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
            <div class="card-header bg-primary text-white text-center">
                <h1 class="mb-0">Crea Nuovo Studente</h1>
            </div>
            <div class="card-body">
                <form:form action="${pageContext.request.contextPath}/discenti" method="post" modelAttribute="discente">
                    <form:hidden path="id" />
                    <!-- Nome -->
                    <div class="mb-3">
                        <form:label path="nome" cssClass="form-label">Nome</form:label>
                        <form:input path="nome" cssClass="form-control" required="true"/>
                        <form:errors path="nome" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="cognome" cssClass="form-label">Cognome</form:label>
                        <form:input path="cognome" cssClass="form-control" required="true"/>
                        <form:errors path="cognome" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="matricola" cssClass="form-label">Matricola</form:label>
                        <form:input path="matricola" type="number" cssClass="form-control" required="true"/>
                        <form:errors path="matricola" cssClass="text-danger" />
                    </div>

                    <div class="mb-3">
                        <form:label path="cittaResidenza" cssClass="form-label">Città di Residenza</form:label>
                        <form:input path="cittaResidenza" cssClass="form-control" required="true"/>
                        <form:errors path="cittaResidenza" cssClass="text-danger" />
                    </div>

                    <div class="mt-4 text-end">
                        <button type="submit" class="btn btn-primary">Crea Studente</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
