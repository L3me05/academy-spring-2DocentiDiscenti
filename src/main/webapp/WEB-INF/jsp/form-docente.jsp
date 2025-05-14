<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8" />
    <title>Form Docente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form-docente.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="<c:url value='/home'/>">Gestione Docenti</a>
            <div class="d-flex">
                <a class="navbar-link" href="<c:url value='/home'/>">Home</a>
                <a class="navbar-link ms-3" href="<c:url value='/docenti/lista'/>">Lista Docenti</a>
                <a class="navbar-link ms-3" href="<c:url value='/discenti/list'/>">Studenti</a>
            </div>
        </div>
    </nav>

    <div class="container mt-5 mb-5">
        <div class="card">
            <div class="card-header bg-primary text-white text-center">
                <h1 class="mb-0">Crea Nuovo Docente</h1>
            </div>
            <div class="card-body">
                <form:form action="${pageContext.request.contextPath}/docenti" method="post" modelAttribute="docente">
                    <form:hidden path="id" />

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

                    <div class="mt-4 text-end">
                        <button type="submit" class="btn btn-primary">Salva Docente</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
