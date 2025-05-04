<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Form Studente</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

        <!-- Bootstrap CSS v5.3.3 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>


    </head>

    <body>
        <div class="container mt-5">
            <div class="card">
                <div class="card-header">
                    <h1>Form Studente</h1>
                </div>
                <div class="card-body">
                    <!-- Spring Form -->
                    <form:form action="${pageContext.request.contextPath}/discenti" method="post" modelAttribute="discente">
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
                        <div class="mb-3">
                            <form:label path="matricola" cssClass="form-label">Matricola</form:label>
                            <form:input path="matricola" type="number" cssClass="form-control" required="true"/>
                            <form:errors path="matricola" cssClass="text-danger" />
                        </div>
                        <div class="mb-3">
                            <form:label path="eta" cssClass="form-label">Età</form:label>
                            <form:input path="eta" type="number" cssClass="form-control" required="true"/>
                            <form:errors path="eta" cssClass="text-danger" />
                        </div>
                        <div class="mb-3">
                            <form:label path="cittaResidenza" cssClass="form-label">Città di Residenza</form:label>
                            <form:input path="cittaResidenza" cssClass="form-control" required="true"/>
                            <form:errors path="cittaResidenza" cssClass="text-danger" />
                        </div>

                        <button type="submit" class="btn btn-primary">Invia</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
