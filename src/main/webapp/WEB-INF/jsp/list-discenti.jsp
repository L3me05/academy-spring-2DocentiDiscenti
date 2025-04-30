<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <title>Elenco Docenti</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">
<h1>Elenco Discenti</h1>

<a class="btn btn-primary mb-3" href="<c:url value='/discenti/new'/>">Nuovo Studente</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th><th>nome</th><th>cognome</th><th>matricola</th><th>età</th><th>città di residenza</th><th>Azioni</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="d" items="${discenti}">
        <tr>
            <td>${d.id}</td>
            <td>${d.nome}</td>
            <td>${d.cognome}</td>
            <td>${d.matricola}</td>
            <td>${d.eta}</td>
            <td>${d.cittaResidenza}</td>
            <td>
                <a class="btn btn-sm btn-secondary" href="<c:url value='/docenti/${d.id}/edit'/>">Modifica</a>
                <a class="btn btn-sm btn-danger"
                   href="<c:url value='/docenti/${d.id}/delete'/>"
                   onclick="return confirm('Sei sicuro?')">Elimina</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
