<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Form Docente</title>
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
                    <h1>Form Docente</h1>
                </div>
                <div class="card-body">
                    <!-- Spring Form -->
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
                        <div class="mb-3">
                            <form:label path="dataNascita" cssClass="form-label">Data di nascita</form:label>
                            <form:input path="dataNascita" type="date" cssClass="form-control" required="true"/>
                            <form:errors path="dataNascita" cssClass="text-danger" />
                        </div>
                        <button type="submit" class="btn btn-primary">Invia</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
