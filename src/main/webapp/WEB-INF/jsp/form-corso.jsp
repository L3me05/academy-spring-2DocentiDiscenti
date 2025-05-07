<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Form Corso</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>
<div class="container mt-5">
    <a class="btn btn-primary mb-3" href="<c:url value='/home'/>">Home</a>

    <div class="card">
        <div class="card-header">
            <h1>Form Studente</h1>
        </div>
        <div class="card-body">
            <!-- Spring Form -->
            <form:form action="${pageContext.request.contextPath}/corsi" method="post" modelAttribute="corso">
                <form:hidden path="id" />

                <div class="mb-3">
                    <form:label path="nome" cssClass="form-label">Nome</form:label>
                    <form:input path="nome" cssClass="form-control" required="true"/>
                    <form:errors path="nome" cssClass="text-danger" />
                </div>

                <div class="mb-3">
                    <form:label path="annoAccademico" cssClass="form-label">Anno accademico</form:label>
                    <form:input path="annoAccademico" type="number" cssClass="form-control" required="true"/>
                    <form:errors path="annoAccademico" cssClass="text-danger" />
                </div>

                <!-- Select Docente -->
                <div class="mb-3">
                    <form:label path="docente.id" cssClass="form-label">Docente</form:label>
                    <form:select path="docente.id" cssClass="form-select">
                        <form:options items="${docenti}" itemValue="id" itemLabel="nome" />
                    </form:select>
                </div>

                <!-- Select Multiplo di Discenti -->
                <div class="mb-3">
                    <form:label path="discenti" cssClass="form-label">Discenti (multi)</form:label>
                    <c:forEach var="d" items="${discenti}">
                        <div class="form-check">
                            <form:checkbox path="discenti" value="${d.id}" cssClass="form-check-input" id="discente-${d.id}" />
                            <label class="form-check-label" for="discente-${d.id}">
                                ${d.nome} ${d.cognome}
                            </label>
                        </div>
                    </c:forEach>
                </div>

                <button type="submit" class="btn btn-primary">Invia</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
