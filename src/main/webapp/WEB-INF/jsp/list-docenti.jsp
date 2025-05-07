<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Elenco Docenti</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">
<h1>Elenco Docenti</h1>
<a class="btn btn-primary mb-3" href="<c:url value='/home'/>">Home</a>
<a class="btn btn-primary mb-3" href="<c:url value='/docenti/lista'/>">Lista completa</a>
<a class="btn btn-primary mb-3" href="<c:url value='/docenti/new'/>">Nuovo Docente</a>

<form action="${pageContext.request.contextPath}/docenti/cerca" method="get" class="mb-4">
    <div class="input-group">
        <input type="text" name="nome" class="form-control" placeholder="Cerca per nome" required>
        <button type="submit" class="btn btn-outline-primary">Cerca</button>
    </div>
</form>


<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th><th>nome</th><th>cognome</th><th>dataNascita</th><th>Azioni</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="d" items="${docenti}">
            <tr>
                <td>${d.id}</td>
                <td>${d.nome}</td>
                <td>${d.cognome}</td>
                <td>${d.dataNascita}</td>
                <td>
                    <a class="btn btn-sm btn-secondary" href="<c:url value='/docenti/${d.id}/edit'/>">Modifica</a>
                    <a class="btn btn-sm btn-danger"
                       href="<c:url value='/docenti/${d.id}/delete'/>"
                       onclick="return confirm('Sei sicuro?')">Elimina</a>
                </td>
            </tr>
        </c:forEach>

        <div>
            <h5>I docenti sono: ${numDocenti}</h5>
        </div>
    </tbody>
</table>
</body>
</html>
