<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista Docenti</title>
</head>
<body>
    <h1>Elenco Docenti</h1>
    <a href="/docenti/nuovo">Aggiungi Docente</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Azioni</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="docente" items="${docenti}">
            <tr>
                <td>${docente.id}</td>
                <td>${docente.nome}</td>
                <td>${docente.cognome}</td>
                <td>
                    <a href="/docenti/${docente.id}/edit">Modifica</a> |
                    <a href="/docenti/${docente.id}/delete">Elimina</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
