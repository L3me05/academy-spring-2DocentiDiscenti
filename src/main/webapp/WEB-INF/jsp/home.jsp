<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
    <div class="card">
        <div class="header">
            <h2>Scegli il menu che desideri</h2>
        </div>

        <div class="body">
            <div class="menu-item">
                <a href="<c:url value='/docenti/lista'/>" class="menu-link">Form Docente</a>
            </div>
            <div class="menu-item">
                <a href="<c:url value='/discenti/list'/>" class="menu-link">Form Studente</a>
            </div>
            <div class="menu-item">
                <a href="<c:url value='/corsi/list'/>" class="menu-link">Form Corso</a>
            </div>
        </div>
    </div>
</body>
</html>
